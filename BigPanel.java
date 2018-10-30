package guiWin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class BigPanel extends JPanel
{
	private Color color;
	private boolean selected;
	private int q, w;
	
	public BigPanel()
	{
		this(Color.WHITE);
		setBackground(Color.white);
	}
	
	public BigPanel(Color c)
	{
		setBackground(c);
		color = c;
		selected = false;
		addMouseListener(new PanelListener());
		addMouseMotionListener(new PanelMotionListener());
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
	
	private Color randColor()
	{
		Random ge = new Random();
		Color c = new Color(ge.nextInt(256), ge.nextInt(256), ge.nextInt(256));
		return c;
	}
	
	public boolean containsPoint(int x, int y)
	{
		int height = getHeight();
		int width = getWidth();
		int a = getX();
		int b = getY();
		boolean point = (x >= b && x <= b + height) && (x >= a && x <= a + width);
		return point;
	}
	
	private class PanelListener extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			q = e.getX();
			w = e.getY();
			if(containsPoint(q, w))
				selected = true;
		}
		
		public void mouseReleased(MouseEvent e)
		{
			q = e.getX();
			w = e.getY();
			selected = false;
			color = randColor();
			repaint();
		}
	}
	
	private class PanelMotionListener extends MouseMotionAdapter
	{
		public void mouseDragged(MouseEvent e)
		{
			int newX = e.getX();
			int newY = e.getY();
			int dx = newX - q;
			int dy = newY - w;
			if(containsPoint(dx + newX, dy + newY))
				color = randColor();
			q = newX;
			w = newY;
			repaint();	
		}
	}
	
	
	
	
}
