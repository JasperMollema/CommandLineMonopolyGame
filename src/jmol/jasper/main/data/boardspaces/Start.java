package jmol.jasper.main.data.boardspaces;

import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.MonopolyGame.BoardSpaceActions.BoardSpaceAction;

public class Start extends Boardspace{

    public Start(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
    }

    @Override
    public BoardSpaceAction getBoardspaceAction() {
        System.out.println(visitor + " staat op start en ontvangt 400 euro!");
        visitor.receiveMoney(400);
        return null;
    }
}
