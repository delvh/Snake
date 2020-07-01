package dev.lh;

import static java.awt.Color.*;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

/**
 * Generates food items with predefined properties at random positions and calculates the next
 * spawning time.
 * <p>
 * Project: <strong>Snake</strong><br>
 * File: <strong>FoodFactory.java</strong><br>
 * Created: <strong>11 Mar 2020</strong><br>
 *
 * @author Leon Hofmeister
 * @author Kai S. K. Engelbart
 * @since Snake 1.0
 */
public final class FoodFactory {

	private int width, height;
	private long nextSpawnTime;
	private Random random = new Random();

	private static final Color[] FOOD_COLORS = {
		WHITE, YELLOW, ORANGE, RED, BLUE
	};
	private static final int[] FOOD_LENGTH_BONUSES = {
		40, 15, 6, 2, 1
	};

	/**
	 * Initializes a food factory.
	 * 
	 * @param width  the width of the viewport
	 * @param height the height of the viewport
	 * @since Snake 1.2
	 */
	public FoodFactory(int width, int height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * @return a new food item
	 * @since Snake 1.2
	 */
	public synchronized Food spawn() {
		nextSpawnTime = System.currentTimeMillis() + random.nextInt(15000) + 1000;
		int seed = random.nextInt(5);
		return new Food(
			FOOD_COLORS[seed],
			FOOD_LENGTH_BONUSES[seed],
			new Rectangle(random.nextInt(width - 100) + 50,
				random.nextInt(height - 100) + 50,
				10 + seed * 5,
				10 + seed * 5
			)
		);
	}

	/**
	 * @return the time after which a new food item should be spawned
	 * @since Snake 1.2
	 */
	public long getNextSpawnTime() { return nextSpawnTime; }
}
