import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MagpieView extends JFrame
{
	private Magpie2 maggie = new Magpie2();
	
	private JLabel entryLabel	= new JLabel("You");
	private JLabel responseLabel	= new JLabel("Magpie");
	
	private JTextField entryField	= new JTextField("");
	private JTextField responseField	= new JTextField("");	
	
	private JButton askButton = new JButton("Ask");
	
	public MagpieView(Magpie2 m)
	{
		maggie = m;
		
		responseField.setEditable(false);
		responseField.setBackground(Color.white);
		
		JPanel northPanel = new JPanel(new GridLayout(5, 4, 10, 0));
		JPanel southPanel = new JPanel();
		
		Container container = getContentPane();
		
		container.add(northPanel, BorderLayout.NORTH);
		container.add(southPanel, BorderLayout.SOUTH);
		
		northPanel.add(entryLabel);
		northPanel.add(entryField);
		
		northPanel.add(responseLabel);
		northPanel.add(responseField);
		
		southPanel.add(askButton);
		
		responseField.setText(maggie.getGreeting());
		
		askButton.addActionListener(new AskListener());
		
		setTitle("Magpie Chat Bot");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,500,500,500);
		setMinimumSize(new Dimension(278, 173));
		pack();
		setVisible(true);
	}
	
	public class AskListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			 responseField.setText(maggie.getResponse(entryField.getText()));
			 entryField.setText("");
		}
	}
}