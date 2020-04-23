package jmol.jasper.main.data.boardspaces;


import jmol.jasper.main.data.miscellaneous.Card;
import jmol.jasper.main.data.miscellaneous.CardData;
import jmol.jasper.main.data.miscellaneous.MonopolyBoardData;
import jmol.jasper.main.data.miscellaneous.MonopolyCardDeck;

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
