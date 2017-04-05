/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	private static final int BOX_WIDTH = 150;
	private static final int BOX_HEIGHT = 50;
	private int xSpaceBetweenBoxes = BOX_HEIGHT / 2;
	private int ySpaceBetweenBoxes = BOX_HEIGHT;
	private String[] boxLabel = {"Program", "GraphicsProgram", "ConsoleProgram", "DialogProgram"};
	
	public void run() {
		int xFigure = getXLocationForWholeFigureCentered();
		int yFigure = getYLocationForWholeFigureCentered();
		drawOneBoxUp(xFigure, yFigure);
		drawThreeBoxesAtTheBottom(xFigure, yFigure);
		drawThreeLinesToConnectBoxes(xFigure, yFigure);		
	}
	
	private int getXLocationForWholeFigureCentered(){
		int canvasWidthMiddle = getWidth() / 2;
		int figureWidth = (BOX_WIDTH * 3) + (2 * xSpaceBetweenBoxes);
		return canvasWidthMiddle - (figureWidth / 2);
	}
	
	private int getYLocationForWholeFigureCentered(){
		int canvasHeightMiddle = getHeight() / 2;
		int figureHeight = (BOX_HEIGHT * 2) + ySpaceBetweenBoxes;
		return canvasHeightMiddle - (figureHeight / 2);
	}
	
	private void drawOneBoxUp(int xFigure, int yFigure){
		int xBox = xFigure + BOX_WIDTH + xSpaceBetweenBoxes;
		int yBox = yFigure;
		addBox(xBox, yBox);
		addLabelInBox(xBox, yBox, boxLabel[0]);
	}
	
	private void addBox (int x, int y){
		GRect box = new GRect(x, y, BOX_WIDTH, BOX_HEIGHT);
		add(box);
	}
	
	private void addLabelInBox(int xBox, int yBox, String boxLabel){
		GLabel label = new GLabel(boxLabel);
		double labelWidth = label.getWidth();
		double labelHeight = label.getAscent();
		double xLabel = xBox + ((BOX_WIDTH - labelWidth) / 2);
		double yLabel = yBox + labelHeight + ((BOX_HEIGHT - labelHeight) / 2);
		label.setLocation(xLabel, yLabel);
		add(label);
	}

	private void drawThreeBoxesAtTheBottom(int xFigure, int yFigure){
		int yBox = yFigure + BOX_HEIGHT + ySpaceBetweenBoxes;
		int xBox = xFigure;
		for(int i=1; i<4; i++){
			addBox(xBox, yBox);
			addLabelInBox(xBox, yBox, boxLabel[i]);
			xBox += BOX_WIDTH + xSpaceBetweenBoxes; 
		}
	}

	private void drawThreeLinesToConnectBoxes(int xFigure, int yFigure){
		int x1 = xFigure + BOX_WIDTH + xSpaceBetweenBoxes + (BOX_WIDTH / 2);
		int y1 = yFigure + BOX_HEIGHT;
		int x2 = xFigure + (BOX_WIDTH / 2);
		int y2 = y1 + ySpaceBetweenBoxes;
		for (int i = 0; i<3; i++){
			GLine line = new GLine(x1, y1, x2, y2);
			add(line);
			x2 += BOX_WIDTH + xSpaceBetweenBoxes;
		}
	}
}

