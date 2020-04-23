package jmol.jasper.main.logic.actions.playeractions;

import jmol.jasper.MonopolyBoard.BoardSpaces.Street;
import jmol.jasper.MonopolyBoard.Data.Bank;
import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.ExpressionProvider;

import java.util.List;

public class BuyHousesAction implements PlayerAction {
    private Bank bank;
    private HouseBuyer houseBuyer;
    private BuySellHousesUserInterface buySellHousesUserInterface;
    private TransactionType transactionType;
    private boolean hasPerformedTransaction;


    public BuyHousesAction() {
        bank = new Bank();
        buySellHousesUserInterface = new BuySellHousesUserInterface();
        houseBuyer = new HouseBuyer(bank);
    }

    @Override
    public void handleAction(Player player) {
        // If the bank has no houses or hotels, it is not possible to buy any.
        if (!houseBuyer.hasBankHousesOrHotels()) {
            buySellHousesUserInterface.printBankHasNoHouses();
            return;
        }

        if (hasPerformedTransaction && !buySellHousesUserInterface.wantsToBuyMore()) {
            return;
        }

        Street streetToBuyHouses = determineWhichStreetToBuyHouses(player);
        determineTransactionType(streetToBuyHouses);
        int nrOfHousesToBuy = buySellHousesUserInterface.askPlayerHowManyHousesToBuy(streetToBuyHouses.getName(), transactionType);
        transactionType = houseBuyer.determineTransactionType(streetToBuyHouses, nrOfHousesToBuy);

        if (!(player.getAmountOfMoney() < streetToBuyHouses.PRICE_HOUSE * nrOfHousesToBuy)) {
            buySellHousesUserInterface.printNotEnoughMoney(transactionType, streetToBuyHouses);
            hasPerformedTransaction = true;
            handleAction(player);
        }

        if (!buySellHousesUserInterface.verifyBuy(transactionType, streetToBuyHouses)) {
            hasPerformedTransaction = true;
            handleAction(player);
        }

        houseBuyer.buyHouses(transactionType, streetToBuyHouses, player);

        // Confirm the transaction.
        buySellHousesUserInterface.confirmBuy(transactionType, streetToBuyHouses);


    }

    private Street determineWhichStreetToBuyHouses(Player player) {
        List<Street> streetsWherePlayerCanBuyHouses = bank.getOwnedStreetsOfCity(player);
        return buySellHousesUserInterface.askPlayerWhichStreetToBuyOrSellHouses(streetsWherePlayerCanBuyHouses);
    }

    private void determineTransactionType(Street street) {
        List<Street> city = MonopolyBoardData.getCity(street);
        int nrHousesCanBeBought = houseBuyer.determineHowManyHousesCanBeBought(street, city);
        transactionType = houseBuyer.determineTransactionType(street, nrHousesCanBeBought);

        if (nrHousesCanBeBought == 2 && !houseBuyer.hasBankEnoughHousesForTransaction(transactionType)) {
            nrHousesCanBeBought = 1;
            transactionType = houseBuyer.determineTransactionType(street, nrHousesCanBeBought);
        }

        if (!houseBuyer.hasBankEnoughHousesForTransaction(transactionType)) {
            nrHousesCanBeBought = 0;
        }

        transactionType = houseBuyer.determineTransactionType(street, nrHousesCanBeBought);
    }

    private boolean verifySale(Street street, int amount, boolean isHotel) {
        String question;
        if (isHotel) {
            question = "Weet je zeker dat je een hotel wil kopen voor " + street.getName();
        }
        else if (amount == 2) {
            question = "Weet je zeker dat je 2 huizen wil kopen voor " + street.getName();
        }
        else {
            question = "Weet je zeker dat je 1 huis wil kopen voor " + street.getName();
        }
        return ExpressionProvider.getInstance().getBoolean(question);
    }

    private void verifySale(Street street, int amountHouses) {
        if (amountHouses == 0) {
            System.out.println("Je kan geen huizen kopen voor " + street.getName());
        }

        if (amountHouses == 1) {
            System.out.println("Je kan 1 huis kopen voor " + street.getName());
        }
    }
}
