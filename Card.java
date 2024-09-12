public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        char suit = ' ';
        switch (this.suit) {
        case SPADES: suit = '\u2660'; break;
        case DIAMONDS: suit = '\u2666'; break;
        case CLUBS: suit = '\u2663'; break;
        case HEARTS: suit = '\u2764'; break;
        }
        String rank = "";
        switch (this.rank) {
        case DEUCE: rank=" 2"; break;
        case THREE: rank=" 3"; break;
        case FOUR: rank=" 4"; break;
        case FIVE: rank=" 5"; break;
        case SIX: rank=" 6"; break;
        case SEVEN: rank=" 7"; break;
        case EIGHT: rank=" 8"; break;
        case NINE: rank=" 9"; break;
        case TEN: rank="10"; break;
        case JACK: rank=" J"; break;
        case QUEEN: rank=" Q"; break;
        case KING: rank=" K"; break;
        case ACE: rank=" A"; break;
        }
        return "----------" +
        "\n|" + rank + " |" +
        "\n| " + suit + " |" +
        "\n| " + rank + " |" +
        "\n----------\n";
        }
        

public static void main(String[] args){
}
}