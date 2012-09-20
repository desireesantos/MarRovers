package com.thoughtworks.rover;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ComunicationTest {

	Comunication comunication;
	Rover rover, roverTest1, roverTest2;

	@Before
	public void setUp() throws Exception {

		Plateau plateau = new Plateau(5, 5);
		rover = new Rover("1 2 N");
		comunication = new Comunication(plateau);

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

}
