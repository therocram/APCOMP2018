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
		
		int words = 0, length, pos = 0, a;
		double avelength = 0;
		
		length = input.length();
		
		if(!input.isEmpty() && input.charAt(pos) != ' ')
		{
			words++;
			a = input.indexOf(" ", pos);
			if(a == -1)
				avelength += length;
			else
				avelength += a;	
		}
		
		while(true)
		{
			a = input.indexOf(" ", pos);
			
			if(a == -1)
			{
				break;
			}
			else if(input.charAt(a + 1) != ' ')
			{
				words++;
				avelength += a - pos - 1;
				System.out.println(avelength);
			}
			
			pos = a + 1;
		}
		
		if(!input.isEmpty())
		{
			avelength /= (double) words;
		}
		
		JOptionPane.showMessageDialog(null, "Sentence Length: " + length + "\n"
										  + "Total Words: " + words + "\n"
										  + "Average Word Length: " + avelength, title, 1);
		
	}

}