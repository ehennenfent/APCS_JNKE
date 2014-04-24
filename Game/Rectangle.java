public class Rectangle {
	int x = 1;
	int y = 1;
	int sLength;
	
	public Rectangle(){
	}
	
	public void changeX(int adjust){x += adjust;}
	
	public void changeY(int adjust){y += adjust;}
	
	public int getX(){return x;}
	
	public int getY(){return y;}
	
	public int getSLength(){return sLength;}
	
	public void setSLength(int newSide){sLength = newSide;}
	
	public Rectangle(int newX, int newY){
	x = newX;
	y = newY;
	}
}
