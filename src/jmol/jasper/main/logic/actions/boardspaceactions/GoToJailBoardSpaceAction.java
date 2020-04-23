package jmol.jasper.main.logic.actions.boardspaceactions;

import jmol.jasper.main.data.boardspaces.Jail;
import jmol.jasper.main.data.miscellaneous.MonopolyBoardData;
import jmol.jasper.main.logic.player.Player;
import jmol.jasper.main.userinterface.ExpressionProvider;

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
