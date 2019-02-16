package sterling;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board extends JFrame
{
	//Array of 64 Tiles 
	private Tile[] backboard = new Tile[64];
	
	//Keeps track of the number of tiles on the board
	private int count = 4;
	
	//Keeps track of the last clicked circle 
	static Circle selected;
	
	//Allows differentiation between black and white turns
	static int turn = 0;
	
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
		
		//Adds general panels to container
		container.add(northPanel, BorderLayout.NORTH);
		container.add(centerPanel, BorderLayout.CENTER);
		container.add(southPanel, BorderLayout.SOUTH);
		
		//container.setLayout(new GridLayout(8, 8));
		
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
		
		//Sets the original 4 pieces on the board
		
		backboard[27].setPieceColor(Color.white);
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
		
		backboard[8].setPieceColor(Color.white);
		backboard[8].setPieceTaken();
		
		backboard[16].setPieceColor(Color.black);
		backboard[16].setPieceTaken();
		
		
		///////////
		
		//Sets the title, window position, and minimum window size
		setTitle("Reversi (Othello)");
		setBounds(500, 200, 500, 500);
		setMinimumSize(new Dimension(621, 536));
		
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
	
	public void horizontalCheck(int i, int direc)
	{
		int k = i;
		
		if( !(i == 63) && backboard[i + 1].getPieceColor().equals(Color.white) && direc == 1)
		{
			i++;
			
			while(i <  (i - (i % 8)) + 7)
			{
				if(backboard[i + 1].getPieceColor().equals(Color.black))
				{
					for(int j = i; j > k; j--)
					{
						backboard[j].setPieceColor(Color.black);
					}
					
					selected.setColor(Color.black);
					selected.taken = true;
					break;
					/*
					turn++;
					count++;*/
				}
				
				if(backboard[i + 1].getPieceColor().equals( new Color(0, 156, 11)))
				{
					break;
				}
				
				i++;
			}
		}
		
		if( !(i == 0) && backboard[i - 1].getPieceColor().equals(Color.white))
		{
			i--;
			
			while(i > i - (i % 8) )
			{
				System.out.println(i);
				
				if(backboard[i - 1].getPieceColor().equals(Color.black))
				{
					for(int j = i; j < k; j++)
					{
						backboard[j].setPieceColor(Color.black);
					}
					
					selected.setColor(Color.black);
					selected.taken = true;
					break;
					/*
					turn++;
					count++;*/
				}
				
				if(backboard[i - 1].getPieceColor().equals( new Color(0, 156, 11)))
				{
					break;
				}
				
				i--;
			}
		}
	}
	
	public void diagonalCheck(int i, int direc)
	{
		int k = i;
		int r = 0;
		
		if(!(i == 63) && backboard[i + 9].getPieceColor().equals(Color.white) && direc == 1)
		{
			i += 9;
			
			while(r < 7 - (k % 8))
			{
				System.out.println(i);
				System.out.println(r);
				if(backboard[i + 9].getPieceColor().equals(Color.black))
				{
					for(int j = i; j > k; j -= 9)
					{
						backboard[j].setPieceColor(Color.black);
					}
					
					selected.setColor(Color.black);
					selected.taken = true;
					break;
				}
				
				if(backboard[i + 9].getPieceColor().equals( new Color(0, 156, 11)) || i + 9 > 63)
				{
					break;
				}
				
				r++;
				i += 9;
			}
		}
		
		if(!(i == 0) && backboard[i - 9].getPieceColor().equals(Color.white) && direc == -1)
		{
			i -= 9;
			
			while(r < k % 8)
			{
				if(backboard[i - 9].getPieceColor().equals(Color.black))
				{
					for(int j = i; j < k; j += 9)
					{
						backboard[j].setPieceColor(Color.black);
					}
					
					selected.setColor(Color.black);
					selected.taken = true;
					break;
				}
				
				if(backboard[i - 9].getPieceColor().equals( new Color(0, 156, 11)) || i - 9 < 0)
				{
					break;
				}
				
				r++;
				i -= 9;
			}
		}
	}
	
	public void isSurrounding(int i)
	{
		int k = i;
		
		
		
		if(turn % 2 == 0)
		{
			horizontalCheck(i, 1);
			horizontalCheck(i, -1);
			diagonalCheck(i, 1);
			
			if(i == 0)
			{
				//horizontalCheck(i, 1);
				
				//i = k;
				
				
				i = k;
				
				if(backboard[i + 8].getPieceColor().equals(Color.white))
				{
					i += 8;
					
					while(i < 56)
					{
						if(backboard[i + 8].getPieceColor().equals(Color.black))
						{
							for(int j = i; j > 0; j -= 8)
							{
								backboard[j].setPieceColor(Color.black);
							}
							
							selected.setColor(Color.black);
							selected.taken = true;
							break;
						}
						
						i += 8;
					}
					
				}
				
			}
			
			return;
			
		}
		
		
		else
		{
			
		} 
		
	}
	
	private class PanelListener extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{	
			System.out.println("tile first");
			System.out.println("Postition: " + selected.getIndex() + " " + turn + " Count: " + count + "  " + (selected.getIndex() % 8));
			
			//canPlaceCheck(selected.getIndex());
			
			if(!selected.taken)
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
	
	
	
}
