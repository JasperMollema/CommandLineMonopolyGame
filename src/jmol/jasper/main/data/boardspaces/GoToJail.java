package jmol.jasper.main.data.boardspaces;

import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.MonopolyGame.BoardSpaceActions.BoardSpaceAction;
import jmol.jasper.MonopolyGame.BoardSpaceActions.GoToJailBoardSpaceAction;

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
