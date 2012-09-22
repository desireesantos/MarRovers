package com.thoughtworks.rover;

import java.util.ArrayList;

public class Comunication {

	private Plateau plateau;

	
	static ArrayList<Rover> arrayRovers = new ArrayList<Rover>();

	public Boolean addRover(Rover rover) {
		Boolean newRover = false;

		if (rover != null && !(rover.exibitCoordinate().isEmpty())) {

			arrayRovers.add(rover);
			newRover = true;

		} else {
			throw new IllegalStateException("Try again rover with error ");

		}

		return newRover;
	}

	public boolean colision(Rover rover) {
		Boolean hasColision = false;

		for (Rover marRover : arrayRovers) {
			if (rover.exibitCoordinate().equals(marRover.exibitCoordinate())) {
				throw new IllegalStateException("Colision, game over ");
			}
		}

		return hasColision;
	}

	public void sequenceOfPositions(String sequenceOfPositions, Rover rover)
			throws Exception {

		if (sequenceOfPositions != null && !(sequenceOfPositions.isEmpty())) {

			char commands[] = sequenceOfPositions.toCharArray();

			for (char command : commands) {

				if (command == 'M') {
					rover.move();

				}

				if (command == 'L') {
					rover.turnLeft();

				} else {
					rover.turnRight();
				}

			}

		} else {
			throw new IllegalStateException(
					"Not valid sequence of positions, write again ");

		}

	}

}
