package jmol.jasper.main.logic.actions.boardspaceactions;

import jmol.jasper.main.logic.player.Player;

public class GoThreePlacesBackBoardSpaceAction extends CardAction {

    @Override
    public void handleAction(Player player) {
        player.moveToBoardspace(
                determineNewBoardSpaceNr(player.getBoardspaceNr()));
    }

    private int determineNewBoardSpaceNr(int currentBoardSpaceNr) {
        int newBoardSpaceNr = currentBoardSpaceNr - 3;
        if (newBoardSpaceNr < 0) {
            newBoardSpaceNr += 40;
        }
        return newBoardSpaceNr;
    }
}
