package com.thoughtworks.rover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ComunicationTest {

	Comunication comunication;
	Rover rover, roverTest1, roverTest2;

	@Before
	public void setUp() throws Exception {

		rover = new Rover("1 2 N");
		comunication = new Comunication();

	}

	@Test
	public void newRoverElement() {

		assertTrue(comunication.addRover(rover));

	}

	@Test(expected = IllegalStateException.class)
	public void colision() throws Exception {

		rover.move();
		comunication.addRover(rover);

		roverTest1 = new Rover("1 5 N");
		roverTest1.move();
		comunication.addRover(roverTest1);

		roverTest2 = new Rover("1 5 N");
		roverTest2.move();

		comunication.colision(roverTest2);

	}

	@Test
	public void turnRight() throws Exception {

		roverTest1 = new Rover("1 5 N");
		comunication.sequenceOfPositions("R", roverTest1);
		Assert.assertEquals("1 5 E", roverTest1.toString());

	}

	@Test
	public void sequencePosition() throws Exception {

		comunication.sequenceOfPositions("LLLLRRRMMMM", rover);
		assertEquals("1 2 W", rover.toString());

	}

	@Test
	public void changePositionNorthToWest() throws Exception {
		Rover roverTemp = new Rover("1 3 N");
		roverTemp.turnLeft();
		assertEquals("1 3 W", roverTemp.toString());
	}

	@Test
	public void changePositionNorthToEast() throws Exception {
		Rover roverTemp1 = new Rover("1 3 N");
		roverTemp1.turnRight();
		assertEquals("1 3 E", roverTemp1.toString());
	}

	@Test
	public void changePositionSouthToEast() throws Exception {
		Rover roverTemp2 = new Rover("1 3 S");
		roverTemp2.turnRight();
		assertEquals("1 3 W", roverTemp2.toString());
	}

}
