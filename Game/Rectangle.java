public class Rectangle {
	int x = 1;
	int y = 1;
	int height;
	int width;
	
	public Rectangle(){
	}
	
	public void changeX(int adjust){x += adjust;}
	
	public void changeY(int adjust){y += adjust;}
	
	public int getX(){return x;}
	
	public int getY(){return y;}
	
	public int getWidth(){return width;}
	
	public int getHeight(){return height;}

	public Rectangle(int newX, int newY){
	x = newX;
	y = newY;
	}
}
