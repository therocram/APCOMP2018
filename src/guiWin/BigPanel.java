package guiWin;
import java.awt.*;
import java.awt.event.*;

public class BigPanel extends BiggerPanel
{
	final static long serialVersionUID = 1;
	private Color color;
	private static boolean paint;
	
	public BigPanel()   // Default constructor. Makes white (HAPPY!?!?!??!)
	{
		this(Color.WHITE);
		setBackground(Color.white);
	}
	
	public BigPanel(Color c)	
	{
		color = c;
		setBackground(c);
		addMouseListener(new PanelListener());
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setBackground(color);
	}
	
	public BigPanel(BigPanel bp)
	{
		this(bp.color);
		setBackground(bp.color);
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void setColor(Color c)
	{
		color = c;
	}
	
	private class PanelListener extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			paint = true;
		}
		
		public void mouseReleased(MouseEvent e)
		{
			paint = false;
		}
		
		public void mouseEntered(MouseEvent e)
		{
			if(paint)
			{
				color = randColor();
				repaint();
			}
				
			
		}
	}
	
	
	
	
}
