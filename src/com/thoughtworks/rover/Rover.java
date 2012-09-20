package com.thoughtworks.rover;

public class Rover {

	private static final char NORTH = 'N';
	private static final char SOUTH = 'S';
	private static final char EAST = 'E';
	private static final char WEST = 'W';
	private Integer coordinateX;
	private Integer coordinateY;
	private char direction;
	

	public Rover(String XYPosition) {

		startPosition(XYPosition);
		

	}

	public int coordinateX() {
		return coordinateX;
	}

	public void coordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}

	public int coordinateY() {
		return coordinateY;
	}

	public void coordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
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

	private Boolean validNumber(String coordenateValidNumber) {
		Boolean validCoordenatevalue = false;

		if (Integer.parseInt(coordenateValidNumber) > 0) {
			validCoordenatevalue = true;
		}

		return validCoordenatevalue;
	}

	private void startPosition(String xyPosition) {

		if (xyPosition != null && !xyPosition.isEmpty()) {
			String vectorStartPositionWithXYAndPPosition[] = xyPosition
					.split(" ");

			if (validNumber(vectorStartPositionWithXYAndPPosition[0]) ) {

				coordinateX(Integer
						.parseInt(vectorStartPositionWithXYAndPPosition[0]));
			} else {
				throw new IllegalStateException("Not valid value X ");
			}

			
			if (validNumber(vectorStartPositionWithXYAndPPosition[1])) {

				coordinateY(Integer
						.parseInt(vectorStartPositionWithXYAndPPosition[1]));
			} else {
				throw new IllegalStateException("Not valid value Y ");
			}
			

			direction(vectorStartPositionWithXYAndPPosition[2].charAt(0));
			//outOfAreaPlateau(plateau);

		} else {
			throw new NumberFormatException("Not valid coordenate write again ");

		}

	}

	public void move() {

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

	public void turn(char commandSideRover) throws Exception {

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

	public String exibitCoordinate() {
		return this.coordinateX + " " + this.coordinateY + " " + direction;
	}

	public void sequenceOfPositions(String sequenceOfPositions)
			throws Exception {

		if (sequenceOfPositions != null && !(sequenceOfPositions.isEmpty())) {

			char commands[] = sequenceOfPositions.toCharArray();

			for (char command : commands) {

				if (command == 'M') {
					move();

				} else {

					turn(command);

				}
			}
		} else {
			throw new IllegalStateException(
					"Not valid sequence of positions, write again ");

		}
	
	}
		
 
}
