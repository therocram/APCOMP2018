package shapes;
import TurtleGraphics.Pen;

public class Triangle extends AbstractShape
{
	private double xCor1, yCor1;
	private double xCor2, yCor2;
	
	public Triangle()
	{
		super();
		xCor1= 0;
		yCor1 = 0;
		xCor2 = 0;
		yCor2 = 0;
	}
	
	public Triangle(double xLoc, double yLoc, double x1, double y1, double x2, double y2)
	{
		super (xLoc, yLoc);
		xCor1 = x1;
		yCor1 = y1;
		xCor2 = x2;
		yCor2 = y2;
	}
	
	public double area()
	{
		return 0.5 * Math.abs( (xPos * yCor1) - (xCor1 * yPos) + (xCor1 * yCor2) - (xCor2 * yCor1) + (xCor2 * yPos)- (xPos * yCor2) );
	}
	
	public double perimeter()
	{
	
	}
}
