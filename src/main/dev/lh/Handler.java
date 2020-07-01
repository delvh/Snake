package dev.lh;

import java.awt.Graphics2D;

/**
 * Manages the state of game objects.
 * <p>
 * Project: <strong>Snake</strong><br>
 * File: <strong>Handler.java</strong><br>
 * Created: <strong>01.07.2020</strong><br>
 * 
 * @author Kai S. K. Engelbart
 * @since Snake 1.1
 */
public final class Handler implements Updateable {

	private Snake snake = new Snake(7);
	private FoodFactory foodFactory;

	private volatile Food food;

	public Handler(Snake snake, FoodFactory foodFactory) {
		this.snake = snake;
		this.foodFactory = foodFactory;
		food = foodFactory.spawn();
	}

	@Override
	public void tick() {
		snake.tick();
		food.tick();
		// Check for food collision
		if (snake.getHead().intersects(food.getBounds())) {
			snake.addLength(food.getLengthBonus());
			food = foodFactory.spawn();
		}
		if (System.currentTimeMillis() > foodFactory.getNextSpawnTime())
			food = foodFactory.spawn();
	}

	@Override
	public void render(Graphics2D g) {
		snake.render(g);
		food.render(g);
	}
}
