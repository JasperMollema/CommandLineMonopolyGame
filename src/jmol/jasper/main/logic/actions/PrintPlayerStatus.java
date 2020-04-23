package jmol.jasper.main.logic.actions;

import jmol.jasper.MonopolyBoard.BoardSpaces.Property;
import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.MonopolyGame.Actions.PlayerActions.PlayerAction;
import jmol.jasper.Player.Logic.Player;

public class PrintPlayerStatus implements PlayerAction {

    @Override
    public void handleAction(Player player) {
        StringBuilder playerStatus = new StringBuilder(player.getName());
        playerStatus.append(" staat op ");
        playerStatus.append(MonopolyBoardData.getBoardspace(player.getBoardspaceNr()).getName());
        playerStatus.append(" en heeft ");
        playerStatus.append(player.getAmountOfMoney() + " euro.");
        playerStatus.append(System.lineSeparator());
        if (player.getProperties().isEmpty()) {
            playerStatus.append(player.getName() + " heeft geen bezittingen.");
        }
        else {
            playerStatus.append(player + " heeft de volgende bezittingen:");
            for (Property property : player.getProperties()){
                playerStatus.append(System.lineSeparator());
                playerStatus.append(property.toString());
            }
        }
        playerStatus.append(System.lineSeparator());
        System.out.println(playerStatus.toString());
    }
}
