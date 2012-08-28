package com.thoughtworks.rover;

public class MarRovers {
	
	/*  Problem Chosen: Class Rovers
	 * 
	 * - Readable Code, no need to read to understand the comment.
	 * - I was careful with the use of the gets and sets unnecessary
	 * - I took care of null objects, because the object designer pattern nulls
	 * - Utilization of the exception
	 * - Strong validation before attribute to not start with null or empty, is
	 *   seeking a programmatically as defensive
	 * - Proper use of the builder;
	 * - Beware modified access and delegating responsibility for validating the
	 * correct method.
	 * - I took care of the designer code
	 * - Seeking names for attributes and methods of understanding object and
	 * understanding with direct and easy to understand
	 */

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
