package domain;

import gui.Disc;

import java.util.ArrayList;

//domain by Ebbe Vang


public class Tower {
	private ArrayList<Disc> discs = new ArrayList<>();

	public ArrayList<Disc> getDiscs() {
		return discs;
	}

	public void addDisc(Disc disc) {
		discs.add(disc);
		
	}
}
