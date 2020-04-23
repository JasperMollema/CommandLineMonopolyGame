package jmol.jasper.main.logic.game;

import jmol.jasper.MonopolyBoard.BoardSpaces.Boardspace;
import jmol.jasper.MonopolyBoard.BoardSpaces.Jail;
import jmol.jasper.MonopolyBoard.Data.Bank;
import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.MonopolyGame.Actions.PlayerActions.PlayerAction;
import jmol.jasper.MonopolyGame.Actions.PrintPlayerStatus;
import jmol.jasper.Player.Logic.Player;
import jmol.jasper.UserInterface.Logic.KeuzeMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {
    private List<Player> players;
    private Map<Player, Boardspace> playerBoardspaceMap;
    private int nrOfRounds;
    private Bank bank;
    private KeuzeMenu keuzeMenu;
    private Jail jail;
    private static Player currentPlayer;

    public Game(GameSetup gameSetup){
        players = makeArrayList(gameSetup.getPlayers());
        playerBoardspaceMap = gameSetup.getPlayerBoardspaceMap();
        bank = new Bank();
        bank.fillPlayerlistMap(players);
        keuzeMenu = new KeuzeMenu();
        jail = (Jail) MonopolyBoardData.getBoardspace(MonopolyBoardData.SPACENR_GEVANGENIS);
    }

    public void startGame(){
        while (!gameIsOver()) {
            beginTurn();
            nrOfRounds ++;
        }
        System.out.println(players.get(0) + " heeft gewonnen!");
        printGameStatus();
    }

    private boolean gameIsOver() {
        return players.size() == 1;
    }

    private void beginTurn() {
        for (Player player : players) {
            currentPlayer = player;
            System.out.println(player + " is aan de beurt en staat op " + playerBoardspaceMap.get(player).getName());
            startTurn();
            if (player.isGameOver()) {
                handleGameOver();
            }
        }
    }

    /**
     * Gets a player action
     * @param isBeginTurn
     */
    private void handlePlayerActions(boolean isBeginTurn) {
        PlayerAction playerAction = getPlayerAction(isBeginTurn);
        while (playerAction != null) {
            playerAction.handleAction(currentPlayer);
            playerAction = getPlayerAction(isBeginTurn);
        }
    }

    private PlayerAction getPlayerAction(boolean isBeginTurn) {
        if (isBeginTurn) {
            return keuzeMenu.getChoiceBeforeTurn();
        }
        return keuzeMenu.getChoiceAfterTurn();
    }


    private void handleGameOver() {
        playerBoardspaceMap.remove(currentPlayer);
        players.remove(currentPlayer);
        System.out.println(currentPlayer + " is failliet en doet niet meer mee!");
    }

    private void playTurnWhileInPrison() {
        RoundOfPlay roundOfPlay = new RoundOfPlay(currentPlayer);
        handlePlayerActions(true);
        roundOfPlay.play();
        if (roundOfPlay.canBeReleasedFromPrison()) {
            jail.releasePlayer(currentPlayer);
            putPlayerOnNewBoardSpace(roundOfPlay.getTotalThrow(), true);
            performBoardspaceActions(roundOfPlay.getTotalThrow());
        }
        else {
            jail.addRound(currentPlayer);
        }

        handlePlayerActions(false);
    }

    private void startTurn() {
        if (checkForJail()) {
            playTurnWhileInPrison();
            return;
        }
        RoundOfPlay roundOfPlay = new RoundOfPlay(currentPlayer);
        do {
            performTurnActions(roundOfPlay);
        }
        while (roundOfPlay.canThrowAgain() && !jail.isPlayerImprisoned(currentPlayer));
        handlePlayerActions(false);
    }

    private void performTurnActions(RoundOfPlay roundOfPlay) {
        handlePlayerActions(true);
        roundOfPlay.play();
        if (roundOfPlay.shouldBePrisoned()) {
            putPlayerInJail();
        }
        else {
            putPlayerOnNewBoardSpace(roundOfPlay.getTotalThrow(), false);
            performBoardspaceActions(roundOfPlay.getTotalThrow());
        }
    }

    private void putPlayerInJail() {
        jail.imprisonPlayer(currentPlayer);
        currentPlayer.moveToBoardspace(MonopolyBoardData.SPACENR_GEVANGENIS);
        playerBoardspaceMap.put(currentPlayer, MonopolyBoardData.getBoardspace(MonopolyBoardData.SPACENR_GEVANGENIS));
    }

    private boolean checkForJail() {
        if (!jail.isPlayerImprisoned(currentPlayer)) {
            return false;
        }

        if (jail.hasServedSentence(currentPlayer)) {
            return false;
        }
        return true;
    }

    private void putPlayerOnNewBoardSpace(int diceThrow, boolean releasedFromJail) {
        int previousBoardSpaceNr = currentPlayer.getBoardspaceNr();
        int newBoardSpaceNr = determineNewBoardspaceNr(previousBoardSpaceNr, diceThrow);

        if (newBoardSpaceNr != 0 &&
                !releasedFromJail &&
                newBoardSpaceNr < previousBoardSpaceNr) {
            System.out.println(currentPlayer + " is voorbij start gekomen en ontvangt 200 euro!");
            currentPlayer.receiveMoney(200);
        }
        currentPlayer.moveToBoardspace(newBoardSpaceNr);
        playerBoardspaceMap.put(currentPlayer, MonopolyBoardData.getBoardspace(newBoardSpaceNr));
    }

    private int determineNewBoardspaceNr(int previousBoardspaceNr, int diceThrow) {
        int newBoardspaceNr = previousBoardspaceNr + diceThrow;
        if (newBoardspaceNr > MonopolyBoardData.MAX_BOARDSPACE_NR) {
            newBoardspaceNr -= MonopolyBoardData.MAX_BOARDSPACE_NR - 1;
        }
        return newBoardspaceNr;
    }

    private void performBoardspaceActions(int diceThrow) {
        Boardspace boardspace = playerBoardspaceMap.get(currentPlayer);
        boardspace.prepareAction(currentPlayer, diceThrow);
        boardspace.getBoardspaceAction().handleAction(currentPlayer);
    }

    private void printGameStatus(){
        PrintPlayerStatus printPlayerStatus = new PrintPlayerStatus();
        for (Player player : players){
            printPlayerStatus.handleAction(player);
        }
        System.out.println("Er zijn " + nrOfRounds + " ronden gespeeld.");
    }

    private List<Player> makeArrayList(Player[] playerArray) {
        List<Player> players = new ArrayList<>();
        for (Player player : playerArray) {
            players.add(player);
        }
        return players;
    }

    public static Player getPlayer() {return currentPlayer;}
}
