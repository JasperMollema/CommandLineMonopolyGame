package jmol.jasper.main.data.boardspaces;

import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.MonopolyGame.BoardSpaceActions.BoardSpaceAction;
import jmol.jasper.Player.Logic.Player;

import java.util.HashMap;
import java.util.Map;

public class Jail extends Boardspace {
    private Map<Player, Integer> prisoners;

    public Jail(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
        prisoners = new HashMap<>();
    }

    @Override
    public BoardSpaceAction getBoardspaceAction() {
        System.out.println("Alleen op bezoek!");
        return null;
    }

    public void addRound(Player player) {
        int nrOfRoundsInPrison = prisoners.get(player);
        prisoners.put(player, nrOfRoundsInPrison + 1);
    }

    public void imprisonPlayer(Player player) {
        System.out.println(player + " zit in nu de gevangenis!");
        prisoners.put(player, 0);
    }

    public boolean isPlayerImprisoned(Player player) {
        boolean imprisoned = prisoners.containsKey(player);
        if (imprisoned) {
            System.out.println(player + " zit in de gevangenis!");
        }
        return imprisoned;
    }

    public void releasePlayer(Player player) {
        System.out.println(player + " mag uit de gevangenis!");
        prisoners.remove(player);
    }

    public boolean hasServedSentence(Player player) {
        boolean timeServed = prisoners.get(player) == 3;
        if (timeServed) {
            System.out.println(player + " heeft zijn straf uitgezeten");
            releasePlayer(player);
        }
        return timeServed;
    }
}
