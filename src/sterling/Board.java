package sterling;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class Board extends JFrame
{
	/**
	 *  Version 1
	 */
	private static final long serialVersionUID = 1L;

	//Array of 64 Tiles 
	private Tile[] backboard = new Tile[64];
	
	//Keeps track of the number of tiles on the board
	private int count = 0;
	
	//Keeps track of the last clicked circle 
	static Circle selected;
	
	//Allows differentiation between black and white turns
	private int turn = -1;
	
	private String infoTitle = "Game Info";
	
	//Variable for Matte Border size for centerPanel and turnPanel (purely for convenience)
	int cBor = 5;
	
	//Serves as a colored indicator for which player's turn is in progress
	private JPanel turnPanel = new JPanel();
	
	//Label that indicates the turn Panel's function
	private JLabel turnLabel = new JLabel("Turn: ");
	
	//Buttons for game control functions
	private JButton startButton = new JButton("Start");
	private JButton passButton = new JButton("Pass");
	private JButton endGameButton = new JButton("End Game"); 
	private JButton rulesButton = new JButton("Rules");
	
	//Specified border presets for the turn Panel (purely for convenience and readability)
	private Border blackBorder = BorderFactory.createMatteBorder(cBor, cBor, cBor, cBor, Color.black);
	private Border whiteBorder = BorderFactory.createMatteBorder(cBor, cBor, cBor, cBor, Color.white);
	 
	////	Constructor
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
	
		//Sets turn indicator as initially invisible
		turnPanel.setBackground(new Color(222, 184, 135));
		turnPanel.setBorder(BorderFactory.createMatteBorder(cBor, cBor, cBor, cBor, new Color(222, 184, 135)));
		
		//Sets turn label font
		turnLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		
		northPanel.setBackground(new Color(222, 184, 135));
		northPanel.add(turnLabel);
		northPanel.add(turnPanel);
		
		//container.setLayout(new GridLayout(8, 8));
	
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
		
		//Adds buttons to south Panel, along with some empty cells for spacing
		southPanel.add(startButton);
		southPanel.add(passButton);
		southPanel.add(endGameButton);
		southPanel.add(new JLabel(" "));
		southPanel.add(new JLabel(" "));
		southPanel.add(new JLabel(" "));
		southPanel.add(rulesButton);
		
		
		///////////
		
		//Adds listeners to each button
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
	
	
	/////	Check Methods
	//	--The k variable in all check methods is necessary to keep track of origin tile
	//	--For methods that have an r variable, the loops iterate for the maximum number of times unless they are stopped
	//	--All check methods are based of the tile that is clicked by the user
	//	--All check methods take a reference point "i", a direction for check "direc", 
	//	  a color to set tiles to if check is successful "setColor", and a color to 
	//	  search for when checking
	
	public void horizontalCheck(int i, int direc, Color setColor, Color searchColor)
	{
		int k = i;
		
		//Left--Right Search
		//If direction is 1 AND tile is not the last element in a row AND if the tile after it is the search color
		if(direc == 1 && !(i % 8 == 7) && backboard[i + 1].getPieceColor().equals(searchColor) )
		{
			//Sets reference to next tile
			i++;
			
			//Searches and subsequently proceeds to next tile UNTIL it reaches the end of the row UNLESS one of the If statements is rendered TRUE
			while(i <  (i - (i % 8)) + 7)
			{
				//If the tile is the end of a column OR a blank tile, stop searching 
				if( (i % 8 == 7) || backboard[i + 1].getPieceColor().equals( new Color(0, 156, 11)))
				{
					break;
				}
				
				//If the next tile is the set Color, set all tiles that were searched through, and the original tile to the set Color
				if(backboard[i + 1].getPieceColor().equals(setColor))
				{
					for(int j = i; j > k; j--)
					{
						backboard[j].setPieceColor(setColor);
					}
					
					selected.setColor(setColor);
					selected.setTaken(true);
					break;
				}
				
				i++;
			}
		}
		
		//Right--Left Search
		//If direction is -1 AND tile is not the first element in a row AND if the tile before it is the search color
		if(direc == -1 && !(i % 8 == 0) && backboard[i - 1].getPieceColor().equals(searchColor) )
		{
			//Sets reference to previous tile
			i--;
			
			//Searches and subsequently proceeds to previous tile UNTIL it reaches the beginning of the row UNLESS one of the If statements is rendered TRUE
			while(i > i - (i % 8) )
			{
				//If the tile is the beginning of a column OR a blank tile, stop searching 
				if( (i % 8 == 0) || backboard[i - 1].getPieceColor().equals( new Color(0, 156, 11)))
				{
					break;
				}
				
				//If the previous tile is the set Color, set all tiles that were searched through, and the original tile to the set Color
				if(backboard[i - 1].getPieceColor().equals(setColor))
				{
					for(int j = i; j < k; j++)
					{
						backboard[j].setPieceColor(setColor);
					}
					
					selected.setColor(setColor);
					selected.setTaken(true);
					break;
				}
				
				i--;
			}
		}
	}
	
	public void diagonalCheck(int i, int direc, Color setColor, Color searchColor)
	{
		int k = i;
		int r = 0;
		
		//Down--Right Search
		//If direction is 1 AND tile is not the last element in a row AND the tile is not in the last row AND if the tile after it is the search color
		if(direc == 1 && !(i <= 63 && i >= 56) && !(i % 8 == 7) && backboard[i + 9].getPieceColor().equals(searchColor) )
		{
			//Sets reference to tile directly down and to the right
			i += 9;
			
			//Searches and subsequently proceeds to the tile directly down and to the right UNTIL one of the If statements is rendered TRUE
			while(r < 7)
			{
				//If the next tile is outside of the array OR if current tile is last element in a row OR if next tile is blank, stop searching
				if( (i + 9 > 63) || (i % 8 == 7) || backboard[i + 9].getPieceColor().equals( new Color(0, 156, 11)) )
				{
					break;
				}
				
				//If the tile down and right is the set Color, set all tiles that were searched through, and the original tile to the set Color
				if(backboard[i + 9].getPieceColor().equals(setColor))
				{
					for(int j = i; j > k; j -= 9)
					{
						backboard[j].setPieceColor(setColor);
					}
					
					selected.setColor(setColor);
					selected.setTaken(true);
					break;
				}
				
				
				r++;
				i += 9;
			}
		}
		
		//Up--Left Search
		//If direction is -1 AND tile is not the first element in a row AND the tile is not in the first row AND if the tile after it is the search color
		if(direc == -1  && !(i <= 7 && i >= 0) && !(i % 8 == 0) && backboard[i - 9].getPieceColor().equals(searchColor) )
		{
			//Sets reference to tile directly up and to the left
			i -= 9;
			
			//Searches and subsequently proceeds to the tile directly up and to the left UNTIL one of the If statements is rendered TRUE
			while(r < 7)
			{
				//If the next tile is outside of the array OR if current tile is in the first element of a row OR if the next tile is blank, stop searching
				if( (i - 9 < 0) || (i % 8 == 0) || backboard[i - 9].getPieceColor().equals( new Color(0, 156, 11)) )
				{
					break;
				}
				
				//If the tile up and to the left is the set Color, set all tiles that were searched through, and the original tile to the set Color
				if(backboard[i - 9].getPieceColor().equals(setColor))
				{
					for(int j = i; j < k; j += 9)
					{
						backboard[j].setPieceColor(setColor);
					}
					
					selected.setColor(setColor);
					selected.setTaken(true);
					break;
				}
				
				r++;
				i -= 9;
			}
		}
		
		//Up--Right Search
		//If the direction is 2 AND tile is not the last element in a row AND the tile is not in the first row AND if the tile after it is the search color
		if(direc == 2 && !(i <= 7 && i >= 0) && !(i % 8 == 7) && backboard[i - 7].getPieceColor().equals(searchColor) )
		{
			//Sets reference to tile directly up and to the right
			i -= 7;
			
			//Searches and subsequently proceeds to the tile directly up and to the right UNTIL one of the If statements is rendered TRUE
			while(r < 7)
			{
				//If the next tile is outside of the array OR if the current tile is the last element in a row OR if the next tile is blank, stop searching 
				if( (i - 7 < 0) || (i % 8 == 7) || backboard[i - 7].getPieceColor().equals( new Color(0, 156, 11)) )
				{
					break;
				}
				
				//If the tile up and to the right is the set Color, set all tiles that were searched through, and the original tile to the set Color
				if(backboard[i - 7].getPieceColor().equals(setColor))
				{
					for(int j = i; j < k; j += 7)
					{
						backboard[j].setPieceColor(setColor);
					}
					
					selected.setColor(setColor);
					selected.setTaken(true);
					break;
				}
				
				r++;
				i -= 7;
			}
		}
		
		//Down--Left Search
		//If the direction is -2 AND tile is not the first element in a row AND the tile is not in the last row AND if the tile after it is the search color
		if(direc == -2 && !(i <= 63 && i >= 56) && !(i % 8 == 0) && backboard[i + 7].getPieceColor().equals(searchColor) )
		{
			//Sets reference to tile directly down and to the left
			i += 7;
			
			//Searches and subsequently proceeds to the tile directly up and to the right UNTIL one of the If statements is rendered TRUE
			while(r < 7)
			{
				//If the next tile is outside of the array OR if the current tile is the first element in a row OR if the next tile is blank, stop searching
				if( (i + 7 > 63) || (i % 8 == 0) || backboard[i + 7].getPieceColor().equals(new Color(0, 156, 11)) )
				{
					break;
				}
				
				//If the tile down and to the left is the set Color, set all tiles that were searched through, and the original tile to the set Color
				if(backboard[i + 7].getPieceColor().equals(setColor))
				{
					for(int j = i; j > k; j -= 7)
					{
						backboard[j].setPieceColor(setColor);
					}
					
					selected.setColor(setColor);
					selected.setTaken(true);
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
		
		//Up--Down Search
		//If the direction is 1 AND the tile is not in the last row AND if the tile after it is the search color
		if(direc == 1 && !(i >= 56 && i <= 63) && backboard[i + 8].getPieceColor().equals(searchColor) )
		{
			//Sets reference to tile directly down one
			i += 8;
			
			//Searches and subsequently proceeds to the tile directly down UNTIL one of the If statements is rendered TRUE
			while(r < 8)
			{
				//If the next tile is outside of the array OR if the next tile is blank, stop searching
				if( (i + 8 > 63) || backboard[i + 8].getPieceColor().equals(new Color(0, 156, 11)) )
				{
					break;
				}
				
				//If the tile directly down is the set Color, set all tiles that were searched through, and the original tile to the set Color
				if(backboard[i + 8].getPieceColor().equals(setColor))
				{
					for(int j = i; j > k; j -= 8)
					{
						backboard[j].setPieceColor(setColor);
					}
					
					selected.setColor(setColor);
					selected.setTaken(true);
					break;
				}
				
				r++;
				i += 8;
			}
		}
		
		//Down--Up Search
		//If the direction is -1 AND the tile is not in the first row AND if the tile after it is the search color
		if(direc == -1 && !(i >= 0 && i <= 7) && backboard[i - 8].getPieceColor().equals(searchColor) )
		{
			//Sets reference to tile directly up one
			i -= 8;
			
			//Searches and subsequently proceeds to the tile directly up UNTIL one of the If statements is rendered TRUE
			while(r < 8)
			{
				//If the next tile is outside of the array OR if the next tile is blank, stop searching
				if( (i - 8 < 0) || backboard[i - 8].getPieceColor().equals(new Color(0, 156, 11)) )
				{
					break;
				}
				
				//If the tile directly up is the set Color, set all tiles that were searched through, and the original tile to the set Color
				if(backboard[i - 8].getPieceColor().equals(setColor))
				{
					for(int j = i; j < k; j += 8)
					{
						backboard[j].setPieceColor(setColor);
					}
					
					selected.setColor(setColor);
					selected.setTaken(true);
					break;
				}
				
				r++;
				i -= 8;
			}
		}
	}
	
	public void isSurrounding(int i)
	{
		//Determines search and set colors based on turn and uses every check
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
	
	//////	Mouse Adapter for Board
	
	private class PanelListener extends MouseAdapter
	{
		//Activated upon mouse being pressed on component
		public void mousePressed(MouseEvent e)
		{				
			//First checks if circle on clicked tile has already been "taken"
			if(!selected.isTaken() && turn >= 0)
			{				
				//Calls method for checking surroundings for tiles (according to the rules)
				isSurrounding(selected.getIndex());
				
				//If the tile ends up being "taken" (which is determined by the isSurrounding method)
				if(selected.isTaken())
				{
					//Advances turn count and tile count
					turn++;
					count++;
					
					//Changes turn indicator according to new turn
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
		
		//Activated once mouse is released (not necessarily on component)
		public void mouseReleased(MouseEvent e)
		{
			//Refreshes the paintComponent method
			repaint();
		}
	}
	
	//////	Action Listeners for Buttons
	
	//Listener for Start button
	private class StartListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Only activates at start of the game
			if(turn == -1)
			{
				//Sets the original 4 pieces on the board
				backboard[27].setPieceColor(Color.white);
				backboard[27].setPieceTaken(true);
				
				backboard[28].setPieceColor(Color.black);
				backboard[28].setPieceTaken(true);
				
				backboard[35].setPieceColor(Color.black);
				backboard[35].setPieceTaken(true);
				
				backboard[36].setPieceColor(Color.white);
				backboard[36].setPieceTaken(true);
				
				//Sets turn to zero, which allows for game functions to begin
				turn = 0;
				count = 4;
				
				//Sets turn indicator to black to indicate the start of the game
				turnPanel.setBackground(Color.black);
				turnPanel.setBorder(blackBorder);
			}
			
			//Tells user that game is already running if the game is already running
			else
			{
				JOptionPane.showMessageDialog(Board.this, "Game is already running. To restart, press \"End Game\"\n "
						+ "and then click \"Start\"", infoTitle, 1);
			}
		}
	}
	
	//Listener for Pass button
	private class PassListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Tells user that the game hasn't started yet and therefore the turn can't be passed
			if(turn == -1)
			{
				JOptionPane.showMessageDialog(Board.this, "Game has not started. To start game, press \"Start\"", infoTitle, 1);
			}
			
			//Sets the turn counter forward by one and checks to see which color it should switch the turn indicator to
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
	
	//Listener for End Game button
	private class EndGameListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Tells user that the game hasn't started yet and therefore cannot be ended
			if(turn == -1)
			{
				JOptionPane.showMessageDialog(Board.this, "Game has not started. To start game, press \"Start\"", infoTitle, 1);
			}
			
			//Activates endgame protocols
			else
			{
				//Tells user how many tiles were placed during the match
				JOptionPane.showMessageDialog(Board.this, "A total of " + count + " tiles were placed" , infoTitle, 1);
				
				//Variables to keep track of each player score
				int black = 0, white = 0;
				
				//Searches through backboard completely and counts how many of each color are present
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
				
				//Tell user who has won or if the game is a draw
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
				
				//Resets board with neutral color
				for(int i = 0; i < backboard.length; i++)
				{
					backboard[i].setBackground(new Color(0, 156, 11));
					backboard[i].setPieceColor(new Color(0, 156, 11));
					backboard[i].setPieceTaken(false);
				}
				
				//Sets turn panel to a color such that it blends in and is rendered invisible
				turnPanel.setBackground(new Color(222, 184, 135));
				turnPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(222, 184, 135)));
				
				//Effectively restarts the game
				turn = -1;
				count = 0;
			}
		}
	}
	
	//Listener for Rules button
	private class RulesListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Checks for any generic exception when parsing string to URI and displays error message without terminating the program 
			try 
			{
				//Link to rules
				final String uri = "https://www.yourturnmyturn.com/rules/reversi.php";
				
				//Instructs desktop to open rules ***Make sure that default browser is NOT MICROSOFT EDGE, any other will work***
				Desktop.getDesktop().browse(URI.create(uri));
			} 
			catch (Exception ex) 
			{
				//Error message
				JOptionPane.showMessageDialog(Board.this, "Error: String could not be parsed as URI, go to \n"
						+ "https://www.yourturnmyturn.com/rules/reversi.php  \nto view rules", "Program Exception", 0);
			}
		}
	}
	
	
	
}
