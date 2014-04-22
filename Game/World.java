import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


public class World {

	private ArrayList<Snake> snakes = new ArrayList<Snake>();
	private ArrayList<Dot> dots = new ArrayList<Dot>();
	
	
	public World(){
		
	}
	
	public void start(){
		try {
			Display.setDisplayMode(new DisplayMode(600,400));
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	public void draw(Rectangle q){
		
		
		
	}
	
}
