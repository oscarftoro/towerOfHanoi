package domain;

import java.util.Scanner;

import javax.swing.JFrame;

import gui.*;
//domain by Ebbe Vang


public class TowerOfHanoiGame {

	private int counter =0;
	private Tower[] towers  = {new Tower(), new Tower(), new Tower()};
	
	
	
	
	public TowerOfHanoiGame(){
		gameInitilization();
		drawToConsole();
		simpleConsoleControl();
	}
	
	private void simpleConsoleControl() {
		Scanner console = new Scanner(System.in);
		while (!gameOver()){
			int fromTower = console.nextInt();
			int toTower = console.nextInt();
			moveDisc(fromTower, toTower);
			drawToConsole();			
		}
		
		System.out.println("Du klarede den!");
		
	}

	private void drawToConsole() {
		// temporary crap to make the game work
		// refactor? could be improved now when the towers are in an array :-)
		System.out.print("Tower1: ");
		for (Disc disc : towers[0].getDiscs()) {
			System.out.print(disc + ", ");
		}
		System.out.println();
		
		System.out.print("Tower2: ");
		for (Disc disc : towers[1].getDiscs()) {
			System.out.print(disc + ", ");
		}
		System.out.println();
		
		System.out.print("Tower3: ");
		for (Disc disc : towers[2].getDiscs()) {
			System.out.print(disc + ", ");
		}
		System.out.println();
	}
// first value to, second value from
	private void moveDisc(int to, int from) {
		Tower TowerTo = towers[to-1];
		Tower TowerFrom = towers[from-1];
		//when the tower is not empty 
		if (TowerFrom.getDiscs().size()>0){
			//take the last disc from the tower "from"
			Disc disc = TowerFrom.getDiscs().get(TowerFrom.getDiscs().size()-1);
			//if tower is empty or the size is of tower "to" is bigger than disc from tower "from" continue
			if (TowerTo.getDiscs().size() == 0 || TowerTo.getDiscs().get(TowerTo.getDiscs().size()-1).getSize() > disc.getSize()){
				//add disc
				TowerTo.getDiscs().add(disc);
				//remove the previous disc from tower "from"
				TowerFrom.getDiscs().remove(disc);
			}
		}
	}
	
	private boolean gameOver() {
		// End with tower 3 (3-1 = 2) has 3 discs
		return towers[2].getDiscs().size() == 3;
	}
	
	private void gameInitilization() {
		
		// create 3 discs
		for (int i = 3; i>= 1; i--) {
			towers[0].addDisc(new Disc(i));
		}
	}	
}
