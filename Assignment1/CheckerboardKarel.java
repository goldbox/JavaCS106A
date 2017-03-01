/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

@SuppressWarnings("serial")
public class CheckerboardKarel extends SuperKarel {
	
	private boolean needsABeeper;
	
	public void run(){
		putBeepersOnTheRow();
		while(leftIsClear()){
			moveToNextRow();
			putBeepersOnTheRow();
		}
		returnToInitialRow();
	}
	
	private void putBeepersOnTheRow(){
		needsABeeper = decideTheStartingBeeper();
		drawThisSquare();
		while(frontIsClear()){
			move();
			drawThisSquare();
		}
		returnToBeginingOfRow();		
	}
	
	private boolean decideTheStartingBeeper(){
		if(rightIsBlocked()){
			return true;
		}
		moveToPreviousRow();
		if(beepersPresent()){
			moveToNextRow();
			return false;
		} 
		else {
			moveToNextRow();
			return true;
		}
	}
	
	private void moveToPreviousRow(){
		turnRight();
		move();
		turnLeft();
	}
	
	private void moveToNextRow(){
		turnLeft();
		move();
		turnRight();
	}
	
	private void drawThisSquare(){
		if(needsABeeper){
			putBeeper();
			needsABeeper = false;
		} else {
			needsABeeper = true;
		}
	}
	
	private void returnToBeginingOfRow(){
		turnAround();
		moveToWall();
		turnAround();
	}
	
	private void returnToInitialRow(){
		turnRight();
		moveToWall();
		turnLeft();
	}
	
	private void moveToWall(){
		while(frontIsClear()){
			move();
		}
	}

}
