import java.util.ArrayList;

public class Snake {
	int dir;
	int size;
	ArrayList<Rectangle> blocks = new ArrayList<Rectangle>();
	int growCount = 0;
	boolean isAlive = true;
	
	final int UP = 0;
	final int RIGHT = 1;
	final int DOWN = 2;
	final int LEFT = 3;
	
	public Snake(int initSize, int initDir, int initX, int initY){
		size = initSize; 		// initial size of snake
		dir = initDir;			// initial direction
		// initX and initY are the x and y coordinates, respectively, of the first block of the snake
		genSnake(initX, initY);
	}
	
	public Snake(){
		size = 3;
		dir = 1;
		genSnake(24, 25);
	}
	
	public void genSnake(int initX, int initY){
		for(int i = 0; i < size; i++){
			Rectangle newRect = new Rectangle(initX, initY);
			if(dir == UP){
				newRect.setY(initY - i);
			}
			else if(dir == DOWN){
				newRect.setY(initY + i);
			}
			else if(dir == RIGHT){
				newRect.setX(initX - i);
			}
			else if(dir == LEFT){
				newRect.setX(initX + i);
			}
			blocks.add(newRect);
		}
	}
	
	public void move(){
		if(isAlive){
			if(growCount == 0){blocks.remove(size-1);}
			else{growCount--;}
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
			isAlive = checkBlock(newRect);
			if(isAlive){blocks.add(0, newRect);}
		}
	}
	public void turn(int newDirection){
		if((dir == UP || dir == DOWN) && (newDirection == DOWN || newDirection == UP)){}
		else if((dir == LEFT || dir == RIGHT) && (newDirection == RIGHT || newDirection == LEFT)){}
		else{dir = newDirection;}
	}
	public ArrayList<Rectangle> getRectangles(){
		return blocks;
	}
	public void setGrowth(int growAmount){
		growCount = growAmount;
		size += growAmount;
	}
	
	public boolean checkBlock(Rectangle check){
		int checkX = check.getX();
		int checkY = check.getY();
		if(checkX > 49 || checkY > 49 || checkX < 1 || checkY < 1){
			return false;
		}
		for(int i = 0; i < blocks.size(); i++){
			Rectangle check2 = blocks.get(i);
			int checkX2 = check2.getX();
			int checkY2 = check2.getY();
			if((checkX == checkX2) && (checkY == checkY2)){
				return false;
			}
		}
		return true;
	}
	
	public boolean checkAlive(){return isAlive;}
}
