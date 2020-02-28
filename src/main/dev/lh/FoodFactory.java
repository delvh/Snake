package dev.lh;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class FoodFactory {
	
	public static enum Food{
		white, yellow, orange, red, blue
	}

	private static FoodFactory foodFactory = new FoodFactory();

	private long timeOfNextFood;
	
	
	Point pFood = null;

	
	
	private Food nextFood = Food.white;

	public int rectangleSize = 6;

	private FoodFactory() {}

	public static FoodFactory getInstance() { return foodFactory; }
	
	public Food generateFood() {
		int nextFoodIs = (int) Math.floor(Math.random()*5);
		switch (nextFoodIs) {
		
		case 0:		nextFood =Food.white;	break;
		case 1:     nextFood =Food.yellow;	break;
		case 2:     nextFood =Food.orange;	break;
		case 3:     nextFood =Food.red;		break;
		case 4:     nextFood =Food.blue;	break;
		default: nextFood=generateFood();
		}
		rectangleSize= nextFood.ordinal()+2;
		setTimeToNextFoodMillis();
		return nextFood;
	}
	
	public void setTimeToNextFoodMillis() {
		timeOfNextFood=System.currentTimeMillis()+(int) Math.round(Math.random()  * 15000+1000);;
	}

	public Food getNextFood() {
		return nextFood;
	}

	public void setNext(Food nextFood) {
		this.nextFood = nextFood;
	}

	public long getTimeOfNextFood() {
		return timeOfNextFood;
	}

	public Point generateFoodLocation(int width, int height) {
		pFood=new Point((int) Math.round(Math.random() * width), (int) Math.round(Math.random() * height));
		if(pFood.x<50||pFood.x>width-50||pFood.y<50||pFood.y>height-50) {
			pFood.x = (pFood.x<50)?50:(pFood.x>width-50)?width-50:pFood.x;
			pFood.y = (pFood.y<50)?50:(pFood.y>height-50)?height-50:pFood.y;
		}
		return pFood;		
	}
	
	public int getRectangleSize() {
		return rectangleSize;
	}

	public Point getFoodLocation() {
		return pFood;
	}

	public void colorOfFood(Graphics g) {
		switch(nextFood) {
		case white:	g.setColor(Color.white);	break;
		case yellow:g.setColor(Color.yellow);	break;
		case orange:g.setColor(Color.orange);	break;
		case red:	g.setColor(Color.red);		break;
		case blue:	g.setColor(Color.blue);		break;	
		}//switch
	}

	public void paintFood(Graphics g) {
		colorOfFood(g);
		g.fillRect(pFood.x, pFood.y, 5*rectangleSize, 5*rectangleSize);
	}
	
	public boolean checkCollision(Rectangle snakeHead) {
		int s = rectangleSize*5;
		Rectangle food = new Rectangle(pFood, new Dimension(s, s));
		return food.intersects(snakeHead);
	}

	public int getAdditionalLength() {
		int snakeAdditionalLength = 0;
		switch(nextFood) {
		case white:	snakeAdditionalLength =40;break;
		case yellow:snakeAdditionalLength =15;break;
		case orange:snakeAdditionalLength  =6;break;
		case red:	snakeAdditionalLength  =2;break;
		case blue:	snakeAdditionalLength  =1;break;	
		}//switch
		return snakeAdditionalLength;
	}

}
