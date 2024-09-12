public class Hand {
    private Card[] cards;
    private int cardCount;

    public Hand() {
        cards = new Card[52]; // Changed the size to 52
        cardCount = 0;
    }

    public void addCard(Card card) {
        if (cardCount >= cards.length) {
            throw new IllegalStateException("Hand is full");
        }
        cards[cardCount] = card;
        cardCount++;
    }

    public Card removeFirstCard() {
        if (cardCount <= 0) {
            throw new IllegalStateException("Hand is empty");
        }
        Card firstCard = cards[0];
        shiftHand();
        cardCount--;
        return firstCard;
    }

    private void shiftHand() {
        for (int i = 0; i < cardCount - 1; i++) {
            cards[i] = cards[i + 1];
        }
        cards[cardCount - 1] = null;
    }

    public void putCardsAtEnd(int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            Card removedCard = removeFirstCard();
            addCard(removedCard);
        }
    }

    public int getCardCount() {
        return cardCount;
    }

    public Card[] getCards() {
        return cards;
    }
}
