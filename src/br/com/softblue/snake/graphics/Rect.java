package br.com.softblue.snake.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/*
 * 
 * 
 * FORMATO DOS OBJETOS DO JOGO
 * CONTROLA O TAMANHO DO OBJETO E A POSIÇÃO DELE NA TELA
 * 
 * 
 * */

public class Rect extends Drawable {
	private Rectangle rectangle;
	
	public Rect() {
		this.rectangle = new Rectangle(0,0,0,0);
	}
	
	public Rect(int x, int y, int width, int height) {
		rectangle = new Rectangle(x,y,width,height);
	}
	
	public Rect(Point location, Dimension dimesion) {
		rectangle = new Rectangle(location,dimesion);
	}

	public Point getLocation() {
		return rectangle.getLocation();
	}

	public Dimension getDimesion() {
		return rectangle.getSize();
	}
	

	@Override
	public void draw(Graphics g) {
		g.fillRect(
					(int)rectangle.getLocation().getX(),
					(int)rectangle.getLocation().getY(),
					(int)rectangle.getSize().getWidth(),
					(int)rectangle.getSize().getHeight()
				);
	}
	
	public boolean intersects (Rect other) {
		return rectangle.intersects(other.rectangle);
	}
	
	public void setLocation(Point location) {
		this.rectangle.setLocation(location);
	}
		
	public void setDimension(Dimension dimention) {
		this.rectangle.setSize(dimention);
	}	
}
