import java.util.*;

public class Game {
    public static Player player1;
    public static Player player2;
    public static Deck deck;

    public static void newGame() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        deck = new Deck();
    }

    public static void transferCards(Player losingPlayer, Player winningPlayer, int numCards) {
        for (int i = 0; i < numCards; i++) {
            Card transferredCard = losingPlayer.getHand().removeFirstCard();
            winningPlayer.getHand().addCard(transferredCard);
        }
        winningPlayer.getHand().putCardsAtEnd(numCards);
    }

    public static Player compareRank(int p1Position, int p2Position) {
        Rank p1Rank = player1.getHand().getCards()[p1Position].getRank();
        Rank p2Rank = player2.getHand().getCards()[p2Position].getRank();

        if (p1Rank.compareTo(p2Rank) > 0) {
            return player1;
        } else if (p1Rank.compareTo(p2Rank) < 0) {
            return player2;
        }
        return null;
    }

    public static Player tieBreakWithSuit(int p1Position, int p2Position) {
        Suit p1Suit = player1.getHand().getCards()[p1Position].getSuit();
        Suit p2Suit = player2.getHand().getCards()[p2Position].getSuit();

        if (p1Suit.compareTo(p2Suit) > 0) {
            return player1;
        } else if (p1Suit.compareTo(p2Suit) < 0) {
            return player2;
        }
        return null;
    }

    public static Player war() {
        int p1SkipIndex = 4;
        int p2SkipIndex = 4;

        if (player1.getHand().getCardCount() < 5) {
            p1SkipIndex = player1.getHand().getCardCount() - 1;
        }
        if (player2.getHand().getCardCount() < 5) {
            p2SkipIndex = player2.getHand().getCardCount() - 1;
        }

        Card p1WarCard = player1.getHand().getCards()[p1SkipIndex];
        Card p2WarCard = player2.getHand().getCards()[p2SkipIndex];

        System.out.println("Player 1 War Card: " + p1WarCard);
        System.out.println("Player 2 War Card: " + p2WarCard);

        Player winner = compareRank(p1SkipIndex, p2SkipIndex);

        if (winner == null) {
            winner = tieBreakWithSuit(p1SkipIndex, p2SkipIndex);
        }

        return winner;
    }

    public static void playRound() {
        Card p1RoundCard = player1.getHand().getCards()[0];
        Card p2RoundCard = player2.getHand().getCards()[0];

        System.out.println("Player 1 Round Card: " + p1RoundCard);
        System.out.println("Player 2 Round Card: " + p2RoundCard);

        Player roundWinner = compareRank(0, 0);

        if (roundWinner == null) {
            System.out.println("It's a War!");
            Player warWinner = war();
            System.out.println("War winner: " + warWinner.getName());
            transferCards((warWinner == player1) ? player2 : player1, warWinner, 5);
            System.out.println(warWinner.getName() + " wins the round.");
        } else {
            System.out.println(roundWinner.getName() + " wins the round.");
            transferCards((roundWinner == player1) ? player2 : player1, roundWinner, 1);
        }
    }

    public static void main(String[] args) {
        newGame();
        while (!deck.isEmpty()) {
            player1.getHand().addCard(deck.deal());
            player2.getHand().addCard(deck.deal());
        }
        System.out.println("Let's play War!\n");
        System.out.println("HOW TO PLAY:\n\nEach player turns up a card at the same time and the \n" +
                "player with the higher rank card takes both cards and puts them, \n" +
                "face down, on the bottom of their stack.\n\n" +
                "If the cards are the same rank, it is War. Each player turns \n" +
                "three cards face down and the fourth card face up. The player with the \n" +
                "higher rank cards takes both piles. If the turned-up cards \n" +
                "are again the same rank, the player with the \n" +
                "higher suited card and takes all 10 cards.\n\n" +
                "The game ends when one player has won all the cards.\n");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of rounds: ");
            numRounds = scanner.nextInt();
            for (int i = 1; i <= numRounds; i++) {
                System.out.println("---------- Round " + i + " ----------");
                playRound();
                System.out.println("**********************");
                System.out.println();
                System.out.println(player1.getName() + "'s Card count = " + player1.getHand().getCardCount());
                System.out.println(player2.getName() + "'s Card count = " + player2.getHand().getCardCount());
                System.out.println();
            }
        }
    
    }

    public static int numRounds;
}