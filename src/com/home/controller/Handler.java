package com.home.controller;

import java.util.ArrayList;
import java.util.List;

import com.home.data.Ball;
import com.home.data.Shape;

public class Handler {

/**
 * 
 * @The Controller of the Game
 */
	
	private List<Ball> ballsArr;

	public Handler(int balls_count) {
		ballsArr = new ArrayList<Ball>();
		createBalls(balls_count);
	}

	public void createBalls(int balls_count) {
		for (int i = 0; i < balls_count; i++) {
			ballsArr.add(new Ball(100 + i * -30, 100));
		}
	}

	public void removeBall(Ball ball) {
		ballsArr.remove(ball);
	}

	public List<Ball> getShapeArr() {
		return ballsArr;
	}

}
