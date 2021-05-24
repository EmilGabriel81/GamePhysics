package com.home.ui;

import javax.swing.JFrame;

import com.home.constants.Constants;

public class Window{

	/**
	 * 
	 * @ Main Window
	 */
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		MainPanel mainPanel = new MainPanel();
		frame .add(mainPanel);
		//frame.setBounds(0,0,Constants.PANELWIDTH,Constants.PANELHEIGHT);
		frame.pack();
		frame.setTitle("Collision Example");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.addKeyListener(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

	}

}
