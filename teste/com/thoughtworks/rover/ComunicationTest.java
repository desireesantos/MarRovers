package com.thoughtworks.rover;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ComunicationTest {

	Comunication comunication;
	Rover rover;

	@Before
	public void setUp() throws Exception {

		comunication = new Comunication();
		rover = new Rover();

	}

	@Test
	public void startRoverNotNull() {

		comunication.startPosition("1 3 N", rover);
		rover.move();
		assertNotNull(rover);
	}

	
	@Test(expected = IllegalStateException.class)
	public void startPositionNull() throws Exception {
		
		comunication.startPosition(null, rover);

	}

	@Test
	public void turnOnePosition() {

		comunication.startPosition("1 3 N", rover);
		rover.move();
		assertEquals("1 4 N", rover.exibitCoordinate());
	}
	
	
	@Test
	public void sequences() throws Exception {
		comunication.startPosition("1 3 N", rover);
		rover.turn('L');
		rover.move();
		rover.move();
		rover.turn('R');
		rover.move();
		rover.move();
		rover.turn('R');
		rover.move();
		
		assertEquals("0 5 E", rover.exibitCoordinate() );
	}

}
