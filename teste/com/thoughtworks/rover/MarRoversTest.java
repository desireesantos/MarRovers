package com.thoughtworks.rover;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.rover.Rover;

public class MarRoversTest {

	Rover rover, rover1, rover2, roverTemp;
	RoverInstruction roverInstruction;
	PermitedFly  permitedFly;

	@Before
	public void setUp() throws Exception {
		permitedFly = new PermitedFly(new Plateau(5, 5));
		rover = new Rover("1 3 N", permitedFly);
		roverInstruction = new RoverInstruction();
	}

	@Test(expected = NumberFormatException.class)
	public void notTwoCoordenates() {
		new Rover("4 N", permitedFly);

	}

	@Test(expected = NumberFormatException.class)
	public void oneCharEmptyCoordenate() {
		new Rover(" 4 N", permitedFly);

	}

	@Test(expected = IllegalStateException.class)
	public void notCorrectCharPosition() {
		new Rover("1 2 D", permitedFly);

	}

	@Test
	public void shouldTurnLeft() {
		roverTemp = new Rover("1 3 N", permitedFly);
		roverTemp.turnLeft();
		assertEquals('W', roverTemp.direction());
		roverTemp.turnLeft();
		assertEquals('S', roverTemp.direction());
		roverTemp.turnLeft();
		assertEquals('E', roverTemp.direction());
		roverTemp.turnLeft();
		assertEquals('N', roverTemp.direction());
	}

	@Test
	public void shouldTurnRight() {
		roverTemp = new Rover("1 3 N", permitedFly);
		roverTemp.turnRight();
		assertEquals('E', roverTemp.direction());
		roverTemp.turnRight();
		assertEquals('S', roverTemp.direction());
		roverTemp.turnRight();
		assertEquals('W', roverTemp.direction());
		roverTemp.turnRight();
		assertEquals('N', roverTemp.direction());
	}

	@Test
	public void move() throws Exception {
		rover.move();
		assertEquals("1 4 N", rover.toString());
	}

	@Test
	public void notNullPrintInformationRover() throws Exception {
		assertNotNull(rover.toString());

	}

	@Test(expected = IllegalStateException.class)
	public void coordinateYNotPossibleToFly() throws Exception {
		new Rover("5 9 N", permitedFly);

	}
	
	@Test(expected=IllegalStateException.class)
	public void coordinateXNotPossibleToFly() throws Exception {
		new Rover("9 7 N", permitedFly);

	}

	@Test
	public void endToend() throws Exception {

		rover1 = new Rover("1 2 N", permitedFly);
		roverInstruction.sequenceOfPositions("LMLMLMLMM", rover1);
		System.out.println(rover1.toString());

		rover2 = new Rover("3 3 E", permitedFly);
		roverInstruction.sequenceOfPositions("MMRMMRMRRM", rover2);
		System.out.println(rover2.toString());

	}

}
