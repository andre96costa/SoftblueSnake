package br.com.softblue.snake;

import br.com.softblue.snake.core.Game;

/*
 * Classe principal.
 * Instancia o jogo
 * 
 */
public class Application {

	public static void main(String[] args) {
		
		Game game = new Game();
		game.start();
	}

}
