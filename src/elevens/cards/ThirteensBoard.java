package elevens;

import java.util.List;

public class ThirteensBoard extends Board
{
	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 10;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ThirteensBoard() 
	 {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	 /**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) 
	{
		return containsPairSum13(selectedCards) || containsK(selectedCards);
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() 
	{
		List<Integer> cIndexes = cardIndexes();
		
		return containsPairSum13(cIndexes) || containsK(cIndexes);
		
	}
	
	private boolean containsPairSum13(List<Integer> selectedCards) 
	{
		
		for(int i = 0; i < selectedCards.size(); i++)
		{
			Card card1 = cards[selectedCards.get(i)];
			
			for(int j = 0; j < selectedCards.size(); j++)
			{
				Card card2 = cards[selectedCards.get(j)];
				
				if(card1.pointValue() + card2.pointValue() == 13)
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean containsK(List<Integer> selectedCards) 
	{
		for(int i = 0; i < selectedCards.size(); i++)
		{
			if(cards[selectedCards.get(i)].rank().equals(RANKS[12]))
			{
				return true;
			}
		}
		
		return false;
	}
}
