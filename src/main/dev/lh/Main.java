package dev.lh;

import dev.lh.ui.GameWindow;

public class Main {

	private static GameWindow game;
	public static void main(String[] args) {
		//if wanted, the StartScreen can be added here
		startGame();
	}

	public static void startGame() {
		game = new GameWindow("Snake");
		game.setVisible(true);
	}

	public static GameWindow getGame() {
		return game;
	}

}
