import java.awt.*;
import javax.swing.*;

public class GUI {
	private JPanel panel;
	private JLabel welcome;
	
	public GUI() throws Exception{
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,1));
		welcome = new JLabel("Welcome to Snake!");
		panel.add(welcome);
	}
	public static void main(String[] args) throws Exception{
		GUI gg = new GUI();
	}
}
