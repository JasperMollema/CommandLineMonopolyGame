package jmol.jasper.main.data.boardspaces;

import jmol.jasper.main.data.miscellaneous.Card;
import jmol.jasper.main.data.miscellaneous.CardData;
import jmol.jasper.main.data.miscellaneous.MonopolyBoardData;
import jmol.jasper.main.data.miscellaneous.MonopolyCardDeck;

public class CommunityChest extends CardSpace {
    public static final MonopolyCardDeck communityChestCards = new MonopolyCardDeck(CardData.communityChestCards);

    public CommunityChest(String name, int spaceNr, MonopolyBoardData.BoardspaceType boardspaceType) {
        super(name, spaceNr, boardspaceType);
    }

    @Override
    public Card drawCard() {
        Card card = communityChestCards.drawCard();
        if (card == null) {
            communityChestCards.putCardsBackInPlay();
            communityChestCards.shuffleCards();
            card = communityChestCards.drawCard();
        }
        return card;
    }

}
