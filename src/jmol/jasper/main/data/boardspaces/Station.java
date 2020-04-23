package jmol.jasper.main.data.boardspaces;

import jmol.jasper.MonopolyBoard.Data.Bank;
import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;

public class Station extends Property {

    public Station(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType, int value) {
        super(name, spaceNr, boardspaceType, value);
    }


    @Override
    public int calculateRent() {
        return 25 * new Bank().getNrOFStationsOwned(owner);
    }
}
