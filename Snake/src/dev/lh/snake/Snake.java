package dev.lh.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Snake implements Updateable {

	static enum Direction{
		Left, Right, Up, Down;
	}
	private Direction Richtung;
	private int length;
	private Point[] tiles;
	
	public Snake(int length) {
		this.length = length;
		tiles =new Point[length];
		Richtung = Direction.Left;
		
		for(int i = 0; i<length;i++) {
			tiles[i] = new Point(320-50*i, 240);
		}
		
	}//End Constructor
	@Override
	public void tick() {
		int velX = 0, velY = 0;
		switch(Richtung) {
		
		case Up:
			velY=-50;
			break;
		case Down:
			velY=50;
			break;
		case Left:
			velX=-50;
			break;
		case Right:
			velX=50;
			break;			
		}//switch
	Point next = (Point) tiles[0].clone(), cur;
	tiles[0].x+=velX;
	tiles[0].y+=velY;
		
	
	for(int i = 1;i<length;i++) {
		cur = tiles[i];
		tiles[i]=(Point) next.clone();
		next = cur;
		
	}//for
	
	}//End tick
	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
	
		for (int i = 0; i<length;i++) {
			g.drawRect(tiles[i].x, tiles[i].y, 50, 50);
			
		}
		
		
	}//End render

	public Direction getRichtung() {
		return Richtung;
	}

	public void setRichtung(Direction richtung) {
		Richtung = richtung;
	}
}
