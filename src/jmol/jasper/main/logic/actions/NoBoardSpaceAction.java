package jmol.jasper.main.logic.actions;

import jmol.jasper.MonopolyGame.Actions.PlayerActions.PlayerAction;
import jmol.jasper.Player.Logic.Player;

public class NoBoardSpaceAction implements PlayerAction {

    @Override
    public void handleAction(Player player) {
        return;
    }
}
