import java.util.Arrays;

public class HandTest {
    private Card[] cards;
    private int cardCount;

    public HandTest() {
        cards = new Card[52];
        cardCount = 0;
    }

    public void addCard(Card card) {
        cards[cardCount++] = card;
    }

    public void putCardsAtEnd(int count) {
        Card[] temp = new Card[52];
        System.arraycopy(cards, 0, temp, cardCount, count);
        System.arraycopy(cards, count, temp, 0, cardCount);
        System.arraycopy(temp, 0, cards, 0, cardCount);
    }

    public Card[] getCards() {
        return Arrays.copyOf(cards, cardCount);
    }

    public Card removeFirstCard() {
        if (cardCount == 0) {
            return null;
        }
        Card removedCard = cards[0];
        System.arraycopy(cards, 1, cards, 0, cardCount - 1);
        cards[cardCount - 1] = null;
        cardCount--;
        return removedCard;
    }

    public int getCardCount() {
        return cardCount;
    }
}
