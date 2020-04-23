package jmol.jasper.main.data.boardspaces;

import jmol.jasper.MonopolyBoard.Data.Card;
import jmol.jasper.MonopolyBoard.Data.CardData;
import jmol.jasper.MonopolyBoard.Data.MonopolyBoardData;
import jmol.jasper.MonopolyBoard.Data.MonopolyCardDeck;

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
