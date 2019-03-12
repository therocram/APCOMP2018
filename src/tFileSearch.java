import javax.swing.JOptionPane;
import java.io.File;
import java.util.Scanner;

public class tFileSearch 
{

	public static void main(String[] args) 
	{
		String title = "TextSearch";
		
		JOptionPane.showMessageDialog(null, "Welcome to " + title, title, 1);
		JOptionPane.showMessageDialog(null, "Copyright WhitePower Inc. 2019, All Rights Reserved", "Copyright Statement", 1);
		
		String file = JOptionPane.showInputDialog(null, "Enter Target File Location", title, 1);
		String key =  JOptionPane.showInputDialog(null, "Enter Keyword", title, 1);
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
		}
	}

}
