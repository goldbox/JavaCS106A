/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

@SuppressWarnings("serial")
public class MidpointFindingKarel extends SuperKarel {

	public void run(){
		fillARowWithBeepers();
		while(beepersPresent()){
			pickBeeper();
			moveToTheFurthestBeeper();
			turnAround();
		}
		putBeeper();
	}
	
	private void fillARowWithBeepers(){
		while(frontIsClear()){
			putBeeper();
			move();
		}
		putBeeper();
		returnToBeginingOfRow();
	}
	
	private void returnToBeginingOfRow(){
		turnAround();
		moveToWall();
		turnAround();
	}
	
	private void moveToWall(){
		while(frontIsClear()){
			move();
		}
	}

	private void moveToTheFurthestBeeper(){
		while(frontIsClear()){
			move();
			if(noBeepersPresent()){
				moveBackward();
				break;
			}
		}
	}
	
	private void moveBackward(){
		turnAround();
		move();
		turnAround();
	}
}
