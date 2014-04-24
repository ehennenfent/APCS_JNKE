
public class Dot {
	private int xCoord = 0;
	private int yCoord = 0;
	private Rectangle graphic;
	public Dot(int x, int y){
		xCoord = x;
		yCoord = y;
		graphic = new Rectangle(xCoord,yCoord);
	}
	public Rectangle getRectangle(){
		return graphic;
	}
}
