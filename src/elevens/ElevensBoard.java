package elevens;
import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

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
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
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
		return containsPairSum11(selectedCards) || containsJQK(selectedCards);
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
		
		return containsPairSum11(cIndexes) || containsJQK(cIndexes);
		
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) 
	{
		/*if(selectedCards.size() != 2)
		{
			return false;
		}
		else
		{
			Card card1 = cards[selectedCards.get(0)];
			Card card2 = cards[selectedCards.get(1)];
			
			if(card1.pointValue() + card2.pointValue() == 11)
			{
				return true;
			}
			
			return false;
		}*/
		
		for(int i = 0; i < selectedCards.size(); i++)
		{
			Card card1 = cards[selectedCards.get(i)];
			
			for(int j = 0; j < selectedCards.size(); j++)
			{
				Card card2 = cards[selectedCards.get(j)];
				
				if(card1.pointValue() + card2.pointValue() == 11)
				{
					return true;
				}
			}
		}
		
		return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) 
	{
		for(int i = 0; i < selectedCards.size(); i++)
		{
			Card card1 = cards[selectedCards.get(i)];
			
			if(card1.rank().equals(RANKS[10]))
			{
				for(int j = 0; j < selectedCards.size(); j++)
				{
					Card card2 = cards[selectedCards.get(j)];
					
					if(card2.rank().equals(RANKS[11]))
					{
						for(int e = 0; e < selectedCards.size(); e++)
						{
							Card card3 = cards[selectedCards.get(e)];
							
							if(card3.rank().equals(RANKS[12]))
							{
								return true;
							}
						}
					}
					
					else if(card2.rank().equals(RANKS[12]))
					{
						for(int e = 0; e < selectedCards.size(); e++)
						{
							Card card3 = cards[selectedCards.get(e)];
							
							if(card3.rank().equals(RANKS[11]))
							{
								return true;
							}
						}
					}
				}
			}
			
			if(card1.rank().equals(RANKS[11]))
			{
				for(int j = 0; j < selectedCards.size(); j++)
				{
					Card card2 = cards[selectedCards.get(j)];
					
					if(card2.rank().equals(RANKS[10]))
					{
						for(int e = 0; e < selectedCards.size(); e++)
						{
							Card card3 = cards[selectedCards.get(e)];
							
							if(card3.rank().equals(RANKS[12]))
							{
								return true;
							}
						}
					}
					
					else if(card2.rank().equals(RANKS[12]))
					{
						for(int e = 0; e < selectedCards.size(); e++)
						{
							Card card3 = cards[selectedCards.get(e)];
							
							if(card3.rank().equals(RANKS[10]))
							{
								return true;
							}
						}
					}
				}
			}
			
			if(card1.rank().equals(RANKS[12]))
			{
				for(int j = 0; j < selectedCards.size(); j++)
				{
					Card card2 = cards[selectedCards.get(j)];
					
					if(card2.rank().equals(RANKS[10]))
					{
						for(int e = 0; e < selectedCards.size(); e++)
						{
							Card card3 = cards[selectedCards.get(e)];
							
							if(card3.rank().equals(RANKS[11]))
							{
								return true;
							}
						}
					}
					
					else if(card2.rank().equals(RANKS[11]))
					{
						for(int e = 0; e < selectedCards.size(); e++)
						{
							Card card3 = cards[selectedCards.get(e)];
							
							if(card3.rank().equals(RANKS[10]))
							{
								return true;
							}
						}
					}
				}
			}
		}
		
		return false;
		
		/*if(selectedCards.size() != 3)
		{
			return false;
		}
		else
		{
			Card card1 = cards[selectedCards.get(0)];
			Card card2 = cards[selectedCards.get(1)];
			Card card3 = cards[selectedCards.get(2)];
			
			if(card1.rank().equals(RANKS[10]))
			{
				if(card2.rank().equals(RANKS[11]))
				{
					if(card3.rank().equals(RANKS[12]))
						return true;
				}
				
				else if(card2.rank().equals(RANKS[12]))
				{
					if(card3.rank().equals(RANKS[11]))
						return true;
				}
				
				else
					return false;
				
			}
			
			else if(card1.rank().equals(RANKS[11]))
			{
				if(card2.rank().equals(RANKS[10]))
				{
					if(card3.rank().equals(RANKS[12]))
						return true;
				}
				
				else if(card2.rank().equals(RANKS[12]))
				{
					if(card3.rank().equals(RANKS[10]))
						return true;
				}
				
				else
					return false;
			}
			
			else if(card1.rank().equals(RANKS[12]))
			{
				if(card2.rank().equals(RANKS[10]))
				{
					if(card3.rank().equals(RANKS[11]))
						return true;
				}
				
				else if(card2.rank().equals(RANKS[11]))
				{
					if(card3.rank().equals(RANKS[10]))
						return true;
				}
				
				else
					return false;
			}
			
			return false;
		}*/
	}
}
