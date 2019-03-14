import javax.swing.JOptionPane;
import java.io.File;
import java.util.Scanner;

public class tFileSearch 
{

	public static void main(String[] args) 
	{
		String title = "TextSearch";
		int num = 0, ini;
		
		JOptionPane.showMessageDialog(null, "Welcome to " + title, title, 1);
		JOptionPane.showMessageDialog(null, "Copyright WhitePower Inc. 2019, All Rights Reserved", "Copyright Statement", 1);
		
		while(true)
		{
			String file = JOptionPane.showInputDialog(null, "Enter Target File Location", title, 1);
			String data = "";
			
			try
			{
				Scanner fileIn = new Scanner(new File(file));
				while(fileIn.hasNext())
					data += fileIn.next();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Lol you failed", "Program Exception", 0);
				break;
			}
			
			String key =  JOptionPane.showInputDialog(null, "Enter Keyword", title, 1);
			
			data = data.trim();
			
			if(data.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Must actually enter a string!", "Program Exception", 0);
				break;
			}
			
			data = data.toLowerCase();
			
			int pos = 0;
			
			ini = data.indexOf(key);
			
			if(ini == -1)
			{
				num = 0;
			}
			else
			{
				if(data.charAt(ini + 1) == ' ' || ini + 1 > data.length())
				{
					num++;
				}
				
				for(int i = 0; i < data.length(); i++)
				{
					ini = data.indexOf(key);
				}
				
				
				
			}
			
			if(num == 0)
			{
				JOptionPane.showMessageDialog(null, "No results", title, 1);
			}
			
			if(JOptionPane.showConfirmDialog(null, "Do you want to search another file?", title, 1) == 1)
			{
				break;
			}
		}
		
		
	}

}
