package student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TSVMenu extends JFrame
{
	private TestScoresModel model;
	
	////////
	
	private JMenuItem newMI 		= new JMenuItem("New");
	private JMenuItem openMI 		= new JMenuItem("Open");
	private JMenuItem saveMI 		= new JMenuItem("Save");
	private JMenuItem addMI 		= new JMenuItem("Add");
	private JMenuItem modifyMI 		= new JMenuItem("Modify");
	private JMenuItem deleteMI 		= new JMenuItem("Delete");
	private JMenuItem highScoreMI 	= new JMenuItem("Highest Score");
	private JMenuItem aveScoreMI 	= new JMenuItem("Class Average");
	
	////////
	
	private JButton firstButton		= new JButton("<<");
	private JButton previousButton	= new JButton("<");
	private JButton nextButton		= new JButton(">");
	private JButton lastButton		= new JButton(">>");
	
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
	
	public TSVMenu(TestScoresModel m)
	{
		model = m;
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(newMI);
		fileMenu.add(openMI);
		fileMenu.add(saveMI);
		JMenu editMenu = new JMenu("Edit");
		editMenu.add(addMI);
		editMenu.add(modifyMI);
		editMenu.add(deleteMI);
		JMenu dataMenu = new JMenu("Data");
		dataMenu.add(highScoreMI);
		dataMenu.add(aveScoreMI);
		JMenuBar bar = new JMenuBar();
		bar.add(fileMenu);
		bar.add(editMenu);
		bar.add(dataMenu);
		setJMenuBar(bar);
		
		averageField.setEditable(false);
		countField.setEditable(false);
		indexField.setEditable(false);
		averageField.setBackground(Color.white);
		countField.setBackground(Color.white);
		indexField.setBackground(Color.white);
		
		JPanel centerPanel = new JPanel(new GridLayout(5, 4, 10, 5));
		JPanel southPanel = new JPanel();
		Container container = getContentPane();
		container.add(centerPanel, BorderLayout.CENTER);
		container.add(southPanel, BorderLayout.SOUTH);
		
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
		
		addMI.addActionListener(new AddListener());
		modifyMI.addActionListener(new ModifyListener());
		previousButton.addActionListener(new PreviousListener());
		nextButton.addActionListener(new NextListener());
		firstButton.addActionListener(new FirstListener());
		lastButton.addActionListener(new LastListener());
		highScoreMI.addActionListener(new HighScoreListener());
		aveScoreMI.addActionListener(new AveScoreListener());
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
				JOptionPane.showMessageDialog(TSVMenu.this, message, "Program Exception", 0);
				return;
			}
			
			message = model.add(s);
			if (message != null)
				JOptionPane.showMessageDialog(TSVMenu.this, message, "Program Exception", 0);
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
				JOptionPane.showMessageDialog(TSVMenu.this, s, "High Score", 1);
				displayInfo();
			}
			else
				JOptionPane.showMessageDialog(TSVMenu.this, "Error: Must add a student first", "Program Exception", 0);
		}
	}
	
	private class AveScoreListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int score = model.getClassAverage();
			JOptionPane.showMessageDialog(TSVMenu.this, "Average Score: " + score, "Class Average", 1);
		}
	}
}
