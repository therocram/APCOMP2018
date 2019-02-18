package decks;
import cards.Card;
import java.util.ArrayList;

/* A hand contains all a player's cards of a specific type
 * 
 * A hand can add ( <hand>.add(Card card) )
 * or remove ( <hand>.remove(Card card) ) any card it has
 * 
 * A hand has a max size maxHandSize
 */

public class Hand extends Deck {

	ArrayList<Card> cardArray;
	private int maxHandSize;//max # of cards allowed in a hand
	
	//-------------------CONSTRUCTORS--------------------------
	public Hand() {
		super();
		maxHandSize = 0;
	}
	
	public Hand(String name, int maxHandSize) {
		super(name);
		this.maxHandSize = maxHandSize;
	}
	
	public Hand(String name, int maxHandSize, Card[] cards) {
		super(name);
		this.maxHandSize = maxHandSize;
		this.cardArray.ensureCapacity(maxHandSize);
		
		
		
		if(maxHandSize < cards.length) {
			throw new IllegalArgumentException("Card array lentgh must not excede maxHandSize");
		}
		else { //Set each element of the ArrayList to the corresponding card of the given array
			for (int x=0; x<cards.length; x++) {
				this.cardArray.add(cards[x]);
			}
			//when you run out of cards just make blank ones for the rest
			for (int x=cards.length; x<(maxHandSize-cards.length); x++) {
				this.cardArray.add(new Card());
			}
			
			
		}
		
		
		
		
		
					
	}
	
	//---------------------METHODS------------------------------
	
	public Card getCard(int index){
		return this.cardArray.get(index);
	}
	
	//adds a card in indexed position
	public void setCard(Card card, int index) { 
		if(index < this.maxHandSize) {
			this.cardArray.add(index, card);
		}
		else {
			throw new ArrayIndexOutOfBoundsException("Cannot set card to indexed value because value excedes maxHandSize");
		}
	}
	
	//removes any card from index
	public void removeCard(int index) { 
		this.cardArray.remove(index);	
	}
	
	//removes one of the specified card types (first occurrence of)
	public void removeCard(Card card) { 
		this.cardArray.remove(card);
	}
	
	
	
	@Override
	public String toString() {
		String s = "";
		for (int x=0; x<maxHandSize; x++) {
			s += "Hand Slot " + x + ": " + cardArray.get(x);
		}
		return s;
	}
}

