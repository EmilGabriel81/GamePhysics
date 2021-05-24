package com.home.data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.home.constants.Constants;

public class Ball extends Shape {

	private float gravity = 0.1f;
	private float maxSpeed = 5;
	private boolean dropped = false;
	private int count = 0;

	public Ball(int startX, int startY) {
		super(startX, startY);
	}

	@Override
	public void move() {
		x += velX;
		if (this.getX() >= 400) {
			dropped = true;
		} 
		  if (this.getX() + this.getSize() >= Constants.PANELWIDTH && dropped ||
		  this.getX() <= 0 && dropped) { velX *= -1; }
	}

	@Override
	public void moveDown() {
		if (dropped) {
			// y will always be equal with y + the sum of VelY and gravity
			y += velY; // initially y = 100
			velY += gravity;// initially velY = 1
			// so it will be 100 + 1+ 0.5 first
			// then 101.5 + 1.5 + 0.5
			// then 103.5 ...
			if (velY > maxSpeed) {
				velY = maxSpeed;
				// Once it reached the maximum speed it will remain the same
			}
			// System.out.println(velY += gravity);
			if (this.getY() + this.getSize() >= Constants.PANELHEIGHT || this.getY() < 0) {
				velY *= -1;
				count++;
				if (count > 3) {
					 this.kill();
				}
			}
		}

	}

	public boolean isDropped() {
		return dropped;
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
		g2d.setColor(this.getColor());
		g2d.fillOval(this.getX(), this.getY(), this.getSize(), this.getSize());

	}

	@Override
	public void moveUp() {
		System.out.println("moveUp() not active yet");

	}

}
