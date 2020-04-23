package jmol.jasper.main.data.boardspaces;

import jmol.jasper.main.data.miscellaneous.Card;
import jmol.jasper.main.data.miscellaneous.MonopolyBoardData;
import jmol.jasper.main.logic.actions.boardspaceactions.CardAction;

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
