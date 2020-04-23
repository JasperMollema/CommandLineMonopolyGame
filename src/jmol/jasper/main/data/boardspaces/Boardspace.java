package jmol.jasper.main.data.boardspaces;

import jmol.jasper.main.data.miscellaneous.MonopolyBoardData;
import jmol.jasper.main.logic.actions.boardspaceactions.BoardSpaceAction;
import jmol.jasper.main.logic.player.Player;

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
