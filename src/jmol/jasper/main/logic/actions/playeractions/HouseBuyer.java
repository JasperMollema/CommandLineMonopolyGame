package jmol.jasper.main.logic.actions.playeractions;

import jmol.jasper.MonopolyBoard.BoardSpaces.Street;
import jmol.jasper.MonopolyBoard.Data.Bank;
import jmol.jasper.Player.Logic.Player;

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



//    public boolean buyHouseOrHotel(Street street) {
//        // Calculate how many houses the player can buy (can only be 1 or 2).
//        int amtCanBeBought = 3;
//        int amountToBeBought = getHowManyToBeBought(street, amtCanBeBought);
//        if (amountToBeBought == 0) {
//            return false;
//        }
//
//        else if (street.getNumberOfHouses() == 4 ) {
//            buyHotel(street, amountToBeBought);
//        }
//
//        else if (street.getNumberOfHouses() == 3 && amountToBeBought == 2) {
//            buyHouse(street,1);
//            buyHotel(street, 1);
//        }
//
//        else {
//            buyHouse(street, amountToBeBought);
//        }
//
//        return true;
//    }
//
//    private int getHowManyToBeBought(Street street, int amountCanBeBought) {
//
//    }
//
//    private void buyHotel(Street street, int amount) {
//        if (bank.getNrOfHotels() < amount) {
//            System.out.println("De bank heeft geen hotels meer!");
//            return;
//        }
//        if ((!player.canAffordPayment(street.PRICE_HOUSE * amount))) {
//            System.out.println("Je hebt niet genoeg geld!");
//            return;
//        }
//
//        if (verifyBuy(street, amount, true))
//
//            bank.buyHotel(amount);
//        player.payMoney(street.PRICE_HOUSE * amount);
//        street.buyHouses(amount);
//        confirmBuy(street, amount, true);
//        filterStreets();
//    }
//
//    private void buyHouse(Street street, int amount) {
//        bank.getNrOfHouses(); bank.buyHouses(bank.getNrOfHouses());
//        if (bank.getNrOfHouses() < amount) {
//            System.out.println("De bank heeft niet genoeg huizen!");
//            return;
//        }
//        if ((!player.canAffordPayment(street.PRICE_HOUSE * amount))) {
//            System.out.println("Je hebt niet genoeg geld!");
//            return;
//        }
//
//        if (!verifyBuy(street, amount, false)) {
//            return;
//        }
//
//        bank.buyHouses(amount);
//        player.payMoney(street.PRICE_HOUSE * amount);
//        street.buyHouses(amount);
//        confirmBuy(street, amount, false);
//        filterStreets();
//    }
//
//
//
//    private void confirmBuy(Street street, int amount, boolean isHotel) {
//        if (isHotel) {
//            System.out.println(player.getName() + " heeft een hotel gekocht voor " + street.getName());
//        }
//        else if (amount > 1) {
//            System.out.println(player.getName() + " heeft " + amount +
//                    " huizen gekocht voor " + street.getName());
//        }
//        else {
//            System.out.println(player.getName() + " heeft een huis gekocht voor " + street.getName());
//        }
//    }
//
//    private boolean verifyBuy() {return true;}
//
//    private void filterStreets() {
//        streetsWhereHousesCanBeBought.clear();
//        for (Street street : ownedStreets) {
//            if (verifyBuy()) {
//                streetsWhereHousesCanBeBought.add(street);
//            }
//            else {
//                streetsWhereHousesCanBeBought.remove(street);
//            }
//        }
//    }
}
