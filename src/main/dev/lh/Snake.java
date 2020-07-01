package dev.lh;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import dev.lh.ui.Endscreen;

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
	public enum Direction {
		/**
		 * Use if the snake should head left.
		 */
		LEFT,

		/**
		 * Use if the snake should head right.
		 */
		RIGHT,

		/**
		 * Use if the snake should head up.
		 */
		UP,

		/**
		 * Use if the snake should head down.
		 */
		DOWN;
	}

	private static Endscreen		endscreen;
	private Direction				direction	= Direction.RIGHT;
	private int						length;
	private final List<Rectangle>	tiles		= new ArrayList<>();

	private static final int TILE_SIZE = 10;

	/**
	 * Constructs a new Snake with the given length in tiles.
	 *
	 * @param length the length of the snake in tiles
	 * @since Snake 1.0
	 */
	public Snake(int length) {
		this.length = length;

		// Add initial tiles
		for (int i = 0; i < length; i++)
			tiles.add(new Rectangle(320 - TILE_SIZE * i, 240, TILE_SIZE, TILE_SIZE));
	}

	/**
	 * Increases the given length to the current snake object.
	 *
	 * @param additional the number of tiles to add
	 * @since Snake 1.0
	 */
	public void addLength(int additional) {
		final Rectangle last = tiles.get(tiles.size() - 1);
		for (int i = 0; i < additional; i++)
			tiles.add(last);
		length += additional;
	}

	/**
	 * @return whether the snake collides with itself
	 * @since Snake 1.1
	 */
	private boolean checkSelfCollision() {
		return tiles.stream().skip(1).anyMatch(tiles.get(0)::contains);
	}

	/**
	 * @since Snake 1.1
	 */
	private void gameOver() {
		Main.getGame().close();
		endscreen = new Endscreen(length);
		endscreen.setVisible(true);
	}

	@Override
	public void tick() {
		int velX = 0, velY = 0;
		switch (direction) {
			case UP:
				velY = -TILE_SIZE;
				break;
			case DOWN:
				velY = TILE_SIZE;
				break;
			case LEFT:
				velX = -TILE_SIZE;
				break;
			case RIGHT:
				velX = TILE_SIZE;
				break;
		}
		// Add a new tile at the front
		tiles.add(
			0,
			new Rectangle(tiles.get(0).x + velX, tiles.get(0).y + velY, TILE_SIZE, TILE_SIZE)
		);
		// Remove the last tile
		tiles.remove(tiles.size() - 1);
		// Case if snake is outside of the screen or touches itself
		if (checkSelfCollision()) {
			gameOver();
			System.out.println("Snake collided with itself.");
			return;
		}
		// TODO: Test on Linux
		if (!Main.getGame().getBounds().contains(getHead())) {
			gameOver();
			System.out.println("Snake went out of bounds.");
			return;
		}
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.green);
		tiles.forEach(g::fill);
	}

	/**
	 * @return the current {@link Direction} of the snake
	 * @since Snake 1.2
	 */
	public Direction getDirection() { return direction; }

	/**
	 * @param direction the new {@link Direction} of the snake
	 * @since Snake 1.0
	 */
	public void setDirection(Direction direction) { this.direction = direction; }

	/**
	 * @return a rectangle representing the head of the snake
	 * @since Snake 1.2
	 */
	public Rectangle getHead() { return tiles.get(0); }
}
