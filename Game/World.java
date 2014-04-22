import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;


public class World {

	private ArrayList<Snake> snakes = new ArrayList<Snake>();
	private ArrayList<Dot> dots = new ArrayList<Dot>();
	private int points = 0;
	
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
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
	}
	
	
	
	
	public void draw(Rectangle q){
		
		
		
	}
	
	public void add(Snake s){
		snakes.add(s);
	}
	
	public void add(Dot d){
		dots.add(d);
	}
	
	public int getScore(){
		return points;
	}
	
}
