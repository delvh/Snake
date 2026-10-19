package dev.lh.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Food {

	private Point position;
	
	public Food(int x, int y) {
		position = new Point(x,y);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(position.x, position.y, 16, 16);
	}
	
	
}
