package jmol.jasper.main.data.boardspaces;

import jmol.jasper.main.data.miscellaneous.MonopolyBoardData;
import jmol.jasper.main.logic.actions.boardspaceactions.BoardSpaceAction;
import jmol.jasper.main.logic.actions.boardspaceactions.GoToJailBoardSpaceAction;

public class GoToJail extends Boardspace{

    public GoToJail(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
    }

    @Override
    public BoardSpaceAction getBoardspaceAction() {
        System.out.println(visitor + " moet naar de gevangenis!");
        return new GoToJailBoardSpaceAction();
    }
}
