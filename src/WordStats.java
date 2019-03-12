//Project 11.1

import javax.swing.JOptionPane;

public class WordStats
{

	public static void main(String[] args)
	{
		String input;
		String title = "WordStats";
		
		JOptionPane.showMessageDialog(null, "Welcome to WordStats: free sentence analysis", title, 1);
		JOptionPane.showMessageDialog(null, "Copyright Valve Inc. 2019, All Rights Reserved", "Copyright Statement", 1);
		
		input = JOptionPane.showInputDialog(null, "Enter a String", title, 1);
		
		input= input.trim();
		
		int words = 0, length, pos = 0; //, a;
		double avelength = 0;
		
		if(!input.isEmpty())
		{
			length = input.length();
			
			if(input.indexOf(" ") == -1)
			{
				words = 1;
				avelength = length;
			}
			
			else
			{
				String w;
				int end = 0; 
				
				while(end != -1)
				{
					end = input.indexOf(" ", pos);
					
					if(end == -1)
					{
						if(input.charAt(end + 1) != ' ' && pos != length)
						{
							words++;
							avelength += length - pos;
						}
						
						break;
					}
					
					if(input.charAt(end + 1) != ' ')
					{
						w = input.substring(pos, end);
						
						words++;
						
						avelength += w.length();
					}
					
					pos = end + 1;
				}
				
				avelength /= (double) words;
			}
						
			
			JOptionPane.showMessageDialog(null, "Sentence Length: " + length + "\n"
											  + "Total Words: " + words + "\n"
											  + "Average Word Length: " + avelength, title, 1);
		}
		
		else
		{
			JOptionPane.showMessageDialog(null, "Error: string must not be empty", "Program Exception", 0);
		}
		
		
		
	}

}