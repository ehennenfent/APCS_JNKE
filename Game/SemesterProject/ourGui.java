package SemesterProject;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ourGui {

	public static void main(String[] args) {
		JFrame theGuiFrame = new JFrame();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		theGuiFrame.setLayout(new GridLayout(4,2));
		theGuiFrame.setTitle("Pellow");
		theGuiFrame.setSize(500, 500);
		theGuiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theGuiFrame.setVisible(true);
		
		JButton theButton = new JButton();
		theButton.setName("Button");
		theButton.setContentAreaFilled(true);
		
		JButton theButton2 = new JButton();
		theButton2.setName("Button2");
		theButton2.setContentAreaFilled(true);
		
		JTextPane theTextPane = new JTextPane();
		theTextPane.setEditable(false);
		theTextPane.setText("Hi Jacob :)");
		theTextPane.setSize(50, 50);
		
		JTextPane theTextPane2 = new JTextPane();
		theTextPane2.setEditable(false);
		theTextPane2.setText("Hi Jacob2 :)");
		theTextPane2.setSize(50, 50);
		
		JTextPane theTextPane3 = new JTextPane();
		theTextPane3.setEditable(false);
		theTextPane3.setText("Hi Jacob3 :)");
		theTextPane3.setSize(50, 50);
				
		JLabel theLabel = new JLabel("Showing:");
		theLabel.setSize(20, 20);
		JTextField theTextField = new JTextField(25);
		theTextField.setSize(20, 20);
		
		JLabel theLabel2 = new JLabel("Jane Doe:");
		theLabel2.setSize(50, 25);
		JTextField theTextField2 = new JTextField(25);
		theTextField2.setSize(50, 50);
		
		theGuiFrame.add(theLabel);
		theGuiFrame.add(theTextPane);
		theGuiFrame.add(theTextPane2);
		theGuiFrame.add(theTextPane3);
		theGuiFrame.add(theLabel2);
		theGuiFrame.add(theTextField2);
		theGuiFrame.add(theButton);
		theGuiFrame.add(theButton2);
		
		
	}
}
