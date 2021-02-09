package br.com.softblue.snake.graphics;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Renderer {
	
	private List<Drawable> drawables;
	

	public Renderer() {
		this.drawables = new ArrayList<Drawable>();
	}

	
	public synchronized void add(Drawable drawable) {
		this.drawables.add(drawable);
	}
	
	public synchronized void remove(Drawable drawable) {
		this.drawables.remove(drawable);
	}
	
	public synchronized void render(Graphics g) {
		for (Drawable d : drawables) {
			g.setColor(d.getColor());
			d.draw(g);
		}
	}

}
