package SemesterProject;
import java.awt.Container;
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
		
		delB = new JButton("Del");
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
		GuiFrame.setTitle("Pellow");
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
		
		// Container 3 into Container 2
		addContainer(0, 0, 1.0, 0.5, GuiContainer3, GuiContainer2);
		
		// Container 4 into Container 2
		addContainer(1, 0, 1.0, 0.5, GuiContainer4, GuiContainer2);

		// disGraB JButton into Container 3
		addButton(0, 0, 1.0, 0.25, disGraB, GuiContainer3);

		// disAddB JButton into Container 3
		addButton(1, 0, 1.0, 0.25, disAddB, GuiContainer3);

		// addB JButton into Container 4
		addButton(1, 0, 1.0, 0.25, addB, GuiContainer4);

		// delB JButton into Container 4
		addButton(1, 1, 1.0, 0.25, delB, GuiContainer4);
        delB.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
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
    	        cns.fill = GridBagConstraints.BOTH;
    			GuiContainer1.add(TextPane2, cns);
    			
    			JTextField TextField1 = new JTextField(25);
    			cns.gridx = 0;
    	        cns.gridy = 1;
    	        cns.weightx = 1;
    	        cns.weighty = 0.5;
    	        cns.fill = GridBagConstraints.BOTH;
    			GuiContainer1.add(TextField1, cns);
    			
    			JOptionPane.showConfirmDialog(null, GuiContainer1, "Delete Student", JOptionPane.OK_CANCEL_OPTION);
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
}