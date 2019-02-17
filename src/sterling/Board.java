package sterling;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class Board extends JFrame
{
	//Array of 64 Tiles 
	private Tile[] backboard = new Tile[64];
	
	//Keeps track of the number of tiles on the board
	private int count = 4;
	
	//Keeps track of the last clicked circle 
	static Circle selected;
	
	//Allows differentiation between black and white turns
	private int turn = -1;
	
	private String infoTitle = "Game Info";
	
	private JPanel turnPanel = new JPanel();
	
	private JLabel turnLabel = new JLabel("Turn: ");
	
	private JButton startButton = new JButton("Start");
	private JButton passButton = new JButton("Pass");
	private JButton endGameButton = new JButton("End Game"); 
	private JButton rulesButton = new JButton("Rules");
	
	private Border blackBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black);
	private Border whiteBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white);
	
	//public Circle[] pieces = new Circle[64];  
	
	public Board()
	{
		//Defines separate position panels
		//	-- North Panel contains current game info
		//  -- Center Panel is the actual board, an 8x8 grid
		//  -- South Panel is game control
		
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		JPanel centerPanel = new JPanel(new GridLayout(8, 8));
		
		//Defines window container (to order panels and other elements)
		Container container = getContentPane();
		
		//Adds orientation panels to container in respective alignments 
		container.add(northPanel, BorderLayout.NORTH);
		container.add(centerPanel, BorderLayout.CENTER);
		container.add(southPanel, BorderLayout.SOUTH);
		
		turnPanel.setBackground(new Color(222, 184, 135));
		turnPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(222, 184, 135)));
		
		northPanel.setBackground(new Color(222, 184, 135));
		northPanel.add(turnLabel);
		northPanel.add(turnPanel);
		
		//container.setLayout(new GridLayout(8, 8));
		
		//Variable for Matte Border size for centerPanel (purely for convenience)
		int cBor = 5;
		
		//Adds brownish border to centerPanel  
		centerPanel.setBorder(BorderFactory.createMatteBorder( 2 * cBor, cBor,  2 * cBor, cBor, new Color(222, 184, 135)));
		
		for(int i = 0; i < backboard.length; i++)
		{
			//Instantiates a new tile and sets its index, background color, and border specifications
			backboard[i] = new Tile();
			backboard[i].setIndex(i);
			backboard[i].setBackground(new Color(0, 156, 11));
			backboard[i].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
			
			//Adds tile to Center Panel
			centerPanel.add(backboard[i]);
			
			//Adds sensor to detect mouse input on each panel
			backboard[i].addMouseListener(new PanelListener());
			
			//pieces[i] = new Circle(backboard[i].getLocation(), 5, Color.black);
		}
		
		southPanel.add(startButton);
		southPanel.add(passButton);
		southPanel.add(endGameButton);
		southPanel.add(new JLabel(""));
		southPanel.add(new JLabel(""));
		southPanel.add(new JLabel(""));
		southPanel.add(rulesButton);
		
		//Sets the original 4 pieces on the board
		
		/*backboard[27].setPieceColor(Color.white);
		backboard[27].setPieceTaken();
		
		backboard[28].setPieceColor(Color.black);
		backboard[28].setPieceTaken();
		
		backboard[35].setPieceColor(Color.black);
		backboard[35].setPieceTaken();
		
		backboard[36].setPieceColor(Color.white);
		backboard[36].setPieceTaken();
		
		backboard[1 + 8].setPieceColor(Color.white);
		backboard[1 + 8].setPieceTaken();
		
		backboard[2 + 16].setPieceColor(Color.white);
		backboard[2 + 16].setPieceTaken();
		
		backboard[45].setPieceColor(Color.black);
		backboard[45].setPieceTaken();
		
		backboard[1].setPieceColor(Color.white);
		backboard[1].setPieceTaken();
		
		backboard[2].setPieceColor(Color.black);
		backboard[2].setPieceTaken();
		
		backboard[3].setPieceColor(Color.white);
		backboard[3].setPieceTaken();
		
		backboard[4].setPieceColor(Color.black);
		backboard[4].setPieceTaken();
		
		backboard[53].setPieceColor(Color.white);
		backboard[53].setPieceTaken();
		
		backboard[60].setPieceColor(Color.black);
		backboard[60].setPieceTaken();*/
		
		
		///////////
		startButton.addActionListener(new StartListener());
		passButton.addActionListener(new PassListener());
		endGameButton.addActionListener(new EndGameListener());
		rulesButton.addActionListener(new RulesListener());
		///////////
		
		//Sets the title, window position, and minimum window size
		setTitle("Reversi (Othello)");
		setBounds(500, 200, 500, 500);
		setMinimumSize(new Dimension(621, 621));
		
		//Tells program to terminate when window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Packs tiles into grid layout
		pack();
		
		//Tells program to display window
		setVisible(true);
	}
	
	/*public void place(int i)
	{
		int k = i;
		
		if(turn % 2 == 0)
		{
			if(i == 0)
			{
				if((backboard[i + 1].getPieceColor().equals(Color.white)))
				{	
					i++;
					
					while(i < 7)
					{
						if(backboard[i + 1].getPieceColor().equals(Color.black))
						{
							for(int j = i; j > 0; j--)
							{
								backboard[j].setPieceColor(Color.black);
							}
						}
						
						i++;
					}
				}
				
		
				
				
			}
			
			return;
			
	
		}
		
		
		else
		{
			
		}
	}
	
	public boolean willSurround(int i)
	{
		boolean willSurround = false;
		
		if(turn % 2 == 0)
		{
			if(i == 0)
			{
				if(!(backboard[i + 1].getPieceColor().equals(Color.white)))
				{
					return willSurround;
				}
				
				i++;
				
				while(i < 7)
				{
					if(backboard[i + 1].getPieceColor().equals(Color.black))
					{
						for(int j = i; j > 0; j--)
						{
							backboard[j].setPieceColor(Color.black);
						}
					}
					
					i++;
				}
				
				return willSurround;
			}
			
	
		}
		
		
		else
		{
			
		} 
		
		
		
		return willSurround;
	}*/
	
	public void horizontalCheck(int i, int direc, Color setColor, Color searchColor)
	{
		int k = i;
		
		if(direc == 1 && !(i % 8 == 7) && backboard[i + 1].getPieceColor().equals(searchColor) )
		{
			i++;
			
			while(i <  (i - (i % 8)) + 7)
			{
				if( (i + 1 % 8 == 7) || backboard[i + 1].getPieceColor().equals( new Color(0, 156, 11)))
				{
					break;
				}
				
				if(backboard[i + 1].getPieceColor().equals(setColor))
				{
					for(int j = i; j > k; j--)
					{
						backboard[j].setPieceColor(setColor);
					}
					
					selected.setColor(setColor);
					selected.taken = true;
					break;
					/*
					turn++;
					count++;*/
				}
				
				i++;
			}
		}
		
		if(direc == -1 && !(i % 8 == 0) && backboard[i - 1].getPieceColor().equals(searchColor) )
		{
			i--;
			
			while(i > i - (i % 8) )
			{
				System.out.println(i);
				
				if( (i - 1 % 8 == 0) || backboard[i - 1].getPieceColor().equals( new Color(0, 156, 11)))
				{
					break;
				}
				
				if(backboard[i - 1].getPieceColor().equals(setColor))
				{
					for(int j = i; j < k; j++)
					{
						backboard[j].setPieceColor(setColor);
					}
					
					selected.setColor(setColor);
					selected.taken = true;
					break;
					/*
					turn++;
					count++;*/
				}
				
				i--;
			}
		}
	}
	
	public void diagonalCheck(int i, int direc, Color setColor, Color searchColor)
	{
		int k = i;
		int r = 0;
		
		if(direc == 1 && !(i <= 63 && i >= 56) && !(i % 8 == 7) && backboard[i + 9].getPieceColor().equals(searchColor) )
		{
			i += 9;
			
			while(r < 7)
			{
				if( (i + 9 > 63) || (i <= 63 && i >= 56) || (i % 8 == 7) || backboard[i + 9].getPieceColor().equals( new Color(0, 156, 11)) )
				{
					break;
				}
				
				System.out.println(i);
				System.out.println(r);
				if(backboard[i + 9].getPieceColor().equals(setColor))
				{
					for(int j = i; j > k; j -= 9)
					{
						backboard[j].setPieceColor(setColor);
					}
					
					selected.setColor(setColor);
					selected.taken = true;
					break;
				}
				
				
				r++;
				i += 9;
			}
		}
		
		if(direc == -1  && !(i <= 7 && i >= 0) && !(i % 8 == 0) && backboard[i - 9].getPieceColor().equals(searchColor) )
		{
			i -= 9;
			System.out.println("horizontal");
			while(r < 7)
			{
				if( (i - 9 < 0)  || (i % 8 == 0)  || backboard[i - 9].getPieceColor().equals( new Color(0, 156, 11)) )
				{
					break;
				}
				
				if(backboard[i - 9].getPieceColor().equals(setColor))
				{
					for(int j = i; j < k; j += 9)
					{
						backboard[j].setPieceColor(setColor);
					}
					
					selected.setColor(setColor);
					selected.taken = true;
					break;
				}
				
				r++;
				i -= 9;
			}
		}
		
		if(direc == 2 && !(i <= 7 && i >= 0) && !(i % 8 == 7) && backboard[i - 7].getPieceColor().equals(searchColor) )
		{
			i -= 7;
			
			while(r < 7)
			{
				if( (i - 7 < 0) || (i <= 7 && i >= 0) || (i % 8 == 7) || backboard[i - 7].getPieceColor().equals( new Color(0, 156, 11)) )
				{
					break;
				}
				
				if(backboard[i - 7].getPieceColor().equals(setColor))
				{
					for(int j = i; j < k; j += 7)
					{
						backboard[j].setPieceColor(setColor);
					}
					
					selected.setColor(setColor);
					selected.taken = true;
					break;
				}
				
				r++;
				i -= 7;
			}
		}
		
		if(direc == -2 && !(i <= 63 && i >= 56) && !(i % 8 == 0) && backboard[i + 7].getPieceColor().equals(searchColor) )
		{
			i += 7;
			
			while(r < 7)
			{
				if( (i + 7 > 63) || (i <= 63 && i >= 56) || (i % 8 == 0) || backboard[i + 7].getPieceColor().equals(new Color(0, 156, 11)) )
				{
					break;
				}
				
				if(backboard[i + 7].getPieceColor().equals(setColor))
				{
					for(int j = i; j > k; j -= 7)
					{
						backboard[j].setPieceColor(setColor);
					}
					
					selected.setColor(setColor);
					selected.taken = true;
					break;
				}
				
				r++;
				i += 7;
			}
		}
	}
	
	public void verticalCheck(int i, int direc, Color setColor, Color searchColor)
	{
		int k = i;
		int r = 0;
		
		if(direc == 1 && !(i >= 56 && i <= 63) && backboard[i + 8].getPieceColor().equals(searchColor) )
		{
			i += 8;
			
			while(r < 8)
			{
				if( (i + 8 > 63) || (i + 8 >= 56 && i <= 63) || backboard[i + 8].getPieceColor().equals(new Color(0, 156, 11)) )
				{
					break;
				}
				
				if(backboard[i + 8].getPieceColor().equals(setColor))
				{
					for(int j = i; j > k; j -= 8)
					{
						backboard[j].setPieceColor(setColor);
					}
					
					selected.setColor(setColor);
					selected.taken = true;
					break;
				}
				
				r++;
				i += 8;
			}
		}
		
		if(direc == -1 && !(i >= 0 && i <= 7) && backboard[i - 8].getPieceColor().equals(searchColor) )
		{
			i -= 8;
			
			while(r < 8)
			{
				if( (i - 8 < 0) || (i - 8 >= 0 && i - 8 <= 7) || backboard[i - 8].getPieceColor().equals(new Color(0, 156, 11)) )
				{
					break;
				}
				
				if(backboard[i - 8].getPieceColor().equals(setColor))
				{
					for(int j = i; j < k; j += 8)
					{
						backboard[j].setPieceColor(setColor);
					}
					
					selected.setColor(setColor);
					selected.taken = true;
					break;
				}
				
				r++;
				i -= 8;
			}
		}
	}
	
	public void isSurrounding(int i)
	{
		//int k = i;
		
		if(turn % 2 == 0)
		{
			horizontalCheck(i, 1, Color.black, Color.white);
			horizontalCheck(i, -1, Color.black, Color.white);
			diagonalCheck(i, 1, Color.black, Color.white);
			diagonalCheck(i, -1, Color.black, Color.white);
			diagonalCheck(i, 2, Color.black, Color.white);
			diagonalCheck(i, -2, Color.black, Color.white);
			verticalCheck(i, 1, Color.black, Color.white);
			verticalCheck(i, -1, Color.black, Color.white);
			
			return;
			
		}
		
		else
		{
			horizontalCheck(i, 1, Color.white, Color.black);
			horizontalCheck(i, -1, Color.white, Color.black);
			diagonalCheck(i, 1, Color.white, Color.black);
			diagonalCheck(i, -1, Color.white, Color.black);
			diagonalCheck(i, 2, Color.white, Color.black);
			diagonalCheck(i, -2, Color.white, Color.black);
			verticalCheck(i, 1, Color.white, Color.black);
			verticalCheck(i, -1, Color.white, Color.black);
		} 
		
	}
	
	private class PanelListener extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{	
			System.out.println("tile first");
			System.out.println("Postition: " + selected.getIndex() + " " + turn + " Count: " + count + "  " + (selected.getIndex() % 8));
			
			//canPlaceCheck(selected.getIndex());
			
			if(!selected.taken && turn >= 0)
			{
				/*if(turn % 2 == 0)
				{
					selected.setColor(Color.black);
				}
				else
				{
					selected.setColor(Color.white);
				}*/
				
				
				
				isSurrounding(selected.getIndex());
				
				if(selected.taken)
				{
					turn++;
					count++;
					
					if(turn % 2 == 0)
					{
						turnPanel.setBackground(Color.black);
						turnPanel.setBorder(blackBorder);
					}
					
					else
					{
						turnPanel.setBackground(Color.white);
						turnPanel.setBorder(whiteBorder);
					}
				}
			}
			
			System.out.println();
			
			
		}
		
		public void mouseReleased(MouseEvent e)
		{

			//selected.taken = true;
			repaint();
		}
	}
	
	private class StartListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(turn == -1)
			{
				backboard[27].setPieceColor(Color.white);
				backboard[27].setPieceTaken();
				
				backboard[28].setPieceColor(Color.black);
				backboard[28].setPieceTaken();
				
				backboard[35].setPieceColor(Color.black);
				backboard[35].setPieceTaken();
				
				backboard[36].setPieceColor(Color.white);
				backboard[36].setPieceTaken();
				
				turn = 0;
				
				turnPanel.setBackground(Color.black);
				turnPanel.setBorder(blackBorder);
			}
			
			else
			{
				JOptionPane.showMessageDialog(Board.this, "Game is already running. To restart, press \"End Game\"\n "
						+ "and then click \"Start\"", infoTitle, 1);
			}
		}
	}
	
	private class PassListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(turn == -1)
			{
				JOptionPane.showMessageDialog(Board.this, "Game has not started. To start game, press \"Start\"", infoTitle, 1);
			}
			
			else
			{
				turn++;
				
				if(turn % 2 == 0)
				{
					turnPanel.setBackground(Color.black);
					turnPanel.setBorder(blackBorder);
				}
				
				else
				{
					turnPanel.setBackground(Color.white);
					turnPanel.setBorder(whiteBorder);
				}
			}
		}
	}
	
	private class EndGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(turn == -1)
			{
				JOptionPane.showMessageDialog(Board.this, "Game has not started. To start game, press \"Start\"", infoTitle, 1);
			}
			
			else
			{
				JOptionPane.showMessageDialog(Board.this, "A total of " + count + " tiles were placed" , infoTitle, 1);
				
				int black = 0, white = 0;
				
				for(int i = 0; i < backboard.length; i++)
				{
					if(backboard[i].getPieceColor().equals(Color.white))
					{
						white++;
					}
					
					if(backboard[i].getPieceColor().equals(Color.black))
					{
						black++;
					}
				}
				
				if(black == white)
				{
					JOptionPane.showMessageDialog(Board.this, "Draw!" , infoTitle, 1);
				}
				else if(black > white)
				{
					JOptionPane.showMessageDialog(Board.this, "Black Wins!" , infoTitle, 1);
				}
				else
				{
					JOptionPane.showMessageDialog(Board.this, "White Wins!" , infoTitle, 1);
				}
				
				for(int i = 0; i < backboard.length; i++)
				{
					backboard[i].setBackground(new Color(0, 156, 11));
					backboard[i].setPieceColor(new Color(0, 156, 11));
				}
				
				turnPanel.setBackground(new Color(222, 184, 135));
				turnPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(222, 184, 135)));
				
				turn = -1;
			}
		}
	}
	
	private class RulesListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try 
			{
				final String uri = "https://www.yourturnmyturn.com/rules/reversi.php";
				Desktop.getDesktop().browse(URI.create(uri));
			} 
			catch (Exception ex) 
			{
				JOptionPane.showMessageDialog(Board.this, "Error: String could not be parsed as URI" , "Program Exception", 0);
			}
		}
	}
	
	
	
}
