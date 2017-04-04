/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	
	public void run() {
		drawACenteredFilledCircle(convertInchToPixels(1.0), Color.red);
		drawACenteredFilledCircle(convertInchToPixels(0.65), Color.white);
		drawACenteredFilledCircle(convertInchToPixels(0.3), Color.red);		
	}
	
	private int convertInchToPixels (double inch){
		return (int)(inch * 72);
	}
	
	private void drawACenteredFilledCircle(int circleRadiusPixels, Color color){
		int canvasWidthMiddle = getWidth() / 2;
		int canvasHeightMiddle = getHeight() / 2;
		int x = canvasWidthMiddle - circleRadiusPixels;
		int y = canvasHeightMiddle - circleRadiusPixels;
		GOval circle = new GOval (x, y, circleRadiusPixels * 2, circleRadiusPixels * 2);
		circle.setFilled(true);
		circle.setColor(color);
		add(circle);
	}
}
