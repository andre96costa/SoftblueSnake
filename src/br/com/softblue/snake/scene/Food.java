package br.com.softblue.snake.scene;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import br.com.softblue.snake.graphics.Rect;
import br.com.softblue.snake.util.Constants;
import br.com.softblue.snake.util.GameUtils;


/*
 * 
 * Elemento do jogo comida
 * 
 * Responsavel por controlar onde a comida vai ser desenhada.
 * 
 * 
 * 
 * */
public class Food extends Rect{
	private int eatenTimes;

	public Food(Rectangle drawingArea, Snake snake) {
		this.setRandomLocation(drawingArea, snake);
		super.setDimension(new Dimension(Constants.FOOD_SIZE, Constants.FOOD_SIZE));
		setColor(Color.GREEN);
	}
	
	public void setRandomLocation(Rectangle drawingArea, Snake snake) {
		do {
			int offset = 3;
			int x = GameUtils.random(
						(int)drawingArea.getMinX() + offset, 
						(int)drawingArea.getMaxX() - offset - Constants.FOOD_SIZE
					);
			int y = GameUtils.random(
						(int)drawingArea.getMinY() + offset, 
						(int)drawingArea.getMaxY() - offset - Constants.FOOD_SIZE
					);
			super.setLocation(new Point(x,y));
		}while(snake.intersects(this));
		
	}
	
	public void checkIfEaten(Snake snake, Rectangle drawingArea) {
		if(snake.intersects(this)) {
			this.eatenTimes++;
			setRandomLocation(drawingArea, snake);
			snake.elengate();
		}
	}
	
	public int getEatenTimes() {
		return eatenTimes;
	}
	
}
