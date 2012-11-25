package com.thoughtworks.rover;

public class PermitedFly {

	private Plateau plateau;
	private int x;
	private int y;
	

	public PermitedFly(Plateau plateau) {
		this.plateau = plateau;
		this.x = plateau.x();
		this.y = plateau.y();
	}


	public int x() {
		return x;
	}


	public int y() {
		return y;
	}



}
