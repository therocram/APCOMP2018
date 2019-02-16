package sterling;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Tile extends JPanel
{
	//private Color color;
	
	//Assigns a circle to Tile
	private Circle piece;
	
	////	Constructor
	public Tile()
	{
		//Calls JPanel constructor
		super();
		
		//Attaches senseor to detect mouse input
		addMouseListener(new PanelListener());
		
		// Instantiates piece, setting it at a position relative to the tile
		// and setting the color the same as the tile
		piece = new Circle(getX() + 37, getY() + 27, 20, new Color(0, 156, 11));
	}
	
	
	//Paint class, updated every time a change is made to a piece
	public void paintComponent(Graphics g)
	{
		//Calls superclass constructor
		super.paintComponent(g);
		
		//color = getBackground();
		
		//Draws piece and fills it with corresponding color
		piece.fill(g);
		
	}
	
	////	Mutators
	public void setPieceColor(Color c)
	{
		piece.setColor(c);
		repaint();
	}
	
	public void setPieceTaken()
	{
		piece.taken = true;
	}
	
	public void setIndex(int i) 
	{
		piece.setIndex(i);
	}
	
	public void setCanPlace(boolean canPlace)
	{
		piece.setCanPlace(canPlace);
	}
	
	
	////	Accessors
	public Color getPieceColor()
	{
		return piece.getColor();
	}

	public int getIndex() 
	{
		return piece.getIndex();
	}
	
	public boolean isCanPlace()
	{
		return piece.isCanPlace();
	}

	
	////	Mouse Listener Class
	private class PanelListener extends MouseAdapter
	{
		//Sets selected piece on board to Tile piece when the Tile is clicked
		public void mousePressed(MouseEvent e)
		{
			Board.selected = piece;
		}
		
	}

	
	
	
	
	
}
