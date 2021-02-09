package br.com.softblue.snake.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import br.com.softblue.snake.core.Direction;


/*
 * Responsavél pelo formato dos elementos desenhado na tela
 * Contrala o crescimento da cobra
 * 
 * e se ouve colição entre retangulos
 * 
 * 
 * 
 * */
public class Shape extends Drawable {
	
	private List<Rect> rects;
	
	
	public Shape(Color color) {
		super(color);
		this.rects = new ArrayList<Rect>();
	}


	public void addRect(Rect rect){
		rects.add(rect);
	}

	@Override
	public void draw(Graphics g) {
		for (Rect r : rects) {
			r.draw(g);
		}
	}
	
	public Rect duplicate(Rect baseRect, Direction direction) {
		int baseX = (int) baseRect.getLocation().getX();
		int baseY = (int) baseRect.getLocation().getY();
		int baseWidth = (int) baseRect.getDimesion().getWidth();
		int baseHeight = (int) baseRect.getDimesion().getHeight();
		
		Point newPoint = new Point(
					baseX + direction.getSgnX() * baseWidth ,
					baseY + direction.getSgnY() * baseHeight
				);
		Rect newRect = new Rect(newPoint, baseRect.getDimesion());
		return newRect;
	}


	public List<Rect> getRects() {
		return rects;
	}


	public Rect getFirstRect() {
		return rects.get(0);
	}
	
	public Rect getLastRect() {
		return rects.get(rects.size() -1);
	}
	
	public boolean intersects(Rect rect) {
		for(Rect r: rects) {
			if(r.intersects(rect)) {
				return true;
			}
		}
		return false;
	}
	
	

}
