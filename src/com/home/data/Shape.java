package com.home.data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public abstract class Shape {

	protected int x;
	protected int y;
	protected float velX = 2;
	protected float velY = 1;
	protected int directionX = -1;
	protected int directionY = -1;
	protected Random r; 
	protected boolean alive = true;
	protected int size = 20;
	protected Color color;
	
	
	public Shape(int startX, int startY) {
		this.x = startX;
		this.y = startY;
		r = new Random();
		int red = r.nextInt(254) + 1;
		int green = r.nextInt(254) + 1;
		int blue = r.nextInt(254) + 1;
		color = new Color(red, green, blue);
	}
	
	public abstract void move();
	public abstract void moveUp();
	public abstract void moveDown();
	public abstract void kill();
	public abstract Rectangle getBounds();
	public abstract void paintShape(Graphics g);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public int getDirectionX() {
		return directionX;
	}

	public void setDirectionX(int directionX) {
		this.directionX = directionX;
	}

	public int getDirectionY() {
		return directionY;
	}

	public void setDirectionY(int directionY) {
		this.directionY = directionY;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}
	
	
	
	
	
	
	
}
