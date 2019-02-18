package decks;

/* This is the interface to create a new type of deck
 * A deck contains a set amount of cards, MAX_CARDS, to be split among the hand, draw pile, and discard
 * A deck can shuffle <deck>.shuffle(); the cards in the draw and discard together
 * A deck can deal <deck>.deal(int handCount, int dealSize); cards from the drawpile to the hands
 * 
 * 
 */

public class Deck {
	protected String name;
	
	public Deck() {
		this.name = "Nameless Deck";
	}
	
	public Deck(String name) {
		this.name = name;
	}
	
}
