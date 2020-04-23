package jmol.jasper.main.logic.actions.playeractions;

import jmol.jasper.MonopolyBoard.BoardSpaces.Street;
import jmol.jasper.UserInterface.Logic.ExpressionProvider;

import java.util.List;

public class BuySellHousesUserInterface {
    public int askPlayerHowManyHousesToBuy(String streetName, TransactionType transactionType) {
        String[] options = new String[2];
        options[0] = "1 huis";
        String question;

        if (TransactionType.TWO_HOUSES.equals(transactionType)) {
            options[1] = "2 huizen";
            question = "Wil 1 of 2 huizen kopen voor " + streetName;
        }

        else if (TransactionType.HOUSE_AND_HOTEL.equals(transactionType)) {
            options[1] = "een huis en hotel";
            question = "Wil je 1 huis kopen of 1 huis en 1 hotel voor " + streetName;
        }

        else {
            return -1;
        }

        int choice = ExpressionProvider.getInstance().getOption(options, question);
        return choice + 1;
    }

    public Street askPlayerWhichStreetToBuyOrSellHouses(List<Street> streetsWherePlayerCanBuyOrSellHouses) {
        String question = "Voor welke straat wil je huizen kopen?";
        Street[] streets = BuySellHouseHelper.convertStreetListToArray(streetsWherePlayerCanBuyOrSellHouses);
        String[] streetOptions = new String[streets.length];

        for (int i = 0; i<streets.length; i++) {
            streets[i].printNumberOfHouses();
            streetOptions[i] = streets[i].getName();
            }

        int choice = ExpressionProvider.getInstance().getOption(streetOptions, question);
        return streets[choice];
    }

    public void printBankHasNoHouses() {
        System.out.println("De bank heeft geen huizen en hotels meer!");
    }

    public void printNotEnoughMoney(TransactionType transactionType, Street street) {
        System.out.println(
                "Je hebt niet genoeg geld om "
                + transactionType.toString()
                + " te kopen voor "
                + street.getName()
        );
    }

    public boolean wantsToBuyMore() {
        return ExpressionProvider.getInstance().getBoolean("Wil je meer huizen kopen?");
    }

    public boolean verifyBuy(TransactionType transactionType, Street street) {
        return ExpressionProvider.getInstance().getBoolean(
                "Weet je zeker je dat je "
                        + transactionType
                        + " wil kopen voor "
                        + street.getName()
        );
    }

    public void confirmBuy(TransactionType transactionType, Street street) {
        System.out.println("Je hebt " + transactionType + " gekocht voor " + street.getName());
    }
}
