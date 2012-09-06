package com.thoughtworks.rover;

public class Comunication {

	private Rover rover;
	private Plateau plateau;

	public void startPosition(String XYPosition) throws NumberFormatException,
			Exception {

		if (XYPosition != null && !(XYPosition.isEmpty())) {

			String vectorStartPositionWithXYAndPPosition[] = XYPosition
					.split(" ");
			this.rover.coordinateX(Integer
					.parseInt(vectorStartPositionWithXYAndPPosition[0]));

			this.rover.coordinateY(Integer
					.parseInt(vectorStartPositionWithXYAndPPosition[1]));

			this.rover.direction(vectorStartPositionWithXYAndPPosition[2]
					.charAt(0));
		} else {
			throw new IllegalStateException(
					"Not valid start coordenate X and Y and/or position, write again ");

		}

	}

	public void sequenceOfPositions(String sequenceOfPositions)
			throws Exception {

		if (sequenceOfPositions != null && !(sequenceOfPositions.isEmpty())) {

			char commands[] = sequenceOfPositions.toCharArray();

			for (char command : commands) {
				if (command == 'M') {

					rover.move();
				} else {

					rover.turnOn(command);
				}
			}
		} else {
			throw new IllegalStateException(
					"Not valid sequence of positions, write again ");

		}

	}

}
