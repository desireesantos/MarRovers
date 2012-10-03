package com.thoughtworks.rover;

public class Plateau {

	private int x;
	private int y;

	public Plateau(int x, int y) {

		if (x > 0) {
			this.x = x;
		} else {
			throw new IllegalStateException("Not valid value X ");
		}

		if (y > 0) {
			this.y = y;
		} else {
			throw new IllegalStateException("Not valid value Y ");
		}

	}

	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	@Override
	public String toString() {
		return this.x + " " + this.y;
	}

}
