import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

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
		while(!Display.isCloseRequested()){
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