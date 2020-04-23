package jmol.jasper.main.data.boardspaces;

import jmol.jasper.MonopolyBoard.Data.Card;
import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.MonopolyGame.BoardSpaceActions.CardAction;

public abstract class CardSpace extends Boardspace {

    public CardSpace(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
    }

    @Override
    public CardAction getBoardspaceAction() {
        return new CardAction();
    }

    public abstract Card drawCard();
}
