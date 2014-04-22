import java.util.ArrayList;


class Snake {
	int direction = 1;
	int size = 2;
	ArrayList<Rectangle> blocks;
	
	int pixelIncrements;
	
	public Snake(){
		//blocks.add(e)
	}
	public void move(){
		
	}
	public void turn(int newDirection){
		direction = newDirection;
	}
	public ArrayList<Rectangle> getRectangles(){
		return blocks;
	}
	public void changeLength(int increment){
		size += increment;
	}
}
