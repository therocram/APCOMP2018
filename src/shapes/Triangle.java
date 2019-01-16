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
	
	public void draw(Pen p)
	{
		/*double x1 = xCor1 - xPos;
		double y1 = yCor1 - yPos;
		
		double x2 = xCor2 - xCor1;
		double y2 = yCor2 - yCor1;
		
		double x3 = xPos - xCor2;
		double y3 = yPos - yCor2;*/
		
		p.up();
		p.move(xPos, yPos);
		p.down();
		p.move(xCor1, yCor1);
		p.move(xCor2, yCor2);
		p.move(xPos, yPos);
		p.setDirection(0);
		
		/*p.turn( Math.toDegrees(Math.atan(y1/x1)) );
		p.move( Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2)) );
		
		p.turn( Math.toDegrees(Math.atan(y2/x2)) );
		p.move( Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2)) );
		
		p.turn( Math.toDegrees(Math.atan(y3/x3)) );
		p.move( Math.sqrt(Math.pow(x3, 2) + Math.pow(y3, 2)) );*/
	}
	
	public double perimeter()
	{
		return Math.sqrt( Math.pow(xPos-xCor1, 2) + Math.pow(yPos-yCor1, 2) )
			+  Math.sqrt( Math.pow(xPos-xCor2, 2) + Math.pow(yPos-yCor2, 2) )
			+  Math.sqrt( Math.pow(xCor1-xCor2, 2) + Math.pow(yCor1-yCor2, 2) );
	}
	
	public void stretchBy (double factor)
	{
		xCor1 = xPos + (xCor1 - xPos) * factor;
		yCor1 = yPos + (yCor1 - yPos) * factor;
		
		xCor2 = xPos + (xCor2 - xPos) * factor;
		yCor2 = yPos + (yCor2 - yPos) * factor;
	}
	
	public void move (double xLoc, double yLoc)
	{
		xPos += xLoc;
		yPos += yLoc;
		
		xCor1 += xLoc;
		yCor1 += yLoc;
		
		xCor2 += xLoc;
		yCor2 += yLoc;
	}
}
