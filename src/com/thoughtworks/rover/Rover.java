package com.thoughtworks.rover;

public class Rover {

	/*
	 * Problem chosen: MARS ROVERS (Number 2)
	 * Explanation: The solution to the case Rovers
	 * were a basis of building the skeleton rover with x and y coordinates plus
	 * the cardinal points (north, south, east and west). Based on this point I
	 * turn to the mobility of the 4 sides and floor to 4 sides. Thus primarily
	 * focused on direction and movement with the possible values ​​and
	 * subsequently created with functions such points mentioned
	 * before.Main point at all times good practice code,so it is easy to
	 * maintenance evolutionary addition to focusing on care using defensive
	 * programming and attentive to pattern Null. Good use of TDD with JUnit, as you can
	 * see there is a source folder just to put all code, because it's important to separete
	 * code test of the code source code.
	 */

	private static final char NORTH = 'N';
	private static final char SOUTH = 'S';
	private static final char EAST = 'E';
	private static final char WEST = 'W';
	private int coordinateX;
	private int coordinateY;
	private char direction;

	public Rover() {

		this.coordinateX = 0;
		this.coordinateY = 0;
		this.direction = 'N';
	}

	public char direction() {
		return direction;
	}

	public void direction(char direction) {

		if (direction == 'N' || direction == 'S' || direction == 'W'
				|| direction == 'E') {

			this.direction = direction;
		} else {
			throw new IllegalStateException(
					"Not valid value for direction, please write a correct direction");
		}

	}

	public void moveRoverPosition() {

		switch (direction()) {
		case NORTH:
			coordinateY++;
			break;
		case SOUTH:
			coordinateY--;
			break;
		case EAST:
			coordinateX++;
			break;
		case WEST:
			coordinateX--;
			break;

		}
	}

	public void changeDirectionRover(char commandSideRover) throws Exception {

		if (commandSideRover != 'L' && commandSideRover != 'R') {
			throw new IllegalStateException(
					"Not valid value for side direction ");
		}

		switch (direction()) {
		case NORTH:
			if (commandSideRover == 'L')
				direction = WEST;
			else
				direction = EAST;
			break;

		case SOUTH:
			if (commandSideRover == 'L')
				direction = EAST;
			else
				direction = WEST;
			break;

		case EAST:
			if (commandSideRover == 'L')
				direction = NORTH;
			else
				direction = SOUTH;
			break;
		case WEST:
			if (commandSideRover == 'L')
				direction = SOUTH;
			else
				direction = NORTH;
			break;

		}
	}

	public String printActualyCoordenateXYAndPositionRover() {

		return this.coordinateX + " " + this.coordinateY + " " + direction;

	}

	public void firstCoordenateXAndYRover(String firstCoordenateXAndY) {

		if (firstCoordenateXAndY != null && !(firstCoordenateXAndY.isEmpty())) {

			String vectorWithCoordenatesXandY[] = firstCoordenateXAndY
					.split(" ");
			this.coordinateX = Integer.parseInt(vectorWithCoordenatesXandY[0]);
			this.coordinateY = Integer.parseInt(vectorWithCoordenatesXandY[1]);
		} else {
			throw new IllegalStateException(
					"Not valid first coordenate X and Y, write again ");

		}

	}

	public void startPositionRover(String startPositionWithXYAndPPosition) {

		if (startPositionWithXYAndPPosition != null
				&& !(startPositionWithXYAndPPosition.isEmpty())) {

			String vectorStartPositionWithXYAndPPosition[] = startPositionWithXYAndPPosition
					.split(" ");
			this.coordinateX = Integer
					.parseInt(vectorStartPositionWithXYAndPPosition[0]);
			this.coordinateY = Integer
					.parseInt(vectorStartPositionWithXYAndPPosition[1]);
			this.direction(vectorStartPositionWithXYAndPPosition[2].charAt(0));
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

					moveRoverPosition();
				} else {

					changeDirectionRover(command);
				}
			}
		} else {
			throw new IllegalStateException(
					"Not valid sequence of positions, write again ");

		}

	}

}
