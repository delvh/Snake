package dev.lh;

import static java.awt.Color.*;

import java.awt.*;
import java.util.Random;

import dev.lh.ui.GameWindow;

/**
 * Project: <strong>Snake</strong><br>
 * File: <strong>FoodFactory.java</strong><br>
 * Created: <strong>11 Mar 2020</strong><br>
 *
 * @author Leon Hofmeister
 * @since Snake 1.0
 */
public class FoodFactory {

	/**
	 * This enum contains all possible variations of foods. The higher the ordinal
	 * of an element, the less it is worth.<br>
	 * <br>
	 * Project: <strong>Snake</strong><br>
	 * File: <strong>FoodFactory.java</strong><br>
	 * Created: <strong>11 Mar 2020</strong><br>
	 *
	 * @author Leon Hofmeister
	 * @since Snake 1.0
	 */
	public static enum Food {

		/**
		 * Use if white food is wanted.
		 */
		white(
			WHITE, 40
		),

		/**
		 * Use if yellow food is wanted.
		 */
		yellow(
			YELLOW, 15
		),

		/**
		 * Use if orange food is wanted.
		 */
		orange(
			ORANGE, 6
		),

		/**
		 * Use if red food is wanted.
		 */
		red(
			RED, 2
		),

		/**
		 * Use if blue food is wanted.
		 */
		blue(
			BLUE, 1
		);

		/**
		 * The color of the food item.
		 */
		public final Color color;

		/**
		 * The length bonus of the food item.
		 */
		public final int lengthBonus;

		private Food(Color color, int lengthBonus) {
			this.color = color;
			this.lengthBonus = lengthBonus;
		}
	}

	private static FoodFactory foodFactory = new FoodFactory();

	private long timeOfNextFood;

	private Point pFood;

	private Food nextFood = Food.white;

	private int rectangleSize = 6;

	private FoodFactory() {}

	/**
	 * @return the (singleton) instance of FoodFactory
	 * @since Snake 1.0
	 */
	public static FoodFactory getInstance() { return foodFactory; }

	/**
	 * @return a new {@link Food} object without its position
	 * @since Snake 1.0
	 */
	public Food generateFood() {
		nextFood = Food.values()[new Random().nextInt(Food.values().length)];
		rectangleSize = nextFood.ordinal() + 2;
		setTimeToNextFoodMillis();
		return nextFood;
	}

	/**
	 * Generates the amount of time that needs to pass before the next food object
	 * will be constructed.
	 *
	 * @since Snake 1.0
	 */
	public void setTimeToNextFoodMillis() {
		timeOfNextFood = System.currentTimeMillis() + new Random().nextInt(15000) + 1000;
	}

	/**
	 * @return the type of the next food
	 * @since Snake 1.0
	 */
	public Food getNextFood() { return nextFood; }

	/**
	 * @param nextFood the type the next food should have
	 * @since Snake 1.0
	 */
	public void setNext(Food nextFood) { this.nextFood = nextFood; }

	/**
	 * @return the time at which a new food object will be automatically created
	 * @since Snake 1.0
	 */
	public long getTimeOfNextFood() { return timeOfNextFood; }

	/**
	 * @param width  the width of the currently used {@link GameWindow}
	 * @param height the height of the currently used {@link GameWindow}
	 * @return the position of the new {@link Food} object
	 * @since Snake 1.0
	 */
	public Point generateFoodLocation(int width, int height) {
		assert (width > 100 && height > 100);
		Random r = new Random();
		return pFood = new Point(r.nextInt(width - 100) + 50, r.nextInt(height - 100) + 50);
	}

	/**
	 * @return the size of the corresponding food (length = width)
	 * @since Snake 1.0
	 */
	public int getRectangleSize() { return rectangleSize; }

	/**
	 * @return the location of the currently displayed food
	 * @since Snake 1.0
	 */
	public Point getFoodLocation() { return pFood; }

	/**
	 * Sets the color of the given {@link Graphics} object according to the type of
	 * food.
	 *
	 * @param g the graphics object to paint
	 * @since Snake 1.0
	 */
	public void colorOfFood(Graphics g) {
		g.setColor(nextFood.color);
	}

	/**
	 * @param g the {@link Graphics} object used to paint the current food object
	 * @since Snake 1.0
	 */
	public void paintFood(Graphics g) {
		colorOfFood(g);
		g.fillRect(pFood.x, pFood.y, 5 * rectangleSize, 5 * rectangleSize);
	}

	/**
	 * @param snakeHead the the head of a {@link Snake} object
	 * @return true if the current food intersects with the snake head
	 * @since Snake 1.0
	 */
	public boolean checkCollision(Rectangle snakeHead) {
		int s = rectangleSize * 5;
		Rectangle food = new Rectangle(pFood, new Dimension(s, s));
		return food.intersects(snakeHead);
	}

	/**
	 * @return the length that will be added to the snake
	 * @since Snake 1.0
	 */
	public int getAdditionalLength() {
		return nextFood.lengthBonus;
	}
}
