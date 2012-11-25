package com.thoughtworks.rover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class RoverInstructionTest {

	RoverInstruction roverInstruction;
	Rover rover, roverTest1, roverTest2;
	PermitedFly permitedFly;
	Plateau plateau;

	@Before
	public void setUp() throws Exception {
		plateau = new Plateau(5, 5);
		permitedFly = new PermitedFly(plateau); 
		rover = new Rover("1 2 N", permitedFly);
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

		roverTest1 = new Rover("1 5 N", permitedFly);
		roverTest1.move();
		roverInstruction.addRover(roverTest1);

		roverTest2 = new Rover("1 5 N", permitedFly);
		roverTest2.move();

		roverInstruction.colision(roverTest2);

	}

	@Test
	public void turnRight() throws Exception {

		roverTest1 = new Rover("1 5 N", permitedFly);
		roverInstruction.sequenceOfPositions("R", roverTest1);
		Assert.assertEquals("1 5 E", roverTest1.toString());

	}

	@Test(expected=IllegalStateException.class)
	public void sequencePosition() throws Exception {

		roverInstruction.sequenceOfPositions("LLLLRRRMMMM", rover);
		

	}

	@Test
	public void changePositionNorthToWest() throws Exception {
		Rover roverTemp = new Rover("1 3 N", permitedFly);
		roverTemp.turnLeft();
		assertEquals("1 3 W", roverTemp.toString());
	}

	@Test
	public void changePositionNorthToEast() throws Exception {
		Rover roverTemp1 = new Rover("1 3 N", permitedFly);
		roverTemp1.turnRight();
		assertEquals("1 3 E", roverTemp1.toString());
	}

	@Test
	public void changePositionSouthToEast() throws Exception {
		Rover roverTemp2 = new Rover("1 3 S", permitedFly);
		roverTemp2.turnRight();
		assertEquals("1 3 W", roverTemp2.toString());
	}

}
