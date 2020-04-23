package jmol.jasper.main.logic.actions.playeractions;

import jmol.jasper.main.data.boardspaces.Street;
import jmol.jasper.main.data.miscellaneous.Bank;
import jmol.jasper.main.logic.player.Player;

import java.util.List;

public class HouseBuyer {
    private static int MAX_AMOUNT_OF_HOUSES = 5;
    private Bank bank;
    private boolean hasBankHouses;
    private boolean hasBankHotels;
    private boolean hasBankTwoHouses;

    public HouseBuyer(Bank bank) {
        this.bank = bank;
    }

    public int determineHowManyHousesCanBeBought(Street street, List<Street> city) {
        int currentAmtHouses = street.getNumberOfHouses();
        int minHouseInCity = BuySellHouseHelper.getMinAmtOfHousesInCity(city);
        boolean onlyOneMin = BuySellHouseHelper.onlyStreetWithAmtHouses(city, minHouseInCity);
        int amount = 1;

        if (currentAmtHouses == minHouseInCity && onlyOneMin) {
            amount = 2;
        }

        if (currentAmtHouses > minHouseInCity) {
            amount = 0;
        }

        if ((currentAmtHouses + amount) > MAX_AMOUNT_OF_HOUSES) {
            amount = MAX_AMOUNT_OF_HOUSES - currentAmtHouses;
        }
        return amount;
    }

    public TransactionType determineTransactionType(Street streetToBuyHouses, int amountToBuy) {
        int housesOnStreet = streetToBuyHouses.getNumberOfHouses();

        if (isIllegalTransaction(streetToBuyHouses, amountToBuy)) {
            return TransactionType.NO_TRANSACTION;
        }

        else if (housesOnStreet < 4 && amountToBuy == 1) {
            return TransactionType.ONE_HOUSE;
        }

        else if (housesOnStreet == 4) {
            return TransactionType.HOTEL;
        }

        else if (housesOnStreet == 3 && amountToBuy == 2) {
            return TransactionType.HOUSE_AND_HOTEL;
        }

        else {
            return TransactionType.TWO_HOUSES;
        }
    }

    public boolean hasBankEnoughHousesForTransaction(TransactionType transactionType) {
        setAvailableHousesAndHotels();

        if (TransactionType.ONE_HOUSE.equals(transactionType)) {
            return hasBankHouses;
        }

        if (TransactionType.HOTEL.equals(transactionType)) {
            return hasBankHotels;
        }

        if (TransactionType.HOUSE_AND_HOTEL.equals(transactionType)) {
            return hasBankHouses && hasBankHotels;
        }

        if (TransactionType.TWO_HOUSES.equals(transactionType)) {
            return hasBankTwoHouses;
        }

        return true;
    }

    public boolean hasBankHousesOrHotels() {
        setAvailableHousesAndHotels();
        return hasBankHouses || hasBankHotels;
    }

    public void buyHouses(TransactionType transactionType, Street street, Player player) {
        switch (transactionType) {
            case ONE_HOUSE:
                buyHouse(street, player);
                break;

            case TWO_HOUSES:
                buyHouse(street, player);
                buyHouse(street, player);
                break;

            case HOTEL:
                buyHotel(street, player);
                break;

            case HOUSE_AND_HOTEL:
                buyHouse(street, player);
                buyHotel(street, player);
                break;
        }
    }

    private void buyHouse(Street street, Player player) {
        bank.buyHouses(1);
        player.payMoney(street.PRICE_HOUSE);
        street.buyHouses(1);
    }

    private void buyHotel(Street street, Player player) {
        bank.buyHotel(1);
        player.payMoney(street.PRICE_HOUSE);
        street.buyHouses(1);
    }

    private boolean isIllegalTransaction(Street street, int amountToBuy) {
        return street.getNumberOfHouses() > 4
                || amountToBuy == 0
                || amountToBuy > 2;
    }

    private void setAvailableHousesAndHotels() {
        hasBankHouses = bank.getNrOfHouses() > 0;
        hasBankHotels = bank.getNrOfHotels() > 0;
        hasBankTwoHouses = bank.getNrOfHouses() > 1;
    }
}
