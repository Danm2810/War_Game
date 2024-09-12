# War_Game
Thank you for checking out my project!

This project is an implementation of the classic card game War in Java, created to strengthen my understanding of object-oriented programming (OOP) principles and enhance my problem-solving skills through game development. The main goal was to build a fully functional, interactive command-line game that accurately simulates the rules and flow of War. Throughout this project, I gained hands-on experience with key OOP concepts such as classes, inheritance, encapsulation, and polymorphism, as well as fundamental data structures like arrays, lists, and queues to manage the deck of cards and players' hands. Additionally, I honed my skills in algorithm design for shuffling cards, managing gameplay, and determining round winners.

This project demonstrates my ability to develop game logic, write clean and efficient code, and utilize OOP principles to create modular and maintainable software. It also highlights my proficiency in debugging, testing, and adhering to Java best practices. Overall, this project serves as a testament to my growing expertise in software development and my ability to create robust, object-oriented applications in Java.


# How to Play War (modified rules):

Each player turns up a card at the same time (a.k.a. the “Round Card”) and the player with
the higher rank card takes both cards and puts them, face down, on the bottom of his
stack. If the cards are the same rank, it is War. Each player turns three cards face down and the
fourth card face up (a.k.a. the “War Card”). The player with the higher rank card takes both
piles. If the turned-up cards are again the same rank, the player with the higher suit card
wins the war and takes all 10 cards. The game ends when one player has won all the cards.
(Note: this implementation of the War game in Java is not an exact simulation of the real
game. See the official rules by Bicycle Cards.) 

In our game of War, we are using an array to hold the cards in a player’s Hand.
Throughout each round of the game, the Card at position zero in a player's hand will be
used in the round (e.g. cards[0]). If there is a War and the player has more than 5 cards in
their hand, the Card at index 4 will be used in the War where cards[0] represents the card
in the round, there are three face down cards (e.g. cards[1], cards[2], cards[3]) and the
next card in the stack (e.g. cards[4] ) is used in the W
