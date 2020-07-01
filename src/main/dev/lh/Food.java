package dev.lh;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Project: <strong>Snake</strong><br>
 * File: <strong>Food.java</strong><br>
 * Created: <strong>01.07.2020</strong><br>
 * 
 * @author Kai S. K. Engelbart
 * @since Snake 1.1
 */
public final class Food implements Updateable {

	private final Color color;
	private final int lengthBonus;
	private final Rectangle bounds;

	public Food(Color color, int lengthBonus, Rectangle bounds) {
		this.color = color;
		this.lengthBonus = lengthBonus;
		this.bounds = bounds;
	}

	public void checkCollision(Snake snake) {
		if (bounds.intersects(snake.getHead())) {}
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fill(bounds);
	}

	public int getLengthBonus() { return lengthBonus; }

	public Rectangle getBounds() { return bounds; }
}
