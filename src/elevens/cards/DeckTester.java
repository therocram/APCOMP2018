package elevens;
/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args)
	{
		String ranks[] = {"King", "Queen", "Jack", "Ten"};
		int values[] = {13, 12, 11, 10};
		String suits[] = {"Spades", "Hearts", "Clubs"};
		
		Deck elevens = new Deck(ranks, suits, values);
		
		/*for(int i = 0; i < ranks.length * suits.length; i++)
		{
			elevens.deal();
		}*/
	
		//elevens.shuffle();
		
		System.out.println(elevens.toString());
		
		
		
	}
}
