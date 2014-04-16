import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

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
		while(!Display.isCloseRequested()){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glColor3f(0.5f,0.5f,1.0f);
			GL11.glBegin(GL11.GL_QUADS);
		    GL11.glVertex2f(100,100);
		    GL11.glVertex2f(100+200,100);
		    GL11.glVertex2f(100+200,100+200);
		    GL11.glVertex2f(100,100+200);
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
