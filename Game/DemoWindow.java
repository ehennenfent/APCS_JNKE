import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.Color;

public class DemoWindow {

	public static void main(String[] args) {
		
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
		
		Texture texture = null;
		try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/tariq.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Loaded "+ texture);
		while(!Display.isCloseRequested()){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glColor3f(0.5f,0.5f,1.0f);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			Color.white.bind();
			texture.bind();
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0,1);
		    GL11.glVertex2f(100,100);		    
		    GL11.glTexCoord2f(1,1);
		    GL11.glVertex2f(100+texture.getTextureWidth(),100);		    
		    GL11.glTexCoord2f(1,0);
		    GL11.glVertex2f(100+texture.getTextureWidth(),100+texture.getTextureHeight());		    
		    GL11.glTexCoord2f(0,0);
		    GL11.glVertex2f(100,100+texture.getTextureHeight());
		    
		    GL11.glEnd();
			Display.update();
			while(Keyboard.next()){
			if (Keyboard.getEventKey() == Keyboard.KEY_A) {
				if (Keyboard.getEventKeyState()) {
				System.out.println("A Key Pressed");
				}
				else {
				System.out.println("A Key Released");
				}
				}
			}
		}
		Display.destroy();
	}

}
