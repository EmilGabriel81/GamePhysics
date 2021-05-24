package com.home.scraps;

import java.awt.Rectangle;
import java.util.Random;

public class rect {
	
	int x ;
	int y;
	
	int velX = 2;
	int velY = 2;
	int directionX = - 2;
	int directionY = - 2;
	
	Random rand = new Random();
	
	
	boolean right;
	
	public rect(int startx , int starty) {
		
		x = startx;
		y = starty;
		
		x = rand.nextInt(700);
		y = rand.nextInt(500);
		
		
		
	}
	
	public void moveUp() {
		 
		x += directionX;
	    y += directionY;
				
		if(x >= 700 || x <= 0) {
			
			directionX =- directionX;
		}
		if(y >= 500 || y <= 0 ) {
			
			directionY =- directionY;
			
		}
		
	}
	public void moveDown() {
		 
		x += velX;
	    y += velY;
				
		if(x >= 700 || x <= 0) {
			
			velX = - velX;
		}
		if(y >= 500 || y <= 0 ) {
			
			velY = - velY;
			
		}
		
	}
	
	public void stop() {
		velX = 0;
		velY = 0;
		directionX = 0;
		directionY = 0;
		
		
	}
	
	public Rectangle getBounds() {
		
		return (new Rectangle(x,y,100,50));
	}
	

}
