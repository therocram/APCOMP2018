package sterling;
import java.awt.*;

public class Tile 
{
	private Color color;
	private int centerX, centerY, radius;
	

	public Tile()
	{
		centerX = 0;
		centerY = 0;
		radius = 0;
		color = new Color(0, 156, 11);
	}
	
	public Tile(int x, int y, int r, Color c)
	{
		centerX = x;
		centerY = y;
		radius = r;
		color = c;
	}
	
	public Tile(Tile t)
	{
		centerX = t.centerX;
		centerY = t.centerY;
		radius = t.radius;
		color = t.color;
	}
	
	public int getY() 
	{
		return centerY;
	}
	
	public void setY(int centerY) 
	{
		this.centerY = centerY;
	}

	public int getX() 
	{
		return centerX;
	}

	public void setX(int centerX) 
	{
		this.centerX = centerX;
	}

	public int getRadius() 
	{
		return radius;
	}

	public void setRadius(int radius) 
	{
		this.radius = radius;
	}

	public Color getColor() 
	{
		return color;
	}

	public void setColor(Color color) 
	{
		this.color = color;
	}
	
	public void fill(Graphics g) 
	{
		Color oldColor = g.getColor();
		g.setColor(color);
		
		g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
		
		g.setColor(oldColor);
	}
	
	
	
	
}
