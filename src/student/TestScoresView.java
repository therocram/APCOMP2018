package student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestScoresView extends JFrame
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
	private JButton newCellButton = new JButton("New Blank");
	
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
		
		northPanel.add(addButton);
		northPanel.add(modifyButton);
		northPanel.add(highScoreButton);
		northPanel.add(aveScoreButton);
		
		centerPanel.add(nameLabel);
		centerPanel.add(nameField);
		centerPanel.add(countLabel);
		centerPanel.add(countField);
		
		centerPanel.add(test1Label);
		centerPanel.add(test1Field);
		centerPanel.add(indexLabel);
		centerPanel.add(indexField);
		
		centerPanel.add(test2Label);
		centerPanel.add(test2Field);
		centerPanel.add(new JLabel(""));
		centerPanel.add(new JLabel(""));
		
		centerPanel.add(test3Label);
		centerPanel.add(test3Field);
		centerPanel.add(new JLabel(""));
		centerPanel.add(new JLabel(""));
		
		centerPanel.add(averageLabel);
		centerPanel.add(averageField);
		centerPanel.add(new JLabel(""));
		centerPanel.add(new JLabel(""));
		
		southPanel.add(firstButton);
		southPanel.add(previousButton);
		southPanel.add(nextButton);
		southPanel.add(lastButton);
		southPanel.add(newCellButton);
		
		addButton.addActionListener(new AddListener());
		modifyButton.addActionListener(new ModifyListener());
		previousButton.addActionListener(new PreviousListener());
		nextButton.addActionListener(new NextListener());
		firstButton.addActionListener(new FirstListener());
		lastButton.addActionListener(new LastListener());
		highScoreButton.addActionListener(new HighScoreListener());
		aveScoreButton.addActionListener(new AveScoreListener());
		///////////
		setTitle("Student Test Scores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	private void displayInfo()
	{
		Student s = model.currentStudent();
		
		if(s == null)
		{
			nameField.setText("");
			test1Field.setText("0");
			test2Field.setText("0");
			test3Field.setText("0");
			averageField.setText("0");
			countField.setText("0");
			indexField.setText("-1");
		}
		else
		{
			nameField.setText(s.getName());
			test1Field.setText("" + s.getScore(1));
			test2Field.setText("" + s.getScore(2));	
			test3Field.setText("" + s.getScore(3));
			averageField.setText("" + s.getAverage());
			countField.setText("" + model.size());
			indexField.setText("" + model.currentPosition());
		}
	}
	
	private Student getInfoFromScreen()
	{
		Student s = new Student(nameField.getText());
		try 
		{
			s.setScore(1,  Integer.parseInt(test1Field.getText()));
		}
		catch(Exception e)
		{
			s.setScore(1, 0);
		}
		
		try 
		{
			s.setScore(2,  Integer.parseInt(test2Field.getText()));
		}
		catch(Exception e)
		{
			s.setScore(2, 0);
		}
		
		try 
		{
			s.setScore(3,  Integer.parseInt(test3Field.getText()));
		}
		catch(Exception e)
		{
			s.setScore(3, 0);
		}
		
		return s;
	}
	
	private class AddListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Student s = getInfoFromScreen();
			String message = s.validateData();
			if (message != null)
			{
				JOptionPane.showMessageDialog(TestScoresView.this, message, "Program Exception", 0);
				return;
			}
			
			message = model.add(s);
			if (message != null)
				JOptionPane.showMessageDialog(TestScoresView.this, message, "Program Exception", 0);
			else
				displayInfo();
		}
	}
	
	private class ModifyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Student s = getInfoFromScreen();
			model.replace(s);
			displayInfo();
		}
	}
	
	private class PreviousListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			model.previous();
			displayInfo();
		}
	}
	
	private class NextListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			model.next();
			displayInfo();
		}
	}
	
	private class FirstListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			model.first();
			displayInfo();
		}
	}
	
	private class LastListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			model.last();
			displayInfo();
		}
	}
	
	private class HighScoreListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Student st = model.getHighScore();
			if(st != null)
			{
				String s = st.getName() + ": " + st.getHighScore();
				JOptionPane.showMessageDialog(TestScoresView.this, s, "High Score", 1);
				displayInfo();
			}
			else
				JOptionPane.showMessageDialog(TestScoresView.this, "Error: Must add a student first", "Program Exception", 0);
		}
	}
	
	private class AveScoreListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int score = model.getClassAverage();
			JOptionPane.showMessageDialog(TestScoresView.this, "Average Score: " + score, "Class Average", 1);
		}
	}
}
