package jmol.jasper.main.logic.actions.boardspaceactions;

import jmol.jasper.MonopolyBoard.BoardSpaces.Jail;
import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.ExpressionProvider;

public class GoToJailBoardSpaceAction implements BoardSpaceAction {

    @Override
    public void handleAction(Player player) {
        Jail prison = (Jail) MonopolyBoardData.getBoardspace(MonopolyBoardData.SPACENR_GEVANGENIS);
        if (player.hasGetOutOfJailCard()) {
            boolean playGetOutOfJailCard = ExpressionProvider.getInstance().getBoolean(
                    "Wil je een 'ga uit de gevangenis' kaart spelen?");
            if (playGetOutOfJailCard) {
                player.playGetOutOfJailCard();
                return;
            }
        }
        prison.imprisonPlayer(player);
    }
}
