import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@Test
public void GameTest() {
    Runnable testMethod = () -> {
        // Game with no zipShuffle
        Game game1 = new Game();
        game1.newGame();
        game1.numRounds = 0;
        while (!game1.deck.isEmpty()) {
            game1.player1.getHand().addCard(game1.deck.deal());
            game1.player2.getHand().addCard(game1.deck.deal());
        }
        while (game1.player1.getHand().getCardCount() != 0 && game1.player2.getHand().getCardCount() != 0) {
            game1.playRound();
            game1.numRounds++;
        }
        assertEquals(324, game1.numRounds);
        // Game with zipShuffle(3)
        Game game4 = new Game();
        game4.newGame();
        game4.deck.zipShuffle(3);
        game4.numRounds = 0;
        while (!game4.deck.isEmpty()) {
            game4.player1.getHand().addCard(game4.deck.deal());
            game4.player2.getHand().addCard(game4.deck.deal());
        }
        while (game4.player1.getHand().getCardCount() != 0 && game4.player2.getHand().getCardCount() != 0) {
            game4.playRound();
            game4.numRounds++;
        }
        assertEquals(74, game4.numRounds);
        assertThrows(Exception.class, testMethod);
    };

}