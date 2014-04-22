import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;


public class World {

	private ArrayList<Snake> snakes = new ArrayList<Snake>();
	private ArrayList<Dot> dots = new ArrayList<Dot>();
	private int points = 0;
	int dispmultiplier = 1;
	int boxL = 10*dispmultiplier;
	int buffer = 2*dispmultiplier;
	
	public World(){
		
	}
	
	public void start(){
		try {
			Display.setDisplayMode(new DisplayMode(586*dispmultiplier,586*dispmultiplier));
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
		GL11.glOrtho(0, 586*dispmultiplier, 0, 586*dispmultiplier, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		while(!Display.isCloseRequested()){
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		for (Snake foo : snakes){
			ArrayList<Rectangle> rectangles = foo.getRectangles();
			for(Rectangle bar : rectangles){
				draw(bar);
			}
		}
		draw(new Rectangle(39,47));		
	    Display.update();
	}
		
	}
	
	
	
	
	public void draw(Rectangle q){
		int[] coords = getPix(q.getX(),q.getY());
		GL11.glColor3f(0.5f,1.0f,0.5f);
		GL11.glBegin(GL11.GL_QUADS);
	    	GL11.glVertex2f(coords[0],coords[1]);
	    	GL11.glVertex2f(coords[0]+boxL,coords[1]);
	    	GL11.glVertex2f(coords[0]+boxL,coords[1]+boxL);
	    	GL11.glVertex2f(coords[0],coords[1]+boxL);
	    GL11.glEnd();
		
		
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
	
	private int[] getPix(int xs, int ys){
		int[] out = {0,0};
		out[0] = 1+(boxL + buffer)*(xs - 1);
		out[1] = 1+(boxL + buffer)*(ys - 1);
		return out;
	}
	
}
