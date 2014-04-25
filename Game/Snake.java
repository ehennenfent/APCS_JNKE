import java.util.ArrayList;


class Snake {
	int dir = 1;
	int size = 2;
	ArrayList<Rectangle> blocks;
	int growCount = 0;
	boolean isGrowing = false;

	final int UP = 0;
	final int RIGHT = 1;
	final int DOWN = 2;
	final int LEFT = 3;
	
	int pixelIncrements;
	
	public Snake(){
		//blocks.add(e)
	}
	public void move(){
		blocks.remove(size-1);
		// lastX is the X value of the current first block of the snake
		// before the new first block is added
		int lastX = (blocks.get(0).getX());
		// lastY is the Y equivalent of lastX
		int lastY = (blocks.get(0).getY());
		Rectangle newRect = new Rectangle(lastX, lastY);
		if(dir == UP){
			newRect.changeY(1);
		}
		else if(dir == RIGHT){
			newRect.changeX(1);
		}
		else if(dir == DOWN){
			newRect.changeY(-1);
		}
		else if(dir == LEFT){
			newRect.changeX(-1);
		}
		blocks.add(0, newRect);
	}
	public void turn(int newDirection){
		dir = newDirection;
	}
	public ArrayList<Rectangle> getRectangles(){
		return blocks;
	}
	public void setGrowth(int growAmount){
		growCount = growAmount;
		isGrowing = true;
	}
}
