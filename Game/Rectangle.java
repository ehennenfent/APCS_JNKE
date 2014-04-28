public class Rectangle {
	int x = 1;
	int y = 1;
	int sLength;
	double coloR = 0.5;
	double coloG = 1.0;
	double coloB = 0.5;
	
	public Rectangle(){
	}
	
	public void changeX(int adjust){x += adjust;}
	
	public void changeY(int adjust){y += adjust;}
	
	public int getX(){return x;}
	public void setX(int newX){x = newX;}
	
	public int getY(){return y;}
	public void setY(int newY){y = newY;}
	
	public int getSLength(){return sLength;}
	
	public void setSLength(int newSide){sLength = newSide;}
	
	public void setColor(double R, double G, double B){
		coloR = R;
		coloG = G;
		coloB = B;
	}
	
	public double getR(){return coloR;}
	public double getG(){return coloG;}
	public double getB(){return coloB;}
	
	public Rectangle(int newX, int newY){
	x = newX;
	y = newY;
	}
}
