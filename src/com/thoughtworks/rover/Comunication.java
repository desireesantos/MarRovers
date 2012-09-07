package com.thoughtworks.rover;

public class Comunication {

	

	public Rover startPosition(String XYPosition,Rover rover)  {

		if (XYPosition != null && !(XYPosition.isEmpty())) {

			String vectorStartPositionWithXYAndPPosition[] = XYPosition
					.split(" ");
			rover.coordinateX(Integer
					.parseInt(vectorStartPositionWithXYAndPPosition[0]));

			rover.coordinateY(Integer
					.parseInt(vectorStartPositionWithXYAndPPosition[1]));

			rover.direction(vectorStartPositionWithXYAndPPosition[2]
					.charAt(0));
			
			
		} else {
			throw new IllegalStateException(
					"Not valid start coordenate X and Y and/or position, write again ");

		}

		 return rover ;
	}

	

}
