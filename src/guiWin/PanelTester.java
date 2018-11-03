package guiWin;
import javax.swing.*;
import java.awt.*;

public class PanelTester 
{
	static int rows, cols;
	
	public static void main(String[] args) 
	{
		JFrame win = new JFrame();
		win.setTitle("Graphics Tester Window");
		
		String inputStr = JOptionPane.showInputDialog("Number of rows", "5");
		if (inputStr == null) return;
		rows = Integer.parseInt(inputStr);
		
		inputStr = JOptionPane.showInputDialog("Number of columns", "5");
		if (inputStr == null) return;
		cols = Integer.parseInt(inputStr);
		
		win.setBounds(500, 300, rows * 50, cols * 50);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container pane = win.getContentPane();
		pane.setLayout(new GridLayout(rows, cols));
		//Random gen = new Random();
		BiggerPanel master = new BiggerPanel(rows, cols);
		
		for(int i = 0; i <= rows * cols - 1; i++)
		{
			pane.add(master.flow[i]);
		}
		
		win.setVisible(true);

	}

}
