package dev.lh;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import dev.lh.ui.Endscreen;
import dev.lh.ui.GameWindow;

/**
 * Project: <strong>Snake</strong><br>
 * File: <strong>Snake.java</strong><br>
 * Created: <strong>11 Mar 2020</strong><br>
 *
 * @author Leon Hofmeister
 * @since Snake 1.0
 */
public class Snake implements Updateable {

	/**
	 * This enum contains all possible directions for the {@link Snake}.<br>
	 * <br>
	 * Project: <strong>Snake</strong><br>
	 * File: <strong>Snake.java</strong><br>
	 * Created: <strong>11 Mar 2020</strong><br>
	 *
	 * @author Leon Hofmeister
	 * @since Snake 1.0
	 */
	public static enum Direction {
		/**
		 * Use if the snake should head left.
		 */
		Left,

		/**
		 * Use if the snake should head right.
		 */
		Right,

		/**
		 * Use if the snake should head up.
		 */
		Up,

		/**
		 * Use if the snake should head down.
		 */
		Down;
	}

	private static FoodFactory	foodFactory	= FoodFactory.getInstance();
	private static Endscreen	endscreen;
	private Direction			Richtung;
	private int					length;
	private List<Point>			tiles		= new ArrayList<>();
	private final int			snakeSize	= 10;

	/**
	 * Constructs a new Snake with the given length in tiles.
	 *
	 * @param length the length of the snake in tiles
	 * @since Snake 1.0
	 */
	public Snake(int length) {
		this.length	= length;
		Richtung	= Direction.Right;
		// adding the initial tiles of the snake
		for (int i = 0; i < length; i++)
			tiles.add(new Point(320 - snakeSize * i, 240));
	}

	/**
	 * Adds the given length to the current snake object
	 *
	 * @param additional the number of tiles to add
	 * @since Snake 1.0
	 */
	public void addLength(int additional) {
		Point last = tiles.get(tiles.size() - 1);
		for (int i = 0; i < additional; i++)
			tiles.add(last);
		length += additional;
	}

	/**
	 * @return whether the snake collides with itself
	 * @since Snake 1.1
	 */
	private boolean checkSelfCollision() {
		Point		headIndex	= tiles.get(0);
		Rectangle	head		= new Rectangle(headIndex.x, headIndex.y, snakeSize, snakeSize);
		for (int index = 1; index < tiles.size(); index++) {
			Point bodyIndex = tiles.get(index);
			if (head.contains(new Rectangle(bodyIndex.x, bodyIndex.y, snakeSize, snakeSize))) return true;
		}
		return false;
	}

	/**
	 *
	 * @since Snake 1.1
	 */
	private void gameOver() {
		endscreen = new Endscreen(length);
		endscreen.setVisible(true);
		Main.getGame().close();
	}

	/**
	 * @return the current {@link Direction} of the snake
	 * @since Snake 1.0
	 */
	public Direction getRichtung() { return Richtung; }

	@Override
	public void nextFrame() {
		int velX = 0, velY = 0;
		switch (Richtung) {
			case Up:
				velY = -snakeSize;
				break;
			case Down:
				velY = snakeSize;
				break;
			case Left:
				velX = -snakeSize;
				break;
			case Right:
				velX = snakeSize;
				break;
		}
		Point next = (Point) tiles.get(0).clone(), cur;
		tiles.get(0).x	+= velX;
		tiles.get(0).y	+= velY;

		for (int i = 1; i < length; i++) {
			cur = tiles.get(i);
			tiles.set(i, (Point) next.clone());
			next = cur;
		}

		// case if snake is outside of the screen or touches itself
		if (checkSelfCollision()) {
			gameOver();
			System.out.println("Snake collided with itself.");
			return;
		}
		// TODO: the game bounds checking below appears to work on Windows, however
		// throws a NullPointerException on Linux/UNIX systems
		if (!Main.getGame().getBounds().contains(tiles.get(0))) {
			gameOver();
			System.out.println("Snake went out of bounds.");
			return;
		}

		// case if snake eats food
		if (foodFactory.checkCollision(new Rectangle(tiles.get(0).x, tiles.get(0).y, snakeSize, snakeSize))) {
			addLength(foodFactory.getAdditionalLength());
			GameWindow game = Main.getGame();
			game.newFood();
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		for (int i = 0; i < length; i++)
			g.fillRect(tiles.get(i).x, tiles.get(i).y, snakeSize, snakeSize);
	}

	/**
	 * @param richtung the new {@link Direction} of the snake
	 * @since Snake 1.0
	 */
	public void setRichtung(Direction richtung) { Richtung = richtung; }
}
