package br.com.softblue.snake.scene;

import br.com.softblue.snake.core.Direction;
import br.com.softblue.snake.graphics.Rect;
import br.com.softblue.snake.graphics.Shape;
import br.com.softblue.snake.util.Constants;
import br.com.softblue.snake.util.GameUtils;



/*
 * 
 * Controla as caracteristicas da cobra
 * 
 * 
 * 
 * */
public class Snake extends Shape {
	private Direction direction;
	private int picesToElongate;
	
	
	public Snake() {
		super(Constants.SNAKE_COLOR);
		direction = Direction.NONE;
		
		Rect rect = new Rect(Constants.SNAKE_INITIAL_X ,Constants.SNAKE_INITIAL_Y ,Constants.SNAKE_PIECE_SIZE ,Constants.SNAKE_PIECE_SIZE);
		super.addRect(rect);
		
		for (int i = 1; i < Constants.SNAKE_SIZE; i++) {
			rect = super.duplicate(rect, Direction.LEFT);
			super.addRect(rect);
		}
	}
	
	public synchronized void move() {
		if(direction != Direction.NONE) {
			Rect head = super.getFirstRect();
			Rect tail = super.getLastRect();
			GameUtils.moveRects(getRects());
			Rect newHead = super.duplicate(head, direction);
			super.getRects().set(0, newHead);
			
			if(this.picesToElongate > 0) {
				super.getRects().add(tail);
				this.picesToElongate--;
			}
		}
		
	}
	
	public synchronized void up() {
		if(direction.canChangeTo(Direction.UP)) {
			direction = Direction.UP;
		}
		
	}
	public synchronized void down() {
		if(direction.canChangeTo(Direction.DOWN)) {
			direction = Direction.DOWN;
		}
	
	}
	public synchronized void left() {
		if(direction.canChangeTo(Direction.LEFT)) {
			direction = Direction.LEFT;
		}
		
	}
	public synchronized void right() {
		if(direction.canChangeTo(Direction.RIGHT)) {
			direction = Direction.RIGHT;
		}
		
	}
	
	public boolean collidesWithItSelf() {
		Rect head = super.getFirstRect();
		
		for(int i = 1; i < super.getRects().size(); i++) {
			Rect rect = super.getRects().get(i);
			if(head.intersects(rect)) {
				return true;
			}
		}
		return false;
	}
	
	public void elengate() {
		this.picesToElongate = Constants.SNAKE_ELONGATE_PIECES;
	}
	
	
}
