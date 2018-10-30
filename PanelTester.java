package guiWin;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

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
		Random gen = new Random();
		BigPanel arr[] = new BigPanel[rows * cols + 1];
		
		for(int i = 1; i <= rows * cols; i++)
		{
			int red = gen.nextInt(256);
			int green = gen.nextInt(256);
			int blue = gen.nextInt(256);
			Color backColor = new Color(red, green, blue);
			BigPanel panel = new BigPanel(backColor);
			arr[i] = panel;
			pane.add(panel);
		}
		
		win.setVisible(true);
		
	/*	JPanel panel = new JPanel();
		JPanel panel2 = new JPanel() ;
		
		panel.setBackground(Color.blue);
		pane.add(panel);
		pane.add(panel2);
	
		
		System.out.println(panel.getWidth() + "\n" + panel.getHeight());	*/

	}
	/*public static BigPanel pos(int x,int y) {
		return arr[y*rows-rows+1+x];
	} */

}
