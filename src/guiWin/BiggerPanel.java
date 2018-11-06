package guiWin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class BiggerPanel extends JPanel
{
	final static long serialVersionUID = 2;
	private int x, y; // Size of array x = rows, y = columns
	private int q, w; // Mouse coordinates: x and y respectively
	private Color draw; // Color being used with mouse drags
	BigPanel flow[]; // Array containing subclass visual panels
	
	public BiggerPanel()  // Default constructor
	{
		this(0, 0);
	}
	
	public BiggerPanel(int a, int b)  // Enter rows and columns
	{
		x = a;
		y = b;
		final int z = x*y;  // Constant to make array happy //why x*y?
		flow = new BigPanel[z];
		
		for(int i = 0; i <= x * y - 1; i++)  // Initializes subclass panels with random colors and stores them in BiggerPanel
		{
			Color backColor = Color.white;  
			BigPanel panel = new BigPanel(backColor);
			flow[i] = panel;
		}
		
		addMouseListener(new PanelListener());  // Keeps track of mouse pressing and mouse releasing
		addMouseMotionListener(new PanelMotionListener()); // Keeps track of mouse dragging and mouse motion 
	}
	
	public Color randColor()  // Helper method that creates a random color
	{
		Random ge = new Random();
		Color c = new Color(ge.nextInt(256), ge.nextInt(256), ge.nextInt(256));
		return c;
	}
	
	public String getCoordinates()
	{
		String s = "X: " + q + "\nY: " + w;
		return s;
	}
	
	private class PanelListener extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			q = e.getX();
			w = e.getY();
		}
		
		public void mouseReleased(MouseEvent e)
		{
			
		}
	}
	
	
	private class PanelMotionListener extends MouseMotionAdapter
	{
		public void mouseDragged(MouseEvent e)
		{
			

			/*draw = randColor();  // Sets new random draw color
			
			int newX;    // Used to keep track of new mouse coordinates
			int newY;
			
			int dx;  // Used to keep track of distance between new and old mouse coordinates
			int dy; 
			
			for(int i = 0; i <= x * y - 1; i++)   // Checks all panels for mouse coordinates and changes color
			{
				newX = e.getX(); // Sets new mouse coordinates 
				newY = e.getY();
				
				dx = newX - q; // Sets distance between new and old mouse coordinates
				dy = newY - w;
				
				BigPanel panel = flow[i]; // Calls panel in array locations
				
				int height = panel.getHeight(); // Pertinent panel information
				int width = panel.getWidth();
				int a = panel.getX();
				int b = panel.getY();
				
				boolean point = (dx >= b && dx <= b + height) && (dy >= a && dy <= a + width); // Checks to see if distance between old and 
																							   // new mouse coordinates is within the current
																							   // panel
				
				if(point)					// Sets panel color to new draw color if above is true
					panel.setColor(draw); 
				
				repaint();	// Refreshes window
				
				q = newX;	// Sets old mouse coordinates to new
				w = newX;
				
			}	*/
		}
		
		public void mouseMoved(MouseEvent e)
		{
			/*int newX;
			int newY;
			
			for(int i = 0; i <= x * y - 1; i++)
			{
				newX = e.getX();
				newY = e.getY();
				BigPanel panel = flow[i];
				int height = panel.getHeight();
				int width = panel.getWidth();
				int a = panel.getX();
				int b = panel.getY();
				boolean point = (newX >= b && newX <= b + height) && (newY >= a && newY <= a + width);
				if(point)
					panel.setColor(draw);
				repaint();
				q = newX;
				w = newX; */
			
		}
	}
	
}
