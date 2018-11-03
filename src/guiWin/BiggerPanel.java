package guiWin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class BiggerPanel extends JPanel
{
	private int x, y;
	private int q, w;
	BigPanel flow[];
	
	public BiggerPanel()
	{
		this(0, 0);
	}
	
	public BiggerPanel(int a, int b)
	{
		x = a;
		y = b;
		final int z = x*y;
		flow = new BigPanel[z];
		
		for(int i = 0; i <= x * y - 1; i++)
		{
			Color backColor = randColor();
			BigPanel panel = new BigPanel(backColor);
			flow[i] = panel;
		}
		
		addMouseMotionListener(new PanelMotionListener());
	}
	
	public Color randColor()
	{
		Random ge = new Random();
		Color c = new Color(ge.nextInt(256), ge.nextInt(256), ge.nextInt(256));
		return c;
	}
	
	private class PanelMotionListener extends MouseMotionAdapter
	{
		public void mouseDragged(MouseEvent e)
		{
			Color c = randColor();
			int newX;
			int newY;
			//int dx = newX - q;
			//int dy = newY - w; 
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
					panel.setColor(c);
				q = newX;
				w = newX;
				repaint();
			}
		}
	}
	
}
