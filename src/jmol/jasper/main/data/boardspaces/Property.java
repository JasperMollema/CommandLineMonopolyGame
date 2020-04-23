package jmol.jasper.main.data.boardspaces;

import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.MonopolyGame.BoardSpaceActions.BoardSpaceAction;
import jmol.jasper.MonopolyGame.BoardSpaceActions.BuyPropertyBoardSpaceAction;
import jmol.jasper.MonopolyGame.BoardSpaceActions.PayRentBoardSpaceAction;
import jmol.jasper.Player.Logic.Player;

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
