package guiWin;
import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class BiggerPanel extends JPanel
{
	final static long serialVersionUID = 2;
	private int x, y; // Size of array x = rows, y = columns
	private int q, w; // Mouse coordinates: x and y respectively
	BigPanel flow[]; // Array containing subclass visual panels
	public static Color bigColor;
	
	
	public BiggerPanel()  // Default constructor
	{
		this(0, 0, Color.WHITE);
	}
	
	public BiggerPanel(int a, int b, Color c)  // Enter rows and columns
	{
		x = a;
		y = b;
		bigColor = c;
		//bigColor = c;
		final int z = x*y;  // Constant to make array happy //why x*y?
		flow = new BigPanel[z];
		
		for(int i = 0; i <= x * y - 1; i++)  // Initializes subclass panels with random colors and stores them in BiggerPanel
		{  
			Color backColor = c;
			BigPanel panel = new BigPanel(backColor);
			flow[i] = panel;
		}
		
		//addKeyListener(new KeyMonitor());
		/*Action leftAction = new LeftAction();
		this.getInputMap().put(KeyStroke.getKeyStroke("F2"), "doSomething");
		this.getActionMap().put("doSomething", leftAction);*/
		
	}
	
	public BiggerPanel(BiggerPanel bp)
	{
		this(bp.x, bp.y, randColor());
	}
	
	public static Color randColor()  // Helper method that creates a random color
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
	
	/*private class LeftAction extends AbstractAction
	{
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e)
		{
			for(int i = 0; i <= x * y - 1; i++)  
			{  
				Color newColor = randColor();
				flow[i].setColor(newColor);
			}
			repaint();
		}
	}*/
	
	/*private class KeyMonitor extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			switch(e.getKeyCode())
			{
			case KeyEvent.VK_SHIFT:
				for(int i = 0; i <= x * y - 1; i++)
				{
					Color newcolor = randColor();
					flow[i].setColor(newcolor);
					repaint();
				}
				
				break;
			case KeyEvent.VK_UP:
				color = bigColor;
				repaint();
	            break;
			}
		}
	}*/
	
	
}
