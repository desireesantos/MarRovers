package com.thoughtworks.rover;

public class Rover {

	private static final char NORTH = 'N';
	private static final char SOUTH = 'S';
	private static final char EAST = 'E';
	private static final char WEST = 'W';
	private int coordinateX;
	private int coordinateY;
	private char direction;
	private int permitedFlyCoordinateX;
	private int permitedFlyCoordinateY;

	public Rover(String actualyPositionRover, PermitedFly permitedAreaToFly) {

		startPosition(actualyPositionRover);
		validInitialPosition(permitedAreaToFly);

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
					"Not valid value direction, please write a correct direction");
		}

	}

	private Boolean validInitialPosition(PermitedFly possibleAreaRoverToFly) {
		Boolean validPosition = true;

		if (possibleAreaRoverToFly != null) {

			if (validNumber(Integer.toString(possibleAreaRoverToFly.x()))) {

				permitedFlyCoordinateX = possibleAreaRoverToFly.x();
			} else {
				throw new IllegalStateException("Not valid value area X ");
			}

			if (validNumber(Integer.toString(possibleAreaRoverToFly.y()))) {

				permitedFlyCoordinateY = possibleAreaRoverToFly.y();
			}

			else {
				throw new IllegalStateException("Not valid value area Y ");
			}

			if (coordinateX() > permitedFlyCoordinateX
					|| coordinateY() > permitedFlyCoordinateY) {
				validPosition = false;
				throw new IllegalStateException("Coordenate is out of the area");
			}

		} else {
			throw new NumberFormatException("Not valid coordenate write again ");

		}

		return validPosition;
	}

	private void startPosition(String xyPosition) {

		if (xyPosition != null && !xyPosition.isEmpty()) {
			String vectorStartPositionWithXYAndPPosition[] = xyPosition
					.split(" ");

			if (validNumber(vectorStartPositionWithXYAndPPosition[0])) {

				coordinateX(Integer
						.parseInt(vectorStartPositionWithXYAndPPosition[0]));
			} else {
				throw new IllegalStateException("Not valid value X ");
			}

			if (validNumber(vectorStartPositionWithXYAndPPosition[1])) {

				coordinateY(Integer
						.parseInt(vectorStartPositionWithXYAndPPosition[1]));
			}

			else {
				throw new IllegalStateException("Not valid value Y ");
			}

			direction(vectorStartPositionWithXYAndPPosition[2].charAt(0));

		} else {
			throw new NumberFormatException("Not valid coordenate write again ");

		}

	}

	private Boolean validNumber(String coordenateValidNumber) {
		Boolean validCoordenatevalue = false;

		if (Integer.parseInt(coordenateValidNumber) > 0) {
			validCoordenatevalue = true;
		}

		return validCoordenatevalue;
	}

	public void move() {

		switch (direction) {

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

	@Override
	public String toString() {
		return this.coordinateX + " " + this.coordinateY + " " + direction;
	}

	public void turnLeft() {

		switch (direction) {

		case NORTH:
			direction = WEST;
			break;

		case SOUTH:
			direction = EAST;
			break;

		case EAST:
			direction = NORTH;
			break;

		case WEST:
			direction = SOUTH;
			break;

		}

	}

	public void turnRight() {

		if (direction == NORTH) {
			direction = EAST;
		} else {

			if (direction == SOUTH) {
				direction = WEST;
			} else {

				if (direction == EAST) {
					direction = SOUTH;

				} else {
					if (direction == WEST) {
						direction = NORTH;
					}

				}
			}
		}
	}
}
