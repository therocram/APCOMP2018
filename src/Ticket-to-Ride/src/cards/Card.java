package cards;

/* A card contains data that is stored in a deck
 * 
 * Two types of cards exist, train cards and goal cards
 * 
 * A card has a name that can be accessed but not changed
 */

public class Card {
	
	protected String name; //not sure whether or not it needs to be protected rather than private so I'm doing protected just in case
	
	public Card() {
		this.name = "Unnamed Card";
	}
	
	public Card(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
