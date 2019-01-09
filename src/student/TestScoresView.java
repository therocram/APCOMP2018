package student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestScoresView 
{
	private TestScoresModel model;
	
	////////
	
	private JButton addButton 		= new JButton("Add");
	private JButton modifyButton 	= new JButton("Modify");
	private JButton firstButton		= new JButton("<<");
	private JButton previousButton	= new JButton("<");
	private JButton nextButton		= new JButton(">");
	private JButton lastButton		= new JButton(">>");
	private JButton highScoreButton	= new JButton("Highest Score");
	private JButton aveScoreButton	= new JButton("Class Average");
	
	private JLabel nameLabel	= new JLabel("Name");
	private JLabel test1Label	= new JLabel("Test 1");
	private JLabel test2Label	= new JLabel("Test 2");
	private JLabel test3Label	= new JLabel("Test 3");
	private JLabel averageLabel	= new JLabel("Average");
	private JLabel countLabel	= new JLabel("Count");
	private JLabel indexLabel	= new JLabel("Index");
	
	private JTextField nameField	= new JTextField("");
	private JTextField test1Field	= new JTextField("0");
	private JTextField test2Field	= new JTextField("0");
	private JTextField test3Field	= new JTextField("0");
	private JTextField averageField	= new JTextField("0");
	private JTextField countField	= new JTextField("0");
	private JTextField indexField	= new JTextField("-1");
	
	////////
	
	public TestScoresView(TestScoresModel m)
	{
		model = m;
		
		averageField.setEditable(false);
		countField.setEditable(false);
		indexField.setEditable(false);
		averageField.setBackground(Color.white);
		countField.setBackground(Color.white);
		indexField.setBackground(Color.white);
		
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel(new GridLayout(5, 4, 10, 5));
		JPanel southPanel = new JPanel();
		Container container = getContentPane();
		container.add(northPanel, BorderLayout.NORTH);
		container.add(centerPanel, BorderLayout.CENTER);
		container.add(southPanel, BorderLayout.SOUTH);
	}
}
