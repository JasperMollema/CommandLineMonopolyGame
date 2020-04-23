package jmol.jasper.main.logic.game;

import jmol.jasper.MonopolyBoard.BoardSpaces.Boardspace;
import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.ExpressionProvider;

import java.util.HashMap;
import java.util.Map;

public class GameSetup {
    private Player[] players;
    private Integer numberOfPlayers;
    private Map<Player, Boardspace> playerBoardspaceMap;
    private final int MAX_PLAYERS = 6;
    private final int MIN_PLAYERS = 2;
    private final int MIN_NAME_LENGHT = 1;
    private final int MAX_NAME_LENGHT = 12;

    public GameSetup() {
        playerBoardspaceMap = new HashMap<>();
    }

    public Game createGame() {
        setupGame();
        return new Game(this);
    }

    private void setupGame(){
        System.out.println("Welkom bij Monopoly!");
        createPlayers();
        for (Player player : players) {
            // Put all the players on the start space.
            playerBoardspaceMap.put(player, MonopolyBoardData.getBoardspace(MonopolyBoardData.SPACENR_START));
        }
    }

    private boolean createPlayers() {
        determineNumberOfPlayers();
        players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++){
            players[i] = createPlayer(i + 1);
        }
        return true;
    }

    private Player createPlayer(int playerNo) {
        String name = getPlayerName(playerNo);
        System.out.println(name + " is toegevoegd!");
        return new Player(name);
    }

    private void determineNumberOfPlayers() {
        numberOfPlayers = ExpressionProvider.getInstance().getNumberWithinBoundary(
                "Met hoeveel spelers wil je spelen?",
                MIN_PLAYERS,
                MAX_PLAYERS,
                "Er kunnen minimaal " + MIN_PLAYERS + " en maximaal " + MAX_PLAYERS + " spelen."
        );
    }

    private String getPlayerName(int playerNo) {
        return ExpressionProvider.getInstance().getString(
                "Wat is de naam van speler " + playerNo + "?",
                MIN_NAME_LENGHT,
                MAX_NAME_LENGHT,
                "Een naam mag niet leeg zijn of langer dan 12 tekens"
        );
    }

    public Player[] getPlayers() {
        return players;
    }

    public Map<Player, Boardspace> getPlayerBoardspaceMap() {
        return playerBoardspaceMap;
    }
}
