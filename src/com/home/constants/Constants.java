package com.home.constants;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;


public class Constants {
	
	private Constants() {
		// TODO Auto-generated constructor stub
		// not be instantiated
	}

	public static final Color ALICEBLUE = new Color(240,248,255);
	public static final Color LAVENDER = new Color(230,230,250);
	public static final Color POWDERBLUE = new Color(176,224,230);
	public static final Color LIGHTBLUE = new Color(173,216,230);
	public static final int PANELWIDTH = 800;
	public static final int PANELHEIGHT = 600;
	
	/**
	 * 
	 *                  Imported
	 *                  
	 */
	
	public static final Font FONTF = new Font("Helvetica", Font.BOLD, 16);
	public static final Font FONTTITLE = new Font("Helvetica", Font.BOLD, 24);
	public static final Font FONTREADME = new Font("Helvetica", Font.BOLD, 16);
	public static final Color mainColor = new Color(153, 255, 204);
	public static  final GradientPaint CUSTOMBACKGROUND = new 
	GradientPaint(0, 0, Color.YELLOW,Constants.PANELWIDTH/2,Constants.PANELHEIGHT/2+200,
			new Color(153, 255, 255));
	
}
