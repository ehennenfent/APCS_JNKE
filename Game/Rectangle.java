public class Rectangle {
	int xCoord = 0;
	int yCoord = 0;
	int height;
	int width;
	
	public Rectangle(){
	}
	
	public int getX(){return xCoord;}
	
	public int getY(){return yCoord;}
	
	public int getWidth(){return width;}
	
	public int getHeight(){return height;}

	public Rectangle(int x, int y){
	xCoord = x;
	yCoord = y;
	}
}
