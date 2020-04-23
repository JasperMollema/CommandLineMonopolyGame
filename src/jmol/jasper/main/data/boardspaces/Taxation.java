package jmol.jasper.main.data.boardspaces;

import jmol.jasper.main.data.miscellaneous.MonopolyBoardData;
import jmol.jasper.main.logic.actions.boardspaceactions.BoardSpaceAction;

public class Taxation extends Boardspace {
    private int taxAmount;

    public Taxation(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType, int taxAmount) {
        super(name, spaceNr, boardspaceType);
        this.taxAmount = taxAmount;
    }

    @Override
    public BoardSpaceAction getBoardspaceAction() {
        visitor.payMoney(taxAmount);
        System.out.println(visitor.getName() + " moet " + taxAmount + " belasting betalen!");
        return null;
    }
}
