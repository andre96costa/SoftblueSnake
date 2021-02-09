package br.com.softblue.snake.core;

import java.awt.Graphics;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import br.com.softblue.snake.graphics.Renderer;
import br.com.softblue.snake.scene.Snake;
import br.com.softblue.snake.util.Constants;


/*
 * 
 *TELA DO JOGO.
 *Responsavel pela area do jogo, teclas utilizadas 
 * 
 * 
 */

@SuppressWarnings("serial")
public class GameWindow extends JFrame implements KeyListener {
	
	private Renderer renderer;
	private Snake snake;
	private Image buffer;
	private Graphics gImage;
	private Rectangle drawingArea;
	private long lastKeyboardEventTime;
	
	public GameWindow(Snake snake) {
		this.renderer = new Renderer();
		this.snake = snake;
	
		setTitle(Constants.GAME_TITLE);
		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addKeyListener(this);
		setVisible(true);
		this.buffer = createImage(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		this.gImage = this.buffer.getGraphics();
		
		this.defineDrawingArea();
	}
	
	public void defineDrawingArea() {
		int upperY = Constants.WINDOW_HEIGHT - (int) (getContentPane().getSize().getHeight());
		this.drawingArea = new Rectangle(0, upperY, Constants.WINDOW_WIDTH, (Constants.WINDOW_HEIGHT - upperY));
	}
	
	@Override
	public void paint(Graphics gScreen) {
		if(this.renderer != null && this.gImage != null && this.buffer != null) {
			this.renderer.render(this.gImage);
			gScreen.drawImage(this.buffer, 0, 0, null);
		}
		
	}
	
	public Renderer getRenderer() {
		return this.renderer;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		long now = System.currentTimeMillis();
		
		if(now - this.lastKeyboardEventTime < Constants.GAME_MIN_TIME_BETWEEN_KEYBORAD_EVENTES) {
			return;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			snake.up();
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			snake.down();
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			snake.left();
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			snake.right();
		}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
		this.lastKeyboardEventTime = now;
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
	}

	

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	public Rectangle getDrawingArea() {
		return drawingArea;
	}
	

}
