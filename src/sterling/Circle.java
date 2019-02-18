package sterling;
import java.awt.*;

public class Circle 
{
	//Variables for center point dimensions and radius
	private int centerX, centerY, radius;
	
	//Keeps track of color
	private Color color;
	
	//Keeps track of whether or not the tile has been taken
	public boolean taken = false;
	
	//Invaluable variable that tracks the circle's index
	private int index;
	
	////	Constructors
	


	//Default
	public Circle()
	{
		this(0, 0, 0, Color.black);
	}
	
	//Detail
	public Circle(int x, int y, int r, Color c)
	{
		centerX = x;
		centerY = y;
		radius = r;
		color = c;
	}
	
	//Point
	public Circle(Point p, int r, Color c)
	{
		this(p.x, p.y, r, c);
	}
	
	//Clone
	public Circle(Circle cir)
	{
		this(cir.centerX, cir.centerY, cir.radius, cir.color);
	}
	
	////	Accessors
	
	public int getX()
	{
		return centerX;
	}
	
	public int getY()
	{
		return centerY;
	}
	
	public int getRadius()
	{
		return radius;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public int getIndex() 
	{
		return index;
	}

	//Detects if inputed point lies on circle (never used but there if needed)
	
	public boolean containsPoint(int x, int y)
	{
		int xSquared = (x - centerX) * (x - centerX);
		int ySquared = (y - centerY) * (y - centerY);
		int radiusSquared = radius * radius;
		return xSquared + ySquared - radiusSquared <= 0;
	}
	
	////	Mutators
	
	public void setX(int x)
	{
		centerX = x;
	}
	
	public void setY(int y)
	{
		centerY = y;
	}
	
	public void setRadius(int r)
	{
		radius = r;
	}
	
	public void setColor(Color c)
	{
		color = c;
	}
	
	public void move(int xAmount, int yAmount)
	{
		centerX += xAmount;
		centerY += yAmount;
	}
	
	public void setIndex(int i) 
	{
		index = i;
	}
	
	//// Graphics

	//Draws outline of circle
	public void draw(Graphics g)
	{
		Color oldColor = g.getColor();
		g.setColor(color);
		
		g.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
		
		g.setColor(oldColor);
	}
	
	//Draws a filled in circle
	public void fill(Graphics g)
	{
		Color oldColor = g.getColor();
		g.setColor(color);
		
		g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
		
		g.setColor(oldColor);
	}
		
}
