package jmol.jasper.main.data.boardspaces;

import jmol.jasper.MonopolyBoard.Data.Card;
import jmol.jasper.MonopolyBoard.Data.CardData;
import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.MonopolyBoard.Data.MonopolyCardDeck;

public class Chance extends CardSpace {
    public static final MonopolyCardDeck chanceCards = new MonopolyCardDeck(CardData.chanceCards);

    public Chance(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
    }

    @Override
    public Card drawCard() {
        Card card = chanceCards.drawCard();
        if (card == null) {
            chanceCards.putCardsBackInPlay();
            chanceCards.shuffleCards();
            card = chanceCards.drawCard();
        }
        return card;
    }

}
