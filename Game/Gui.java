import java.awt.*;
import javax.swing.*;

public class Gui extends JFrame{
	private Container pane;
	private JPanel panel;
	private JLabel welcome;
	public static void main(String[] args) throws Exception{
		Gui gg = new Gui();
		gg.method();
	}
	public Gui() throws Exception{
		method();
	}
	public void method() throws Exception{
		pane = new Container();
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,1));
		welcome = new JLabel("Welcome to Snake!");
		panel.add(welcome);
		pane.add(panel);
		pane.setVisible(true);
	}
}
