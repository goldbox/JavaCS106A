/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

@SuppressWarnings("serial")
public class StoneMasonKarel extends SuperKarel {

	public void run(){
		repairColumn();
		while(frontIsClear()){
			goToNextColumn();
			repairColumn();
		}
		returnHome();
	}
	
	private void repairColumn(){
		turnLeft();
		repairCurrentStone();
		while(frontIsClear()){
			move();
			repairCurrentStone();
		}
		descendColumn();
	}
	
	private void repairCurrentStone(){
		if(noBeepersPresent()){
			putBeeper();
		}
	}
	
	private void descendColumn(){
		turnAround();
		while(frontIsClear()){
			move();
		}
		turnLeft();
	}
	
	private void goToNextColumn(){
		for(int i=0; i<4; i++){
			move();
		}
	}
	
	private void returnHome(){
		turnAround();
		while(frontIsClear()){
			move();
		}
		turnAround();
	}

}
