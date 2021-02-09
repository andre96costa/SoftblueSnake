package br.com.softblue.snake.scene;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import br.com.softblue.snake.graphics.Drawable;

/*
 * 
 * 
 * Responsavel por dar forma ao texto que será renderizado na tela no game_over
 * 
 * 
 * */
public class Text extends Drawable {
	private String text;
	private Point location;
	
	

	public Text(String text, Point location, Color color) {
		super(color);
		this.text = text;
		this.location = location;
	}



	@Override
	public void draw(Graphics g) {
		g.drawString(this.text, (int) this.location.getX(), (int)this.location.getY());
	}
	
}
