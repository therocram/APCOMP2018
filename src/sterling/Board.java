package sterling;
import javax.swing.*;
import java.awt.*;

public class Board extends JFrame
{
	private JPanel[] backboard = new JPanel[64];
	private Tile[] pieces = new Tile[64]; 
	
	public Board()
	{
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		
		Container container = getContentPane();
		
		container.add(northPanel, BorderLayout.NORTH);
		container.add(southPanel, BorderLayout.SOUTH);
	}
	
	
	
}
