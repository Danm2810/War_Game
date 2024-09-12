import java.util.Random;

public class Deck {
    private Card[] cards;
    private int numDealt;

    public Deck() {
        cards = new Card[52];
        numDealt = 0;

        int index = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    public void zipShuffle(int times) {
        Random random = new Random();
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < cards.length / 2; j++) {
                int k = random.nextInt(cards.length / 2) + cards.length / 2;
                swap(j, k);
            }
        }
    }

    public void randomShuffle() {
        Random random = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(i, j);
        }
    }

    private void swap(int i, int j) {
        Card temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
    }

    public Card deal() {
        if (numDealt >= cards.length) {
            throw new IllegalStateException("Deck is empty");
        }
        Card card = cards[numDealt];
        numDealt++;
        return card;
    }

    public boolean isEmpty() {
        return numDealt == cards.length;
    }

    public int getNumDealt() {
        return numDealt;
    }

    public Card[] getCards() {
        return cards;
    }
}
