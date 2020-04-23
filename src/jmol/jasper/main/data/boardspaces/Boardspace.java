package jmol.jasper.main.data.boardspaces;

import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.MonopolyGame.BoardSpaceActions.BoardSpaceAction;
import jmol.jasper.Player.Logic.Player;

public abstract class Boardspace {
    protected String name;
    protected int spaceNr;
    protected MonopolyBoardData.BoardspaceType boardspaceType;
    protected Player visitor;
    protected int diceThrowVisitor;

    public Boardspace(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType){
        this.name = name;
        this.spaceNr = spaceNr;
        this.boardspaceType = boardspaceType;
    }

    public Boardspace() {}

    public BoardSpaceAction getBoardspaceAction(){return null;}

    public void prepareAction (Player player, int diceThrow) {
        visitor = player;
        diceThrowVisitor = diceThrow;
        System.out.println(player + " staat op " + name + ".");
    }

    public String getName() {
        return name;
    }

    public int getSpaceNr() {
        return spaceNr;
    }

    public MonopolyBoardData.BoardspaceType getBoardspaceType() {
        return boardspaceType;
    }
}
