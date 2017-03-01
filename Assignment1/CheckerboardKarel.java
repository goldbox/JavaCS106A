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
	
	public void run(){
		putBeepersOnTheRow();
		while(leftIsClear()){
			moveToNextRow();
			putBeepersOnTheRow();
		}
		returnToInitialRow();
	}
	
	private void putBeepersOnTheRow(){
		decideTheStartingBeeper();
		while(frontIsClear()){
			move();
			drawThisSquare();
		}
		returnToBeginingOfRow();		
	}
	
	private void decideTheStartingBeeper(){
		if(rightIsBlocked()){
			putBeeper();
		} 
		else {
			moveToPreviousRow();
			if(beepersPresent()){
				moveToNextRow();
			} 
			else {
				moveToNextRow();
				putBeeper();
			}
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
		moveBackward();
		if(beepersPresent()){
			move();
		} 
		else {
			move();
			putBeeper();
		}
	}
	
	private void moveBackward(){
		turnAround();
		move();
		turnAround();
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
