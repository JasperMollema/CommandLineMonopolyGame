package jmol.jasper.main.logic.actions;

import jmol.jasper.main.logic.actions.playeractions.PlayerAction;
import jmol.jasper.main.logic.player.Player;

public class NoBoardSpaceAction implements PlayerAction {

    @Override
    public void handleAction(Player player) {
        return;
    }
}
