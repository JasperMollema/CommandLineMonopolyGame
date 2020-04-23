package jmol.jasper.main.data.boardspaces;

import jmol.jasper.main.data.miscellaneous.MonopolyBoardData;
import jmol.jasper.main.logic.actions.boardspaceactions.BoardSpaceAction;
import jmol.jasper.main.logic.actions.boardspaceactions.BuyPropertyBoardSpaceAction;
import jmol.jasper.main.logic.actions.boardspaceactions.PayRentBoardSpaceAction;
import jmol.jasper.main.logic.player.Player;

public abstract class Property extends Boardspace {
    public final int VALUE;

    protected Player owner;

    public Property(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType, int value) {
        super(name, spaceNr, boardspaceType);
        VALUE = value;
    }

    @Override
    public BoardSpaceAction getBoardspaceAction(){
        if (owner == null) {
            return new BuyPropertyBoardSpaceAction();
        } else
            return new PayRentBoardSpaceAction();
    }

    public void buyProperty(Player player) {
        owner = player;
    }

    public abstract int calculateRent();

    public Player getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return name;
    }
}
