package decks;
import cards.*;

public class DeckTester {

	public static void main(String[] args) {
		Card[] cardArr = {new TrainCard(), new TrainCard()};
		
		Hand h = new Hand("Hand0", 3, cardArr);
		System.out.print(h);

		
		
	}

}
