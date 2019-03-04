package elevens;
/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) 
	{
		Card king = new Card("King", "Hearts", 10);
		Card ten = new Card("Ten", "Spades", 10);
		Card copy = new Card("Ten", "Spades", 10);
		Card bhudda = new Card("Three", "Clubs", 3);
		
		System.out.println(king.toString());
		System.out.println(ten.toString());
		System.out.println(bhudda.toString());
		
		if(king.matches(ten))
		{
			System.out.println("\n" + "These cards match");
		}
		else
		{
			System.out.println("\n" + "These cards do not match");
		}
		
		if(ten.matches(copy))
		{
			System.out.println("\n" + "These cards match");
		}
		else
		{
			System.out.println("\n" + "These cards do not match");
		}
	}
}
