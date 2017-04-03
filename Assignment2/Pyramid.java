/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Height of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		for (int i = BRICKS_IN_BASE; i > 0; i--){
			int x = GetXPositionForARow(i);
			int y = GetYPositionForARow(i);
			DrawALineOfBricks(i, x, y);
		}
	}
	
	private int GetXPositionForARow(int numberOfBricks){
		int canvasCenterWidth = getWidth() / 2;
		return canvasCenterWidth - (numberOfBricks * BRICK_WIDTH / 2);
	}
	
	private int GetYPositionForARow (int currentNumberOfBricks){
		int canvasBottom = getHeight();
		int rowsCompleted = BRICKS_IN_BASE - currentNumberOfBricks;
		return canvasBottom - BRICK_HEIGHT -(rowsCompleted * BRICK_HEIGHT);
	}
	
	private void DrawALineOfBricks (int numberOfBricks, int xPosition, int yPosition){
		for(int i = 1; i <= numberOfBricks; i++){
			AddBrickToCanvas(xPosition, yPosition);
			xPosition += BRICK_WIDTH;
		}
	}
	
	private void AddBrickToCanvas(int xPosition, int yPosition){
		GRect brick = new GRect (xPosition, yPosition, BRICK_WIDTH, BRICK_HEIGHT);
		add(brick);
	}
}
