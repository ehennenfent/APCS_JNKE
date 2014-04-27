import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
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
		GL11.glOrtho(0, 598*dispmultiplier, 0, 598*dispmultiplier, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		while(!Display.isCloseRequested()){
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		while(Keyboard.next()){
			if (Keyboard.getEventKey() == Keyboard.KEY_W) {
				if (Keyboard.getEventKeyState()) {
				try {
					snakes.get(0).turn(0);
				} catch (IndexOutOfBoundsException e) {
					System.out.println("No Snake");
				}
				}
				else {
				System.out.println("W Key Released");
				}
				}
			if (Keyboard.getEventKey() == Keyboard.KEY_A) {
				if (Keyboard.getEventKeyState()) {
				try {
					snakes.get(0).turn(3);
				} catch (IndexOutOfBoundsException e) {
					System.out.println("No Snake");
				}
				}
				else {
				System.out.println("A Key Released");
				}
				}
			if (Keyboard.getEventKey() == Keyboard.KEY_T) {
				if (Keyboard.getEventKeyState()) {
				try {
					snakes.get(0).setGrowth(1);
				} catch (IndexOutOfBoundsException e) {
					System.out.println("No Snake");
				}
				}
				else {
				System.out.println("T Key Released");
				}
				}
			if (Keyboard.getEventKey() == Keyboard.KEY_S) {
				if (Keyboard.getEventKeyState()) {
				try {
					snakes.get(0).turn(2);
				} catch (IndexOutOfBoundsException e) {
					System.out.println("No Snake");
				}
				}
				else {
				System.out.println("S Key Released");
				}
				}
			if (Keyboard.getEventKey() == Keyboard.KEY_D) {
				if (Keyboard.getEventKeyState()) {
				try {
					snakes.get(0).turn(1);
				} catch (IndexOutOfBoundsException e) {
					System.out.println("No Snake");
				}
				}
				else {
				System.out.println("D Key Released");
				}
				}
			}
		for (Snake foo : snakes){
			ArrayList<Rectangle> rectangles = foo.getRectangles();
			for(int i = 0; i < dots.size(); i++){
				Dot baz = dots.get(i);
				if(rectangles.get(0).getX() == baz.getRectangle().getX() && rectangles.get(0).getY() == baz.getRectangle().getY()){
					foo.setGrowth(1);
					dots.remove(baz);
					int[] q = newRand();
					dots.add(new Dot(q[0],q[1]));
					points += 1;
				}
			}
			for(Rectangle bar : rectangles){
				draw(bar);
			}
			foo.move();
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("Error while Sleeping");
			e.printStackTrace();
		}
		for (Dot bar : dots){
			draw(bar.getRectangle());
		}		
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
	
	private int[] newRand(){
		int[] out = {0,0};
		Random gen = new Random(System.currentTimeMillis());
		out[0] = gen.nextInt(48) + 1;
		out[1] = gen.nextInt(48) + 1;
		return out;
	}
	
}
