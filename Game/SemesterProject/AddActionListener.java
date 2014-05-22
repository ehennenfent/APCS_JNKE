package SemesterProject;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class AddActionListener implements ActionListener {

	public void actionPerformed(ActionEvent e){
		GridBagConstraints cns = new GridBagConstraints();
		
		Container GuiContainer1 = new Container();
		GuiContainer1.setLayout(new GridBagLayout());
		
		JTextPane TextPane1 = new JTextPane();
		TextPane1.setEditable(false);
		TextPane1.setText("Street:                                                     ");
		cns.gridx = 0;
        cns.gridy = 1;
        cns.weightx = 0.5;
        cns.weighty = .25;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextPane1, cns);
		
		JTextField TextField1 = new JTextField(25);
		cns.gridx = 1;
        cns.gridy = 1;
        cns.weightx = 0.5;
        cns.weighty = .25;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextField1, cns);
		
		JTextPane TextPane2 = new JTextPane();
		TextPane2.setEditable(false);
		TextPane2.setText("City:                      ");
		cns.gridx = 0;
        cns.gridy = 2;
        cns.weightx = 0.5;
        cns.weighty = 0.25;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextPane2, cns);
		
		JTextField TextField2 = new JTextField(25);
		cns.gridx = 1;
        cns.gridy = 2;
        cns.weightx = 0.5;
        cns.weighty = 0.25;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextField2, cns);
		
		JTextPane TextPane3 = new JTextPane();
		TextPane3.setEditable(false);
		TextPane3.setText("State:                     ");
		cns.gridx = 0;
        cns.gridy = 3;
        cns.weightx = 0.5;
        cns.weighty = 0.25;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextPane3, cns);
		
		JTextField TextField3 = new JTextField(25);
		cns.gridx = 1;
        cns.gridy = 3;
        cns.weightx = 0.5;
        cns.weighty = 0.25;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextField3, cns);
		
		JTextPane TextPane4 = new JTextPane();
		TextPane4.setEditable(false);
		TextPane4.setText("Zipcode:                   ");
		cns.gridx = 0;
        cns.gridy = 4;
        cns.weightx = 0.5;
        cns.weighty = 0.25;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextPane4, cns);
		
		JTextField TextField4 = new JTextField(25);
		cns.gridx = 1;
        cns.gridy = 4;
        cns.weightx = 0.5;
        cns.weighty = 0.25;
        cns.fill = GridBagConstraints.BOTH;
		GuiContainer1.add(TextField4, cns);
		
		int n = JOptionPane.showConfirmDialog(null, GuiContainer1, "Address Input", JOptionPane.OK_CANCEL_OPTION);
	
		if(n == JOptionPane.OK_OPTION){
			String street = TextField1.getText();
			String city = TextField2.getText();
			String state = TextField3.getText();
			String zipcode = TextField4.getText();
			
			Address2 inputAddress = new Address2(street, city, state, zipcode);
			
			Container GuiContainer2 = new Container();
			GuiContainer2.setLayout(new GridBagLayout());
			
			JTextPane TextPane5 = new JTextPane();
			TextPane5.setEditable(false);
			TextPane5.setText("Math:                                                     ");
			cns.gridx = 0;
	        cns.gridy = 1;
	        cns.weightx = 0.5;
	        cns.weighty = .25;
	        cns.fill = GridBagConstraints.BOTH;
			GuiContainer2.add(TextPane5, cns);
			
			JTextField TextField5 = new JTextField(25);
			cns.gridx = 1;
	        cns.gridy = 1;
	        cns.weightx = 0.5;
	        cns.weighty = .25;
	        cns.fill = GridBagConstraints.BOTH;
			GuiContainer2.add(TextField5, cns);
			
			JTextPane TextPane6 = new JTextPane();
			TextPane6.setEditable(false);
			TextPane6.setText("History:                      ");
			cns.gridx = 0;
	        cns.gridy = 2;
	        cns.weightx = 0.5;
	        cns.weighty = 0.25;
	        cns.fill = GridBagConstraints.BOTH;
			GuiContainer2.add(TextPane6, cns);
			
			JTextField TextField6 = new JTextField(25);
			cns.gridx = 1;
	        cns.gridy = 2;
	        cns.weightx = 0.5;
	        cns.weighty = 0.25;
	        cns.fill = GridBagConstraints.BOTH;
			GuiContainer2.add(TextField6, cns);
			
			JTextPane TextPane7 = new JTextPane();
			TextPane7.setEditable(false);
			TextPane7.setText("Science                     ");
			cns.gridx = 0;
	        cns.gridy = 3;
	        cns.weightx = 0.5;
	        cns.weighty = 0.25;
	        cns.fill = GridBagConstraints.BOTH;
			GuiContainer2.add(TextPane7, cns);
			
			JTextField TextField7 = new JTextField(25);
			cns.gridx = 1;
	        cns.gridy = 3;
	        cns.weightx = 0.5;
	        cns.weighty = 0.25;
	        cns.fill = GridBagConstraints.BOTH;
			GuiContainer2.add(TextField7, cns);
			
			JTextPane TextPane8 = new JTextPane();
			TextPane8.setEditable(false);
			TextPane8.setText("English:                   ");
			cns.gridx = 0;
	        cns.gridy = 4;
	        cns.weightx = 0.5;
	        cns.weighty = 0.25;
	        cns.fill = GridBagConstraints.BOTH;
			GuiContainer2.add(TextPane8, cns);
			
			JTextField TextField8 = new JTextField(25);
			cns.gridx = 1;
	        cns.gridy = 4;
	        cns.weightx = 0.5;
	        cns.weighty = 0.25;
	        cns.fill = GridBagConstraints.BOTH;
			GuiContainer2.add(TextField8, cns);
			
			JTextPane TextPane9 = new JTextPane();
			TextPane9.setEditable(false);
			TextPane9.setText("Wellness:                   ");
			cns.gridx = 0;
	        cns.gridy = 4;
	        cns.weightx = 0.5;
	        cns.weighty = 0.25;
	        cns.fill = GridBagConstraints.BOTH;
			GuiContainer2.add(TextPane9, cns);
			
			JTextField TextField9 = new JTextField(25);
			cns.gridx = 1;
	        cns.gridy = 4;
	        cns.weightx = 0.5;
	        cns.weighty = 0.25;
	        cns.fill = GridBagConstraints.BOTH;
			GuiContainer2.add(TextField9, cns);
			
			JOptionPane.showConfirmDialog(null, GuiContainer2, "Grades Input", JOptionPane.OK_CANCEL_OPTION);
			
			String math = TextField5.getText();
			String history = TextField6.getText();
			String english = TextField7.getText();
			String science = TextField8.getText();
			String wellness = TextField9.getText();
			
			Grades inputGrades = new Grades(math, history, english, science);
			
			Student inputStudent = new Student("", "", inputGrades, inputAddress);
		}
		else if(n== JOptionPane.CANCEL_OPTION){
		}
	}
}