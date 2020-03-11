package dev.lh;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Project: <strong>Snake</strong><br>
 * File: <strong>Food.java</strong><br>
 * Created: <strong>11 Mar 2020</strong><br>
 *
 * @author Leon Hofmeister
 * @since Snake 1.0
 */
public class Food {

	private Point position;

	/**
	 * Constructs a new food object.
	 *
	 * @param x the x coordinate of the new food
	 * @param y the y coordinate of the new food
	 * @since Snake 1.0
	 */
	public Food(int x, int y) { position = new Point(x, y); }

	/**
	 * Constructs a new food object.
	 *
	 * @param position the position of the food
	 * @since Snake 1.1
	 */
	public Food(Point position) { this.position = position; }

	/**
	 * @param g the {@link Graphics} object used to draw the food
	 * @since Snake 1.0
	 */
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(position.x, position.y, 16, 16);
	}

}
