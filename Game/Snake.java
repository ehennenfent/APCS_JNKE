import java.util.ArrayList;


class Snake {
	int dir = 1;
	int size = 2;
	ArrayList<Rectangle> blocks;
	
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
		if(dir == 0){
			newRect.changeY(1);
		}
		else if(dir == 1){
			newRect.changeX(1);
		}
		else if(dir == 2){
			newRect.changeY(-1);
		}
		else if(dir == 3){
			newRect.changeX(-1);
		}
		blocks.add(newRect);
	}
	public void turn(int newDirection){
		dir = newDirection;
	}
	public ArrayList<Rectangle> getRectangles(){
		return blocks;
	}
	public void changeLength(int increment){
		size += increment;
	}
}
