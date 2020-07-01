package dev.lh;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Represents a food item.
 * <p>
 * Project: <strong>Snake</strong><br>
 * File: <strong>Food.java</strong><br>
 * Created: <strong>01.07.2020</strong><br>
 * 
 * @author Kai S. K. Engelbart
 * @since Snake 1.2
 */
public final class Food implements Updateable {

	private final Color color;
	private final int lengthBonus;
	private final Rectangle bounds;

	/**
	 * Constructs a food item.
	 * 
	 * @param color       the color of the food item
	 * @param lengthBonus the length added to the snake when the food item is eaten
	 * @param bounds      the bounds of the food item
	 * @since Snake 1.2
	 */
	public Food(Color color, int lengthBonus, Rectangle bounds) {
		this.color = color;
		this.lengthBonus = lengthBonus;
		this.bounds = bounds;
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fill(bounds);
	}

	/**
	 * @return the length added to the snake when the food item is eaten
	 * @since Snake 1.2
	 */
	public int getLengthBonus() { return lengthBonus; }

	/**
	 * @return the bounds of the food item
	 * @since Snake 1.2
	 */
	public Rectangle getBounds() { return bounds; }
}
