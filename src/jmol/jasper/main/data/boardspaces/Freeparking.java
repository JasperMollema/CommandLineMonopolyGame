package jmol.jasper.main.data.boardspaces;


import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.MonopolyGame.BoardSpaceActions.BoardSpaceAction;

public class Freeparking extends Boardspace {

    public Freeparking(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
    }

    @Override
    public BoardSpaceAction getBoardspaceAction() {
        return null;
    }
}
