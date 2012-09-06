package com.thoughtworks.rover;

public class Plateau {
	
	private int x;
	private int y;
	
	
	public Plateau() {	
		this.x = 0;
		this.y = 0;
	}
	
	public int x() {
		return x;
	}
	public int y() {
		return y;
	}
	
	public void x(int x) {
		this.x = x;
	}
	public void y(int y) {
		this.y = y;
	}
	
	public void delimitarArea(String firstCoordenateXAndY) {

		if (firstCoordenateXAndY != null && !(firstCoordenateXAndY.isEmpty())) {

			String vectorWithCoordenatesXandY[] = firstCoordenateXAndY
					.split(" ");
			this.x = Integer.parseInt(vectorWithCoordenatesXandY[0]);
			this.y = Integer.parseInt(vectorWithCoordenatesXandY[1]);
		} else {
			throw new IllegalStateException(
					"Not valid first coordenate X and Y, write again ");

		}

	}
	
	@Override
	public String toString() {

		return this.x + " " + this.y ;

	}


}
