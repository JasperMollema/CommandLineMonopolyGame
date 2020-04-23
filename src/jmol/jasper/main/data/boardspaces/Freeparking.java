package jmol.jasper.main.data.boardspaces;

import jmol.jasper.main.data.miscellaneous.MonopolyBoardData;
import jmol.jasper.main.logic.actions.boardspaceactions.BoardSpaceAction;

public class Freeparking extends Boardspace {

    public Freeparking(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
    }

    @Override
    public BoardSpaceAction getBoardspaceAction() {
        return null;
    }
}
