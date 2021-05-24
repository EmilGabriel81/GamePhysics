package com.home.data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class RecKtangle extends Shape {
	
	/**
	 * This class is extra :)
	 */

	public RecKtangle(int startX, int startY) {
		super(startX, startY);
		
	}

	@Override
	public void move() {
		x += velX;
		y += velY;
	}

	@Override
	public void kill() {
		alive = false;
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(this.getX(), this.getY(), this.getSize(), this.getSize());
	}

	@Override
	public void paintShape(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.fillRect(this.getX(), this.getY(), this.getSize(), this.getSize());
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

}
