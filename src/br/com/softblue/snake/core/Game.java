package br.com.softblue.snake.core;

import java.awt.Rectangle;

import br.com.softblue.snake.graphics.Rect;
import br.com.softblue.snake.graphics.Renderer;
import br.com.softblue.snake.scene.Background;
import br.com.softblue.snake.scene.Food;
import br.com.softblue.snake.scene.GameOverText;
import br.com.softblue.snake.scene.Snake;
import br.com.softblue.snake.util.Constants;
import br.com.softblue.snake.util.GameUtils;

/*
 * Classe do jogo
 * Mostra os elementos na tela
 * 
 */

public class Game implements Runnable {
	
	private GameWindow gameWindow;
	private Snake snake;
	private Food food;	
	private Renderer renderer;
	
	public void start() {
		this.snake = new Snake();
		this.gameWindow = new GameWindow(snake);
		this.food = new Food(this.gameWindow.getDrawingArea(), this.snake);
		this.renderer = this.gameWindow.getRenderer();
		this.addElementsToScreen(renderer);
		new Thread(this).start();//Esse metodo faz com que o metodo run seja executado em outra thread
		 
	}

	private void addElementsToScreen(Renderer renderer) {
		renderer.add(new Background());
		renderer.add(this.snake);
		renderer.add(this.food);
	}
	
	@Override
	public void run() {
		while(!this.isGameOver()) {
			this.snake.move();
			this.food.checkIfEaten(this.snake, this.gameWindow.getDrawingArea());
			this.gameWindow.repaint();
			GameUtils.sleep(Constants.SLEEP_TIME);
		}
		
		this.processGameOver();
	}
	
	public void processGameOver() {
		this.renderer.remove(snake);
		this.renderer.remove(food);
		this.renderer.add(new GameOverText(food.getEatenTimes()));
		this.gameWindow.repaint();
	}
	
	private boolean isGameOver() {
		return this.snake.collidesWithItSelf() || this.isSnakeHitBounds();
	}
	
	public boolean isSnakeHitBounds() {
		Rect head = this.snake.getFirstRect();
		Rectangle drawingArea = this.gameWindow.getDrawingArea();
		
		int headX = (int) head.getLocation().getX();
		int headY = (int) head.getLocation().getY();
		
		int areaX1 = (int) drawingArea.getMinX();
		int areaY1 = (int) drawingArea.getMinY() - Constants.SNAKE_PIECE_SIZE * 2;
		
		int areaX2 = (int) drawingArea.getMaxX();
		int areaY2 = (int) drawingArea.getMaxY();
		
		if(headX <= areaX1 || headX + Constants.SNAKE_PIECE_SIZE >= areaX2) {
			return true;
		}
		
		if(headY <= areaY1 || headY + Constants.SNAKE_PIECE_SIZE >= areaY2) {
			return true;
		}
		
		return false;
		
	}

}
