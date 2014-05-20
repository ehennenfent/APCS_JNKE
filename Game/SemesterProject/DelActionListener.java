package SemesterProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DelActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			GridBagConstraints cns = new GridBagConstraints();
			
			Container GuiContainer1 = new Container();
			GuiContainer1.setLayout(new GridBagLayout());
			
			JTextPane TextPane2 = new JTextPane();
			TextPane2.setEditable(false);
			TextPane2.setText("What student would you like to delete?");
			cns.gridx = 0;
	        cns.gridy = 0;
	        cns.weightx = 1;
	        cns.weighty = 0.5;
	        //cns.anchor = GridBagConstraints.NORTH;
	        cns.fill = GridBagConstraints.BOTH;
			GuiContainer1.add(TextPane2, cns);
			
			JTextField TextField1 = new JTextField(25);
			cns.gridx = 0;
	        cns.gridy = 1;
	        cns.weightx = 1;
	        cns.weighty = 0.5;
	        //cns.anchor = GridBagConstraints.SOUTH;
	        cns.fill = GridBagConstraints.BOTH;
			GuiContainer1.add(TextField1, cns);
			
			JOptionPane.showConfirmDialog(null, GuiContainer1, "Delete Student", JOptionPane.OK_CANCEL_OPTION);
		}
	}	
