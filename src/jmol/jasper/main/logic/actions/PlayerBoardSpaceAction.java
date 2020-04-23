package jmol.jasper.main.logic.actions;

import jmol.jasper.main.data.boardspaces.Boardspace;
import jmol.jasper.main.data.miscellaneous.Bank;
import jmol.jasper.main.logic.actions.boardspaceactions.BoardSpaceAction;
import jmol.jasper.main.logic.player.Player;

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
