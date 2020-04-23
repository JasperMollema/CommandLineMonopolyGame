package jmol.jasper.main.logic.actions.playeractions;

import jmol.jasper.MonopolyBoard.BoardSpaces.Street;
import jmol.jasper.MonopolyBoard.Data.Bank;
import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.ExpressionProvider;

import java.util.List;

public class BuySellHouseHelper {


    public static Street[] convertStreetListToArray(List<Street> streetList) {
        Street[] ownedStreets = new Street[streetList.size()];
        int i = 0;
        for (Street street : streetList) {
            ownedStreets[i] = street;
            i++;
        }
        return ownedStreets;
    }

    public static boolean onlyStreetWithAmtHouses(List<Street> streets, int amountHouses) {
        int sum = 0;
        for (Street street: streets) {
            if (street.getNumberOfHouses() == amountHouses) {
                sum += 1;
            }
        }
        return sum == 1;
    }

    public static boolean everyStreetSameAmtHouses(List<Street> streets) {
        int amtHouses = streets.get(0).getNumberOfHouses();
        for (Street street : streets) {
            if (street.getNumberOfHouses() != amtHouses) {
                return false;
            }
        }
        return true;
    }

    public static boolean onlyOneStreetWithHouses(List<Street> streets) {
        int sum = 0;
        for (Street street : streets) {
            if (street.getNumberOfHouses() > 0) {
                sum += 1;
            }
        }
        return sum == 1;
    }

    public static int getMinAmtOfHousesInCity(List<Street> streets) {
        int minAmountOfHouses = streets.get(0).getNumberOfHouses();
        for (Street street: streets) {
            if (street.getNumberOfHouses() < minAmountOfHouses) {
                minAmountOfHouses = street.getNumberOfHouses();
            }
        }
        return minAmountOfHouses;
    }

    public static int getMaxAmtOfHousesInCity(List<Street> streets) {
        int maxAmtOfHouses = streets.get(0).getNumberOfHouses();
        for (Street street: streets) {
            if (street.getNumberOfHouses() > maxAmtOfHouses) {
                maxAmtOfHouses = street.getNumberOfHouses();
            }
        }
        return maxAmtOfHouses;
    }

    public static List<Street> askForWhichCity(Bank bank, Player player) {
        List<MonopolyBoardData.BoardspaceType> cities = bank.getOwnedCitiesBoardSpaceTypes(player);
        String[] ownedCities = new String[cities.size()];

        if (cities == null) {
            return null;
        }

        for (int i = 0; i < cities.size(); i++) {
            ownedCities[i] = cities.get(i).getName();
        }
        int cityIndex = ExpressionProvider.getInstance().getOption(ownedCities, "Voor welke stad?");
        return bank.getOwnedStreetsOfCity(player, cities.get(cityIndex));
    }
}
