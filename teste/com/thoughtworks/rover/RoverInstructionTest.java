package com.thoughtworks.rover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class RoverInstructionTest {

	RoverInstruction roverInstruction;
	Rover rover, roverTest1, roverTest2;

	@Before
	public void setUp() throws Exception {

		rover = new Rover("1 2 N", "5 5");
		roverInstruction = new RoverInstruction();

	}

	@Test
	public void newRoverElement() {

		assertTrue(roverInstruction.addRover(rover));

	}

	@Test(expected = IllegalStateException.class)
	public void colision() throws Exception {

		rover.move();
		roverInstruction.addRover(rover);

		roverTest1 = new Rover("1 5 N", "5 5");
		roverTest1.move();
		roverInstruction.addRover(roverTest1);

		roverTest2 = new Rover("1 5 N", "5 5");
		roverTest2.move();

		roverInstruction.colision(roverTest2);

	}

	@Test
	public void turnRight() throws Exception {

		roverTest1 = new Rover("1 5 N", "5 5");
		roverInstruction.sequenceOfPositions("R", roverTest1);
		Assert.assertEquals("1 5 E", roverTest1.toString());

	}

	@Test(expected=IllegalStateException.class)
	public void sequencePosition() throws Exception {

		roverInstruction.sequenceOfPositions("LLLLRRRMMMM", rover);
		assertEquals("1 2 W", rover.toString());

	}

	@Test
	public void changePositionNorthToWest() throws Exception {
		Rover roverTemp = new Rover("1 3 N", "5 5");
		roverTemp.turnLeft();
		assertEquals("1 3 W", roverTemp.toString());
	}

	@Test
	public void changePositionNorthToEast() throws Exception {
		Rover roverTemp1 = new Rover("1 3 N", "5 5");
		roverTemp1.turnRight();
		assertEquals("1 3 E", roverTemp1.toString());
	}

	@Test
	public void changePositionSouthToEast() throws Exception {
		Rover roverTemp2 = new Rover("1 3 S", "5 5");
		roverTemp2.turnRight();
		assertEquals("1 3 W", roverTemp2.toString());
	}

}
