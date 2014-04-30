import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;


import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.openal.AL;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.util.ResourceLoader;


public class World {

	private ArrayList<Snake> snakes = new ArrayList<Snake>();
	private ArrayList<Dot> dots = new ArrayList<Dot>();
	private int points = 0;
	int dispmultiplier = 1;
	int boxL = 10*dispmultiplier;
	int buffer = 2*dispmultiplier;
	int difficulty = 1;
	boolean runonce = true;
	
	private Audio wavEffect;
	private TrueTypeFont sans;
	
	public World(){
		int[] q = newRand();
		Dot d = new Dot(q[0],q[1]);
		dots.add(d);
	}
	
	public void start(){
		//init library
		try {
			Display.setDisplayMode(new DisplayMode(586*dispmultiplier,586*dispmultiplier));
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		try {
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_ONE_MINUS_SRC_ALPHA , GL11.GL_ZERO);
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 598*dispmultiplier, 598*dispmultiplier, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);

		//load fonts
		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("res/csans.ttf");			
			Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
//			Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
			awtFont = awtFont.deriveFont(24f);
			sans = new TrueTypeFont(awtFont, false);
				
		} catch (Exception e) {
			e.printStackTrace();
		}	
		// load sfx
		try {
			wavEffect = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/chime.wav"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
// display countdown
		try {
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA , GL11.GL_ONE_MINUS_SRC_ALPHA);
			countdown();
			GL11.glBlendFunc(GL11.GL_ONE_MINUS_SRC_ALPHA , GL11.GL_ZERO);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		// main loop
		while(!Display.isCloseRequested()){
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	
		//Key input
		while(Keyboard.next()){
			if (Keyboard.getEventKey() == Keyboard.KEY_S || Keyboard.getEventKey() == Keyboard.KEY_DOWN) {
				if (Keyboard.getEventKeyState()) {
				try {
					snakes.get(0).turn(0);
					break;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("No Snake");
				}
				}
				}
			if (Keyboard.getEventKey() == Keyboard.KEY_A || Keyboard.getEventKey() == Keyboard.KEY_LEFT) {
				if (Keyboard.getEventKeyState()) {
				try {
					snakes.get(0).turn(3);
					break;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("No Snake");
				}
				}
				} 
			if (Keyboard.getEventKey() == Keyboard.KEY_T) {
				if (Keyboard.getEventKeyState()) {
				try {
					snakes.get(0).setGrowth(1);
					points += 1;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("No Snake");
				}
				}
				}
			if (Keyboard.getEventKey() == Keyboard.KEY_W || Keyboard.getEventKey() == Keyboard.KEY_UP) {
				if (Keyboard.getEventKeyState()) {
				try {
					snakes.get(0).turn(2);
					break;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("No Snake");
				}
				}
				}
			if (Keyboard.getEventKey() == Keyboard.KEY_D  || Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
				if (Keyboard.getEventKeyState()) {
				try {
					snakes.get(0).turn(1);
					break;
				} catch (IndexOutOfBoundsException e) {
					System.out.println("No Snake");
				}
				}
				}
			}
		for (Snake foo : snakes){
			ArrayList<Rectangle> rectangles = foo.getRectangles();
			//death animation
			if(!foo.checkAlive()){
				for(Rectangle Nicole : foo.getRectangles()){
					Nicole.setColor(1.0, 0.25, 0.25);
					Nicole.changeY(1);
				}
			}
			// point check
			for(int i = 0; i < dots.size(); i++){
				Dot baz = dots.get(i);
				if(rectangles.get(0).getX() == baz.getRectangle().getX() && rectangles.get(0).getY() == baz.getRectangle().getY() && foo.checkAlive()){
					foo.setGrowth(1);
					dots.remove(baz);
					wavEffect.playAsSoundEffect(1.0f, 1.0f, false);
					int[] q = newRand();
					dots.add(new Dot(q[0],q[1]));
					points += 1;
				}
			}
			// draws snake
			for(Rectangle bar : rectangles){
				draw(bar);
			}
			//draws points
			sans.drawString(20, 20, String.valueOf(points), Color.orange);
//			sans.drawString(20, 20, "Mega Test String", Color.orange);
			foo.move();
		}
		// Simulation speed
		try {
			Thread.sleep((int)100/difficulty);
		} catch (InterruptedException e) {
			System.out.println("Error while Sleeping");
			e.printStackTrace();
		}
		// draws dots
		for (Dot bar : dots){
			draw(bar.getRectangle());
		}		
	    Display.update();
	    SoundStore.get().poll(0);
	}
		AL.destroy();
	}
	
	
	
	//draws arbitrary rectangles
	public void draw(Rectangle q){
		int[] coords = getPix(q.getX(),q.getY());
		GL11.glColor4d(q.getR(),q.getG(),q.getB(),2.0);
//		GL11.glColor3d(q.getR(),q.getG(),q.getB());
		GL11.glBegin(GL11.GL_QUADS);
	    	GL11.glVertex2f(coords[0],coords[1]);
	    	GL11.glVertex2f(coords[0]+boxL,coords[1]);
	    	GL11.glVertex2f(coords[0]+boxL,coords[1]+boxL);
	    	GL11.glVertex2f(coords[0],coords[1]+boxL);
	    GL11.glEnd();
		
		
	}
	// displays countdown text
	public void countdown() throws InterruptedException{
		sans.drawString((586*dispmultiplier)/2, (586*dispmultiplier)/2, "5", Color.orange);
		Display.update();
		Thread.sleep(750);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		sans.drawString((586*dispmultiplier)/2, (586*dispmultiplier)/2, "4", Color.orange);
		Display.update();
		Thread.sleep(750);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		sans.drawString((586*dispmultiplier)/2, (586*dispmultiplier)/2, "3", Color.orange);
		Display.update();
		Thread.sleep(750);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		sans.drawString((586*dispmultiplier)/2, (586*dispmultiplier)/2, "2", Color.orange);
		Display.update();
		Thread.sleep(750);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		sans.drawString((586*dispmultiplier)/2, (586*dispmultiplier)/2, "1", Color.orange);
		Display.update();
		Thread.sleep(750);
		
	}
	// add a new snake
	public void add(Snake s){
		snakes.add(s);
	}
	// add a new dot
	public void add(Dot d){
		dots.add(d);
	}
	// returns the score
	public int getScore(){
		return points;
	}
	// calculates pixel location based on 1 - 50 coords 
	private int[] getPix(int xs, int ys){
		int[] out = {0,0};
		out[0] = 1+(boxL + buffer)*(xs - 1);
		out[1] = 1+(boxL + buffer)*(ys - 1);
		return out;
	}
	// gives random coordinates
	private int[] newRand(){
		int[] out = {0,0};
		Random gen = new Random(System.currentTimeMillis());
		out[0] = gen.nextInt(48) + 1;
		out[1] = gen.nextInt(48) + 1;
		return out;
	}
	// changes the speed
	public void changeDifficulty(int level){
		difficulty = level;
	}
}
