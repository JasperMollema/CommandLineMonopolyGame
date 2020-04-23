package jmol.jasper.main.data.boardspaces;

import jmol.jasper.main.data.miscellaneous.Bank;
import jmol.jasper.main.data.miscellaneous.MonopolyBoardData;
import jmol.jasper.main.logic.player.Player;

public class Street extends Property {
    public final int PRICE_HOUSE;
    public final int RENT_NO_HOUSES;
    public final int RENT_1_HOUSE;
    public final int RENT_2_HOUSES;
    public final int RENT_3_HOUSES;
    public final int RENT_4_HOUSES;
    public final int RENT_HOTEL;
    private int numberOfHouses;

    public Street(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType, int value, int priceHouse, int[] rents) {
        super(name, spaceNr, boardspaceType, value);
        PRICE_HOUSE = priceHouse;
        RENT_NO_HOUSES = rents[0];
        RENT_1_HOUSE = rents[1];
        RENT_2_HOUSES = rents[2];
        RENT_3_HOUSES = rents[3];
        RENT_4_HOUSES = rents[4];
        RENT_HOTEL = rents[5];
    }

    @Override
    public int calculateRent() {
        int rent = 0;
        switch (numberOfHouses) {
            case 0: rent = calculateRentNoHouses();
            break;
            case 1: rent = RENT_1_HOUSE;
            break;
            case 2: rent = RENT_2_HOUSES;
            break;
            case 3: rent = RENT_3_HOUSES;
            break;
            case 4: rent = RENT_4_HOUSES;
            break;
            case 5: rent = RENT_HOTEL;
            break;
        }
        return rent;
    }

    @Override
    public void buyProperty(Player player) {
        super.buyProperty(player);
    }

    public void buyHouses(int amount) {
        numberOfHouses += amount;
    }

    public void sellAllHouses() {
        sellHouses(numberOfHouses);
    }

    public void sellHouses(int amount) {
        numberOfHouses -= amount;
        owner.receiveMoney(amount * PRICE_HOUSE / 2);
    }

    private int calculateRentNoHouses() {
        if (new Bank().getOwnesAllTypes(this, owner)) {
            return 2 * RENT_NO_HOUSES;
        }
        return RENT_NO_HOUSES;
    }

    public void printNumberOfHouses() {
        if (numberOfHouses == 1) {
            System.out.println("Op " + name + " staat 1 huis.");
        }
        else {
            System.out.println("Op " + name + " staan " + numberOfHouses + " huizen.");
        }

    }

    public int getNumberOfHouses() {
        return numberOfHouses;
    }

    @Override
    public String toString() {
        return name + ", met " + numberOfHouses + " huizen.";
    }
}
