package SemesterProject;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class ourGui2{

	public enum Mode {
		AllMode, IndMode,
	}
	private Mode mode = null;	
	
	private ButtonGroup walterWhite;
	
	private JTextPane showName;
	private JTextPane showData;
	private JButton disAddB;
	private JButton disGraB;
	private JButton addB;
	private JButton delB;
	private JRadioButton allB;
	private JRadioButton indB;
	
	private GridBagConstraints cns;
	
	private ArrayList<Student> data;
	
	public static void main(String[] args){
			ourGui2 g = new ourGui2();
			g.run();
	}
	
	public ourGui2(){
		data = new ArrayList<Student>();
		walterWhite = new ButtonGroup();
		cns = new GridBagConstraints();
		
		showName = new JTextPane(); 
		showName.setText("Showing:"); 
		showName.setEditable(false);
		
		showData = new JTextPane();
		showData.setEditable(false);
		
		disAddB = new JButton("Display Address");
		disAddB.setContentAreaFilled(true);
		
		disGraB = new JButton("Display Grades");
		disGraB.setContentAreaFilled(true);
		
		addB = new JButton("Add");
		addB.setContentAreaFilled(true);
		
		delB = new JButton("Delete");
		delB.setContentAreaFilled(true);
		
		allB = new JRadioButton("All");
		allB.setContentAreaFilled(true);
		
		indB = new JRadioButton("Individual");
		indB.setContentAreaFilled(true);
	}
	
	public void addButton(int xCoord, int yCoord, double xWeight, double yWeight, JButton b, Container c){
		cns.gridx = xCoord;
        cns.gridy = yCoord;
        cns.weightx = xWeight;
        cns.weighty = yWeight;
        cns.fill = GridBagConstraints.BOTH;
        c.add(b, cns);
	}
	
	public void addRadioButton(int xCoord, int yCoord, double xWeight, double yWeight, JRadioButton b, Container c){
		cns.gridx = xCoord;
        cns.gridy = yCoord;
        cns.weightx = xWeight;
        cns.weighty = yWeight;
        cns.fill = GridBagConstraints.BOTH;
        c.add(b, cns);
	}
	
	public void addTextPane(int xCoord, int yCoord, double xWeight, double yWeight, JTextPane t, Container c){
		cns.gridx = xCoord;
        cns.gridy = yCoord;
        cns.weightx = xWeight;
        cns.weighty = yWeight;
        cns.fill = GridBagConstraints.BOTH;
        c.add(t, cns);
	}
	
	public void addContainer(int xCoord, int yCoord, double xWeight, double yWeight, Container cFrom, Container c){
		cns.gridx = xCoord;
        cns.gridy = yCoord;
        cns.weightx = xWeight;
        cns.weighty = yWeight;
        cns.fill = GridBagConstraints.BOTH;
        c.add(cFrom, cns);
	}
	
	public void run(){
		JFrame GuiFrame = new JFrame();
		
		Container GuiContainer1 = new Container();
		Container GuiContainer2 = new Container();
		Container GuiContainer3 = new Container();
		Container GuiContainer4 = new Container();
		
		GuiFrame.setLayout(new GridBagLayout());
		GuiFrame.setTitle("Student Database");
		GuiFrame.setSize(600, 600);
		GuiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GuiFrame.setVisible(true);
		GuiFrame.setLocationRelativeTo(null);
		//GuiFrame.setResizable(false);
		
		GuiContainer1.setLayout(new GridBagLayout());
		GuiContainer2.setLayout(new GridBagLayout());
		GuiContainer3.setLayout(new GridBagLayout());
		GuiContainer4.setLayout(new GridBagLayout());
		
		// showName TextPane into Container
		addTextPane(0, 0, 1.0, 0.2, showName, GuiContainer1);
		// showData TextPane into Container 1
		addTextPane(0, 1, 1.0, .8, showData, GuiContainer1);
		Font font = new Font("Courier", Font.BOLD, 30);
		showName.setFont(font);
		StyledDocument doc = showName.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

		// showData TextPane into Container 1
		addTextPane(0, 1, 1.0, .8, showData, GuiContainer1);
		Font font2 = new Font("Courier", Font.PLAIN, 15);
		showData.setFont(font2);
		
		// Container 3 into Container 2
		addContainer(0, 0, 1.0, 0.5, GuiContainer3, GuiContainer2);
		
		// Container 4 into Container 2
		addContainer(1, 0, 1.0, 0.5, GuiContainer4, GuiContainer2);

		// disGraB JButton into Container 3
		addButton(0, 0, 1.0, 0.25, disGraB, GuiContainer3);
		disGraB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(mode == Mode.AllMode){
					showName.setText("Showing: All Grades");
					String text = "F. Name   L. Name   Math      History   Science   English   " + "\n";
					for(Student s: data){
						String fN = s.getFirstName();
						String lN = s.getLastName();
						String ma = s.getGrades().getMath();
						String hi = s.getGrades().getHistory();
						String sc = s.getGrades().getScience();
						String en = s.getGrades().getEnglish();
						String line = lineFormat(fN, lN, ma, hi, sc, en);
						text = text.concat(line + "\n");
					}
					showData.setText(text);
				}
				else if(mode == Mode.IndMode){
					Student student = new Student();
					GridBagConstraints cns = new GridBagConstraints();
					
					Container GuiContainer1 = new Container();
					GuiContainer1.setLayout(new GridBagLayout());
					
					JTextPane TextPane1 = new JTextPane();
					TextPane1.setEditable(false);
					TextPane1.setText("Student Name:                                               ");
					cns.gridx = 0;
			        cns.gridy = 1;
			        cns.weightx = 0.5;
			        cns.weighty = 0.5;
			        cns.fill = GridBagConstraints.BOTH;
					GuiContainer1.add(TextPane1, cns);
					
					JTextField TextField1 = new JTextField(25);
					cns.gridx = 1;
			        cns.gridy = 1;
			        cns.weightx = 0.5;
			        cns.weighty = 0.5;
			        cns.fill = GridBagConstraints.BOTH;
					GuiContainer1.add(TextField1, cns);
					
					int n = JOptionPane.showConfirmDialog(null, GuiContainer1, "Search", JOptionPane.OK_CANCEL_OPTION);
				
					if(n == JOptionPane.OK_OPTION){
						String studentName = TextField1.getText();
						boolean studentFound = false;
						for(Student s: data){
							String name = s.getName();
							if(studentName.equals(name)){
								student = s;
								studentFound = true;
								break;
							}
						}
						if(!studentFound){
							JOptionPane.showMessageDialog(null, studentName + " was not found");
						}
						else if(studentFound){
							showName.setText("Showing: " + studentName);
							String text = "\n";
							text = text.concat("First Name:                             " + student.getFirstName() +"\n");
							text = text.concat("Last Name:                              " + student.getLastName() +"\n");
							text = text.concat("Math:                                   " + student.getGrades().getMath() +"\n");
							text = text.concat("History:                                " + student.getGrades().getHistory() +"\n");
							text = text.concat("Science:                                " + student.getGrades().getScience() +"\n");
							text = text.concat("English:                                " + student.getGrades().getEnglish() +"\n");
							showData.setText(text);
						}
					}
					else if(n == JOptionPane.CANCEL_OPTION){
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Please select \"All\" or \"Individual\" ", "Select Mode", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// disAddB JButton into Container 3
		addButton(1, 0, 1.0, 0.25, disAddB, GuiContainer3);
		disAddB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(mode == Mode.AllMode){
					showName.setText("Showing: All Grades");
					String text = "F. Name   L. Name   Street    City      State     Zip Code  " + "\n";
					for(Student s: data){
						String fN = s.getFirstName();
						String lN = s.getLastName();
						String se = s.getAddress().getStreet();
						String ct = s.getAddress().getCity();
						String sa = s.getAddress().getState();
						String zc = s.getAddress().getZipCode();
						String line = lineFormat(fN, lN, se, ct, sa, zc);
						text = text.concat(line + "\n");
					}
					showData.setText(text);
				}
				else if(mode == Mode.IndMode){
					Student student = new Student();
					GridBagConstraints cns = new GridBagConstraints();
					
					Container GuiContainer1 = new Container();
					GuiContainer1.setLayout(new GridBagLayout());
					
					JTextPane TextPane1 = new JTextPane();
					TextPane1.setEditable(false);
					TextPane1.setText("Student Name:                                               ");
					cns.gridx = 0;
			        cns.gridy = 1;
			        cns.weightx = 0.5;
			        cns.weighty = 0.5;
			        cns.fill = GridBagConstraints.BOTH;
					GuiContainer1.add(TextPane1, cns);
					
					JTextField TextField1 = new JTextField(25);
					cns.gridx = 1;
			        cns.gridy = 1;
			        cns.weightx = 0.5;
			        cns.weighty = 0.5;
			        cns.fill = GridBagConstraints.BOTH;
					GuiContainer1.add(TextField1, cns);
					
					int n = JOptionPane.showConfirmDialog(null, GuiContainer1, "Search", JOptionPane.OK_CANCEL_OPTION);
				
					if(n == JOptionPane.OK_OPTION){
						String studentName = TextField1.getText();
						boolean studentFound = false;
						for(Student s: data){
							String name = s.getName();
							if(studentName.equals(name)){
								student = s;
								studentFound = true;
								break;
							}
						}
						if(!studentFound){
							JOptionPane.showMessageDialog(null, studentName + " was not found");
						}
						else if(studentFound){
							showName.setText("Showing: " + studentName);
							String text = "\n";
							text = text.concat("First Name:                             " + student.getFirstName() +"\n");
							text = text.concat("Last Name:                              " + student.getLastName() +"\n");
							text = text.concat("Street:                                 " + student.getAddress().getStreet() +"\n");
							text = text.concat("City:                                   " + student.getAddress().getCity() +"\n");
							text = text.concat("State:                                  " + student.getAddress().getState() +"\n");
							text = text.concat("Zip Code:                               " + student.getAddress().getZipCode() +"\n");
							showData.setText(text);
						}
					}
					else if(n == JOptionPane.CANCEL_OPTION){
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Please select \"All\" or \"Individual\" ", "Select Mode", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// addB JButton into Container 4
		addButton(1, 0, 1.0, 0.25, addB, GuiContainer4);
		addB.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				GridBagConstraints cns = new GridBagConstraints();
				
				Container GuiContainer3 = new Container();
				GuiContainer3.setLayout(new GridBagLayout());
				
				JTextPane TextPane10 = new JTextPane();
				TextPane10.setEditable(false);
				TextPane10.setText("Student First Name:                                                     ");
				cns.gridx = 0;
		        cns.gridy = 1;
		        cns.weightx = 0.5;
		        cns.weighty = .25;
		        cns.fill = GridBagConstraints.BOTH;
				GuiContainer3.add(TextPane10, cns);
				
				JTextField TextField10 = new JTextField(25);
				cns.gridx = 1;
		        cns.gridy = 1;
		        cns.weightx = 0.5;
		        cns.weighty = .25;
		        cns.fill = GridBagConstraints.BOTH;
				GuiContainer3.add(TextField10, cns);
				
				JTextPane TextPane11 = new JTextPane();
				TextPane11.setEditable(false);
				TextPane11.setText("Student Last Name:                                                     ");
				cns.gridx = 0;
		        cns.gridy = 2;
		        cns.weightx = 0.5;
		        cns.weighty = .25;
		        cns.fill = GridBagConstraints.BOTH;
				GuiContainer3.add(TextPane11, cns);
				
				JTextField TextField11 = new JTextField(25);
				cns.gridx = 1;
		        cns.gridy = 2;
		        cns.weightx = 0.5;
		        cns.weighty = .25;
		        cns.fill = GridBagConstraints.BOTH;
				GuiContainer3.add(TextField11, cns);
				
				int n = JOptionPane.showConfirmDialog(null, GuiContainer3, "What student would you like to add?", JOptionPane.OK_CANCEL_OPTION);
				
				if(n == JOptionPane.OK_OPTION){
					
					String inputFname = TextField10.getText();
					String inputLname = TextField11.getText();
					
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
					
					int m = JOptionPane.showConfirmDialog(null, GuiContainer1, "Address Input", JOptionPane.OK_CANCEL_OPTION);
				
					if(m == JOptionPane.OK_OPTION){
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
						
						JOptionPane.showConfirmDialog(null, GuiContainer2, "Grades Input", JOptionPane.OK_CANCEL_OPTION);
						
						String math = TextField5.getText();
						String history = TextField6.getText();
						String english = TextField7.getText();
						String science = TextField8.getText();
						
						Grades inputGrades = new Grades(math, history, english, science);
						
						Student inputStudent = new Student(inputFname, inputLname, inputGrades, inputAddress);
						
						data.add(inputStudent);
						
						JOptionPane.showMessageDialog(null, "Student Added!", "Add Student", JOptionPane.PLAIN_MESSAGE);
					}
					else if(m == JOptionPane.CANCEL_OPTION){
					}
				}
				else if(n == JOptionPane.CANCEL_OPTION){
				}
			}
		}
		);
		
		// delB JButton into Container 4
		addButton(1, 1, 1.0, 0.25, delB, GuiContainer4);
        delB.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	GridBagConstraints cns = new GridBagConstraints();
				
				Container GuiContainer3 = new Container();
				GuiContainer3.setLayout(new GridBagLayout());
				
				JTextPane TextPane10 = new JTextPane();
				TextPane10.setEditable(false);
				TextPane10.setText("Student First Name:                                                     ");
				cns.gridx = 0;
		        cns.gridy = 1;
		        cns.weightx = 0.5;
		        cns.weighty = .25;
		        cns.fill = GridBagConstraints.BOTH;
				GuiContainer3.add(TextPane10, cns);
				
				JTextField TextField10 = new JTextField(25);
				cns.gridx = 1;
		        cns.gridy = 1;
		        cns.weightx = 0.5;
		        cns.weighty = .25;
		        cns.fill = GridBagConstraints.BOTH;
				GuiContainer3.add(TextField10, cns);
				
				JTextPane TextPane11 = new JTextPane();
				TextPane11.setEditable(false);
				TextPane11.setText("Student Last Name:                                                     ");
				cns.gridx = 0;
		        cns.gridy = 2;
		        cns.weightx = 0.5;
		        cns.weighty = .25;
		        cns.fill = GridBagConstraints.BOTH;
				GuiContainer3.add(TextPane11, cns);
				
				JTextField TextField11 = new JTextField(25);
				cns.gridx = 1;
		        cns.gridy = 2;
		        cns.weightx = 0.5;
		        cns.weighty = .25;
		        cns.fill = GridBagConstraints.BOTH;
				GuiContainer3.add(TextField11, cns);
				
				JOptionPane.showConfirmDialog(null, GuiContainer3, "What student would you like to delete?", JOptionPane.OK_CANCEL_OPTION);
				
				String inputFname = TextField10.getText();
				String inputLname = TextField11.getText();
				String inputName = inputFname + " " + inputLname;
				
				int i = 0;
				for(Student s: data){
					String name = s.getName();
					if(inputName.equals(name)){
						data.remove(i);
						JOptionPane.showMessageDialog(null, "Student Deleted!", "Delete Student", JOptionPane.PLAIN_MESSAGE);
						break;
					}
					else{
						JOptionPane.showMessageDialog(null, "Student Not Found!", "Delete Student Error", JOptionPane.ERROR_MESSAGE);
						}
					i++;
				}
			}
            }
        );

		// allB JRadioButton into Container 4
		addRadioButton(2, 0, 1.0, 0.25, allB, GuiContainer4);
		allB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				mode = Mode.AllMode;
			}
		});
		walterWhite.add(allB);

		// indB JRadioButton into Container 4
		addRadioButton(2, 1, 1.0, 0.25, indB, GuiContainer4);
		indB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				mode = Mode.IndMode;
			}
		});
		walterWhite.add(indB);
		
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
	
	public String lineFormat(String fName, String lName, String e1, String e2, String e3, String e4){
		ArrayList<String> str = new ArrayList<String>();
		String line = "";
		str.add(fName);
		str.add(lName);
		str.add(e1);
		str.add(e2);
		str.add(e3);
		str.add(e4);
		for(int i = 0; i < 6; i++){
			String s = str.get(i);
			if(s.length() >= 10){
				s = s.substring(0, 8);
				s = s.concat("...");
			}
			else if(s.length() < 10){
				int length = s.length();
				for(int j = 0; j < (10 - length); j++){
					s = s.concat(" ");
				}
			}
			str.set(i, s);
			line = line.concat(str.get(i));
		}
		return line;
	}

}