package jmol.jasper.main.data.miscellaneous;

import java.util.*;

public class MonopolyCardDeck {
    private Deque<Card> cardsInPlay;
    private List<Card> discardedCards;
    private Random cardShuffler;
    private final List allCardsInDeck;

    public MonopolyCardDeck(Card[] cardArray){
        cardsInPlay = new ArrayDeque<>();
        discardedCards = new ArrayList<>();
        allCardsInDeck = new ArrayList();
        cardShuffler = new Random();
        if (cardArray.length < 1) {
            throw new IllegalArgumentException("Er moet teminste 1 kaart in het pak zitten");
        }
        initializeCards(cardArray);
    }

    public Card drawCard() {
        return cardsInPlay.poll();
    }

    public boolean discardCard (Card card) {
        if (!canCardBeDiscarded(card)) {
            return false;
        }
        discardedCards.add(card);
        return true;
    }

    public void putCardsBackInPlay(){
        for (Card card : discardedCards) {
            cardsInPlay.offer(card);
        }
    }

    public void shuffleCards() {
        int cardsToBeShuffled = cardsInPlay.size();
        Card[]shuffledCards = new Card[cardsToBeShuffled];
        List<Integer> usedSlots = new ArrayList<>();

        for (Card card : cardsInPlay) {
            boolean cardReplaced = false;

            while (!cardReplaced) {
                int newCardPosition = cardShuffler.nextInt(cardsToBeShuffled);

                if (!usedSlots.contains(newCardPosition)) {
                    shuffledCards[newCardPosition] = card;
                    usedSlots.add(newCardPosition);
                    cardReplaced = true;
                }
            }
        }

        refillCardsInPlay(shuffledCards);
    }

    private boolean canCardBeDiscarded(Card card) {
        return allCardsInDeck.contains(card)
                && !cardsInPlay.contains(card)
                && !discardedCards.contains(card);
    }

    private void initializeCards(Card[] cardArray) {
        for (int i = 0; i < cardArray.length; i++) {
            cardsInPlay.offer(cardArray[i]);
            allCardsInDeck.add(cardArray[i]);
        }
    }

    private void refillCardsInPlay(Card[] cardArray) {
        emptyCardsInPlay();
        for (int i = 0; i < cardArray.length; i++) {
            cardsInPlay.offer(cardArray[i]);
        }
    }

    private void emptyCardsInPlay() {
        cardsInPlay.clear();
    }
}
