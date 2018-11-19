package guiWin;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



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
		addKeyListener(new KeyMonitor());
		

		Action leftAction = new LeftAction();
		this.getInputMap().put(KeyStroke.getKeyStroke("F2"), "doSomething");
		this.getActionMap().put("doSomething", leftAction);

		
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
			color = randColor();
			repaint();
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
	
	private class KeyMonitor extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			switch(e.getKeyCode())
			{
			case KeyEvent.VK_SHIFT:
				color = randColor();
				repaint();
				break;
			/*case KeyEvent.VK_UP:
				color = bigColor;
				repaint();
	            break;*/
			}
		}
	}
	
	class LeftAction extends AbstractAction
	{
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e)
		{
			color = randColor();
		}
	}
	
}
