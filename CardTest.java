import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void testGetRank() {
        Card card = new Card(Rank.ACE, Suit.HEARTS);
        assertEquals(Rank.ACE, card.getRank());
    }

    @Test
    public void testGetSuit() {
        Card card = new Card(Rank.JACK, Suit.CLUBS);
        assertEquals(Suit.CLUBS, card.getSuit());
    }

    @Test
    public void testToString() {
        Card card = new Card(Rank.FIVE, Suit.SPADES);
        assertEquals("----------\n| 5 |\n| ♠ |\n|  5 |\n----------\n", card.toString());
    }
}
