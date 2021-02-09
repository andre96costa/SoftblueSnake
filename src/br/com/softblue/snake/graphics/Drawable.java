package br.com.softblue.snake.graphics;

import java.awt.Color;
import java.awt.Graphics;


/*
 * 
 *Super classe dos elementos que seram desenhados na tela 
 * 
 * 
 */


public abstract class Drawable {
	private Color color;
	
	public Drawable(){
		this.color = Color.BLACK;
	}
	
	public Drawable(Color color){
		this.color = color;
	}
	
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public abstract void draw(Graphics g);
	
		
	
}
