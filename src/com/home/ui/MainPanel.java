package com.home.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
//import java.util.Timer;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.text.StyledEditorKit.BoldAction;

import com.home.constants.Constants;
import com.home.controller.Handler;
import com.home.data.Ball;
import com.home.data.Shape;

public class MainPanel extends JPanel implements ActionListener, KeyListener {

	private Timer timer;
	private int index = 0;
	private boolean inGame = true;
	private Handler handler;
	//ArrayList with Balls
	private List<Ball> ballsList;
	private int balls_count = 3;
	private int balls_killed = 0;
	//In case you desire to stop the engine at a maximum number of balls generated
	private int maxNumberOfBalls;
	private String message;
	

	public MainPanel() {
		initVars();
	}

	private void initVars() {
		
		//maxNumberOfBalls = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the max number of balls ",JOptionPane.INFORMATION_MESSAGE));
		timer = new Timer(5, this);
		handler = new Handler(balls_count);
		ballsList = handler.getShapeArr();
		System.out.println("In the handler class number of balls in the list "+ handler.getShapeArr().size());
		message = "Press Space to Pause";
		this.setPreferredSize(new Dimension(Constants.PANELWIDTH, Constants.PANELHEIGHT));
		start();
	}

	private void start() {
		timer.start();
	}

	private void stop() {
		inGame = false;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(Constants.CUSTOMBACKGROUND);
		g2d.fillRect(0, 0, Constants.PANELWIDTH, Constants.PANELHEIGHT);
		g2d.setColor(Color.RED);
		g2d.setFont(Constants.FONTF);
		g2d.drawString(message, 20, 20);
		g2d.fillRect(0, 120, 420, 10);
		g2d.setColor(Color.BLUE);
		g2d.fillOval(0, 70, 20, 50);
		// draw the balls
		paintBalls(g2d);
	}

	private void paintBalls(Graphics2D g2d) {
		Ball ball = null;
		for (int i = 0; i < this.ballsList.size(); i++) {
			ball = ballsList.get(i);
			if (ball.isAlive()) {
				ball.paintShape(g2d);
			}
		}
	}

	private void animateBalls() {
		Iterator iterator = ballsList.iterator();
		while(iterator.hasNext()) {
			Ball ball = (Ball) iterator.next();
			ball.move();
			ball.moveDown();
			checkCollision(ball);
			if(!ball.isAlive()) {
				iterator.remove();
				balls_killed++;
			}
		}
	}
	
	private void checkBallStats(){
		if(balls_killed >= balls_count) {
			balls_count += 2;
			balls_killed = 0;
		}
		if(ballsList.isEmpty()) {
			handler.createBalls(balls_count);
		}
		// We stop the game at the desired value
//		if(balls_count >= 9) {
//			inGame = false;
//		}
	}


	public int getBalls_count() {
		return balls_count;
	}

	public void setBalls_count(int balls_count) {
		this.balls_count = balls_count;
	}

	public int getBalls_killed() {
		return balls_killed;
	}

	public void checkCollision(Ball b) {
		// if you want a collision with a certain point of the map, uncomment 
//		if(b.getBounds().intersects(new Rectangle(250, Constants.PANELHEIGHT-15, 50, 20))) {
//			b.kill();
//		}
		for(Ball bb : ballsList) {
			if(b.getBounds().intersects(bb.getBounds())) {
				b.setVelX(b.getVelX()*-1);
				bb.setVelX(bb.getVelX()*-1);
				//if you want to change the Y axis as well
//				b.setVelY(b.getVelY()*-1);
//				bb.setVelY(bb.getVelY()*-1);	
			}
		}
	}
	
	private void update() {
		animateBalls();
		checkBallStats();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (inGame) {
			update();
			repaint();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("key pressed "+e.getKeyCode());
		if(e.getKeyCode() ==  KeyEvent.VK_SPACE) {
			if(inGame) {
				stop();
			}else {
				inGame = true;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
