package com.thoughtworks.rover;

import java.util.ArrayList;

public class RoverInstruction {

	static ArrayList<Rover> arrayRovers = new ArrayList<Rover>();

	public Boolean addRover(Rover rover) {
		Boolean newRover = false;

		if (rover != null && !(rover.toString().isEmpty())) {

			arrayRovers.add(rover);
			newRover = true;

		} else {
			throw new IllegalStateException("Try again rover with error ");

		}

		return newRover;
	}

	public void colision(Rover rover) {
	

		for (Rover marRover : arrayRovers) {
			if (rover.toString().equals(marRover.toString())) {
				throw new IllegalStateException("Colision, game over ");
			}
		}

	
	}

	public void sequenceOfPositions(String sequenceOfPositions, Rover rover)
			throws Exception {

		if (sequenceOfPositions != null && !(sequenceOfPositions.isEmpty())) {

			char commands[] = sequenceOfPositions.toCharArray();

			for (char command : commands) {
				

				if (command == 'M') {
					rover.move();
					colision(rover);
				}

				if (command == 'L') {
					rover.turnLeft();
					colision(rover);

				} else {
					rover.turnRight();
					colision(rover);
				}
			}

		} else {
			throw new IllegalStateException(
					"Not valid sequence of positions, write again ");

		}

	}

}
