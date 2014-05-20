package SemesterProject;

import java.awt.*;

import javax.swing.*;

public class inputGui {

	public static void main (String[] args){	
		JFrame GuiFrame = new JFrame();
		
		GridBagConstraints cns = new GridBagConstraints();
		
		GuiFrame.setLayout(new GridBagLayout());
		GuiFrame.setTitle("Address Input");
		GuiFrame.setSize(500, 200);
		GuiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GuiFrame.setVisible(true);
		GuiFrame.setLocationRelativeTo(null);
		//GuiFrame.setResizable(false);
		
		Container GuiContainer1 = new Container();
		GuiContainer1.setLayout(new GridBagLayout());
		
		JTextPane TextPane = new JTextPane();
		TextPane.setEditable(false);
		TextPane.setText("Address:");
		cns.gridx = 0;
        cns.gridy = 0;
        cns.weightx = 1;
        cns.weighty = .25;
        //cns.anchor = GridBagConstraints.NORTH;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextPane, cns);
		
		
		JTextPane TextPane2 = new JTextPane();
		TextPane2.setEditable(false);
		TextPane2.setText("Street:                                                     ");
		cns.gridx = 0;
        cns.gridy = 1;
        cns.weightx = 0.5;
        cns.weighty = .25;
        //cns.anchor = GridBagConstraints.NORTH;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextPane2, cns);
		
		JTextField TextField1 = new JTextField(25);
		cns.gridx = 1;
        cns.gridy = 1;
        cns.weightx = 0.5;
        cns.weighty = .25;
        //cns.anchor = GridBagConstraints.SOUTH;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextField1, cns);
		
		JTextPane TextPane3 = new JTextPane();
		TextPane3.setEditable(false);
		TextPane3.setText("City:                      ");
		cns.gridx = 0;
        cns.gridy = 2;
        cns.weightx = 0.5;
        cns.weighty = 0.25;
        //cns.anchor = GridBagConstraints.NORTH;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextPane3, cns);
		
		JTextField TextField2 = new JTextField(25);
		cns.gridx = 1;
        cns.gridy = 2;
        cns.weightx = 0.5;
        cns.weighty = 0.25;
        //cns.anchor = GridBagConstraints.SOUTH;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextField2, cns);
		
		JTextPane TextPane4 = new JTextPane();
		TextPane4.setEditable(false);
		TextPane4.setText("State:                     ");
		cns.gridx = 0;
        cns.gridy = 3;
        cns.weightx = 0.5;
        cns.weighty = 0.25;
        //cns.anchor = GridBagConstraints.NORTH;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextPane4, cns);
		
		JTextField TextField3 = new JTextField(25);
		cns.gridx = 1;
        cns.gridy = 3;
        cns.weightx = 0.5;
        cns.weighty = 0.25;
        //cns.anchor = GridBagConstraints.SOUTH;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextField3, cns);
		
		JTextPane TextPane5 = new JTextPane();
		TextPane5.setEditable(false);
		TextPane5.setText("Zipcode:                   ");
		cns.gridx = 0;
        cns.gridy = 4;
        cns.weightx = 0.5;
        cns.weighty = 0.25;
        //cns.anchor = GridBagConstraints.NORTH;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextPane5, cns);
		
		JTextField TextField4 = new JTextField(25);
		cns.gridx = 1;
        cns.gridy = 4;
        cns.weightx = 0.5;
        cns.weighty = 0.25;
        //cns.anchor = GridBagConstraints.SOUTH;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextField4, cns);
		
		JButton OkayButton = new JButton();
		OkayButton.setName("Okay Button");
		OkayButton.setContentAreaFilled(true);
		cns.gridx = 0;
        cns.gridy = 5;
        cns.weightx = 1;
        cns.weighty = .1666;
        //cns.anchor = GridBagConstraints.WEST;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(OkayButton, cns);
		
		JButton CancelButton = new JButton();
		CancelButton.setName("Cancel Button");
		CancelButton.setContentAreaFilled(true);
		cns.gridx = 1;
        cns.gridy = 5;
        cns.weightx = 1;
        cns.weighty = .1666;
        //cns.anchor = GridBagConstraints.WEST;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(CancelButton, cns);
		
		
		
		GuiFrame.add(GuiContainer1);
	}
	
	
}
