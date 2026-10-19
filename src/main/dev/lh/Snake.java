package dev.lh;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import dev.lh.ui.GameWindow;

public class Snake implements Updateable {

	public static enum Direction{
		Left, Right, Up, Down;
	}
	private Direction Richtung;
	private int length;
	private List<Point> tiles  = new ArrayList<>();
	private static FoodFactory foodFactory = FoodFactory.getInstance();
	private final int snakeSize = 10;
	
	public Snake(int length) {
		this.length = length;
		Richtung = Direction.Left;
		
		for(int i = 0; i<length;i++) {
			tiles.add(new Point(320-50*i, 240));
		}
		
	}//End Constructor
	@Override
	public void tick() {
		int velX = 0, velY = 0;
		switch(Richtung) {
		
		case Up:
			velY=-snakeSize;
			break;
		case Down:
			velY=snakeSize;
			break;
		case Left:
			velX=-snakeSize;
			break;
		case Right:
			velX=snakeSize;
			break;			
		}//switch
	Point next = (Point) tiles.get(0).clone(), cur;
	tiles.get(0).x+=velX;
	tiles.get(0).y+=velY;
		
	
	for(int i = 1;i<length;i++) {
		cur = tiles.get(i);
		tiles.set(i,(Point) next.clone());
		next = cur;
	}//for
//	if(tiles.get(0).x<=0||tiles.get(0).x>=)
	if(foodFactory.checkCollision(new Rectangle(tiles.get(0).x, tiles.get(0).y, snakeSize, snakeSize))){
		addLength(foodFactory.getAdditionalLength());
		GameWindow game = Main.getGame();
		game.newFood();
	}
	
	}//End tick
	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
	
		for (int i = 0; i<length;i++) {
			g.fillRect(tiles.get(i).x, tiles.get(i).y, snakeSize, snakeSize);
			
		}
		
		
	}//End render

	public Direction getRichtung() {
		return Richtung;
	}

	public void setRichtung(Direction richtung) {
		Richtung = richtung;
	}
	
	public void addLength(int additional) {
		for(int i=0;i<additional;i++) {
			tiles.add(null);
		}
		length+=additional;
	}
}
