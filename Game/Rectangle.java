public class Rectangle {
	int x = 1;
	int y = 1;
	int sLength;
	double coloR = 0.0;
	double coloG = 0.0;
	double coloB = 0.0;
	
	public Rectangle(){
	}
	
	public void changeX(int adjust){x += adjust;}
	
	public void changeY(int adjust){y += adjust;}
	
	public int getX(){return x;}
	
	public int getY(){return y;}
	
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
