package com.thoughtworks.rover;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.rover.Rover;

public class MarRoversTest {

	Rover rover, rover1, rover2, roverTemp;
	RoverInstruction roverInstruction;

	@Before
	public void setUp() throws Exception {

		rover = new Rover("1 3 N", "5 5");
		roverInstruction = new RoverInstruction();
	}

	@Test(expected = NumberFormatException.class)
	public void notTwoCoordenates() {
		new Rover("4 N", "5 5");

	}

	@Test(expected = NumberFormatException.class)
	public void oneCharEmptyCoordenate() {
		new Rover(" 4 N", "5 5");

	}

	@Test(expected = IllegalStateException.class)
	public void notCorrectCharPosition() {
		new Rover("1 2 D", "5 5");

	}

	@Test
	public void shouldTurnLeft() {
		roverTemp = new Rover("1 3 N", "5 5");
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
		roverTemp = new Rover("1 3 N", "5 5");
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
	public void positionNotPossibleToFly() throws Exception {
		new Rover("5 9 N", "5 7");

	}

	@Test
	public void endToend() throws Exception {

		rover1 = new Rover("1 2 N", "5 5");
		roverInstruction.sequenceOfPositions("LMLMLMLMM", rover1);
		System.out.println(rover1.toString());

		rover2 = new Rover("3 3 E", "5 5");
		roverInstruction.sequenceOfPositions("MMRMMRMRRM", rover2);
		System.out.println(rover2.toString());

	}

}
