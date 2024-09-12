import org.junit.Test;
import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void zipShuffleTest1() {
        Deck testDeck = new Deck();
        testDeck.zipShuffle(1);
        @SuppressWarnings("unused")
        Card[] shuffledCards = testDeck.getCards();
        // Add your assertions here
    }

    @Test
    public void zipShuffleTest2() {
        Deck testDeck = new Deck();
        testDeck.zipShuffle(2);
        @SuppressWarnings("unused")
        Card[] shuffledCards = testDeck.getCards();
        // Add your assertions here
    }

    @Test
    public void dealTest() {
        Deck testDeck = new Deck();
        Card card1 = testDeck.deal();
        Card card2 = testDeck.deal();

        assertNotNull(card1);
        assertNotNull(card2);
        assertNotEquals(card1, card2);
    }

    @Test
    public void isEmptyTest() {
        Deck testDeck = new Deck();
        assertFalse(testDeck.isEmpty());

        for (int i = 0; i < 52; i++) {
            testDeck.deal();
        }

        assertTrue(testDeck.isEmpty());
    }

    @Test
    public void getNumDealtTest() {
        Deck testDeck = new Deck();
        assertEquals(0, testDeck.getNumDealt());

        testDeck.deal();
        testDeck.deal();

        assertEquals(2, testDeck.getNumDealt());
    }

    @Test
    public void getCardsTest() {
        Deck testDeck = new Deck();
        Card[] cards = testDeck.getCards();

        assertNotNull(cards);
        assertEquals(52, cards.length);
    }
}
