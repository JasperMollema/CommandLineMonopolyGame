package jmol.jasper.main.logic.actions;

import jmol.jasper.MonopolyBoard.BoardSpaces.Boardspace;
import jmol.jasper.MonopolyBoard.Data.Bank;
import jmol.jasper.MonopolyGame.BoardSpaceActions.BoardSpaceAction;
import jmol.jasper.Player.Logic.Player;

public abstract class PlayerBoardSpaceAction implements BoardSpaceAction {
    protected Bank bank;
    protected Player player;
    /**
     * The boardspace to which the player should move.
     */
    protected Boardspace nextBoardspace;

    public PlayerBoardSpaceAction(Player player, Boardspace nextBoardspace) {
        this.player = player;
        this.nextBoardspace = nextBoardspace;
        bank = new Bank();
    }

    public abstract void handleAction();
}
