package cards;

/* TrainCards are different colors and are played to build rails
 * 
 * A TrainCard's name is the same as its color with the exception of color, which has all color properties
 * 
 * A TrainCard will give its color upon request
 */

public class TrainCard extends Card {
	private String color;
	
	public TrainCard() {
		super();
		this.color = "Colorless Card";
	}
	
	public TrainCard(String color) { //A TrainCard's name is the same as it's color
		super(color);
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}

}
