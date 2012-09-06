package com.thoughtworks.rover;

public class MarRovers {
	

	public static void main(String[] args) throws Exception {

		Rover marRoverONE = new Rover();
		Rover marRoverTWO = new Rover();

		marRoverONE.firstCoordenateXAndYRover("5 5");
		marRoverONE.startPositionRover("1 2 N");
		marRoverONE.sequenceOfPositions("LMLMLMLMM");

		marRoverTWO.startPositionRover("3 3 E");
		marRoverTWO.sequenceOfPositions("MMRMMRMRRM");

		System.out.println(marRoverONE
				.printActualyCoordenateXYAndPositionRover());
		System.out.println(marRoverTWO
				.printActualyCoordenateXYAndPositionRover());

	}

}
