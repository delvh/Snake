package dev.lh;

import dev.lh.ui.GameWindow;

/**
 * Project: <strong>Snake</strong><br>
 * File: <strong>Main.java</strong><br>
 * Created: <strong>11 Mar 2020</strong><br>
 *
 * @author Leon Hofmeister
 * @since Snake 1.0
 */
public class Main {

	private static GameWindow game;

	/**
	 * @param args the program arguments
	 * @since Snake 1.0
	 */
	public static void main(String[] args) {
		// if wanted, the StartScreen can be added here
		startGame();
	}

	/**
	 * Starts a new game of Snake.
	 *
	 * @since Snake 1.0
	 */
	public static void startGame() {
		game = new GameWindow("Snake");
		game.setVisible(true);
	}

	/**
	 * @return the currently used game
	 * @since Snake 1.0
	 */
	public static GameWindow getGame() { return game; }
}
