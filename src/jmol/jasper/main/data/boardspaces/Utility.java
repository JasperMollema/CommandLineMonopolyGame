package jmol.jasper.main.data.boardspaces;

import jmol.jasper.main.data.miscellaneous.Bank;
import jmol.jasper.main.data.miscellaneous.MonopolyBoardData;

public class Utility extends Property {

    public Utility(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType, int value) {
        super(name, spaceNr, boardspaceType, value);
    }

    @Override
    public int calculateRent() {
        if (new Bank().getOwnesAllTypes(this, owner)) {
            return diceThrowVisitor * 10;
        }
        else {
            return diceThrowVisitor * 4;
        }
    }
}
