package SemesterProject;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class ourGui2 {

	public static void main(String[] args) {
		JFrame GuiFrame = new JFrame();
		
		Container GuiContainer1 = new Container();
		Container GuiContainer2 = new Container();
		
		GridBagConstraints cns = new GridBagConstraints();
		
		GuiFrame.setLayout(new GridBagLayout());
		GuiFrame.setTitle("Pellow");
		GuiFrame.setSize(600, 600);
		GuiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GuiFrame.setVisible(true);
		GuiFrame.setLocationRelativeTo(null);
		//GuiFrame.setResizable(false);
		
		GuiContainer1.setLayout(new GridBagLayout());
		GuiContainer2.setLayout(new GridBagLayout());
		
		JTextPane TextPane = new JTextPane();
		TextPane.setEditable(false);
		TextPane.setText("Hi Jacob :)");
		cns.gridx = 0;
        cns.gridy = 0;
        cns.weightx = 1.0;
        cns.weighty = 0.2;
        //cns.anchor = GridBagConstraints.NORTH;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextPane, cns);
		
		JTextPane TextPane2 = new JTextPane();
		TextPane2.setEditable(false);
		TextPane2.setText("Hi Jacob2 :)");
		cns.gridx = 0;
        cns.gridy = 1;
        cns.weightx = 1.0;
        cns.weighty = 0.6;
        //cns.anchor = GridBagConstraints.CENTER;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextPane2, cns);
		
		JTextField TextField2 = new JTextField(25);
		cns.gridx = 0;
        cns.gridy = 2;
        cns.weightx = 1.0;
        cns.weighty = 0.2;
        //cns.anchor = GridBagConstraints.SOUTH;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextField2, cns);

		JButton Button = new JButton();
		Button.setName("Button");
		Button.setContentAreaFilled(true);
		cns.gridx = 0;
        cns.gridy = 0;
        cns.weightx = 1.0;
        cns.weighty = 0.5;
        //cns.anchor = GridBagConstraints.WEST;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer2.add(Button);
		
		JButton Button2 = new JButton();
		Button2.setName("Button2");
		Button2.setContentAreaFilled(true);
		cns.gridx = 1;
        cns.gridy = 0;
        cns.weightx = 1.0;
        cns.weighty = 0.5;
        //cns.anchor = GridBagConstraints.EAST;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer2.add(Button2);
		
		cns.gridx = 0;
        cns.gridy = 0;
        cns.weightx = 1.0;
        cns.weighty = 0.7;
        cns.anchor = GridBagConstraints.NORTH;
        cns.fill = GridBagConstraints.BOTH;
		GuiFrame.add(GuiContainer1, cns);
		cns.gridx = 0;
        cns.gridy = 1;
        cns.weightx = 1.0;
        cns.weighty = 0.3;
        cns.anchor = GridBagConstraints.SOUTH;
        cns.fill = GridBagConstraints.BOTH;
		GuiFrame.add(GuiContainer2, cns);
		
		
	}
}