package com.thoughtworks.rover;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.rover.Rover;

public class MarRoversTest {

	Rover rover, maRoverTest;
	Comunication comunication;

	@Before
	public void setUp() throws Exception {

		rover = new Rover();
		comunication = new Comunication();
	}

	@Test(expected = IllegalStateException.class)
	public void CharNotCorrectForPosition() {
		comunication.startPosition("1 2 K", rover);

	}

	@Test(expected = IllegalStateException.class)
	public void CharNotCorrectForSideRover() throws Exception {
		rover.turn('N');

	}

	@Test(expected = IllegalStateException.class)
	public void sequencePositionsNull() throws Exception {
		rover.sequenceOfPositions(null);

	}

	@Test(expected = IllegalStateException.class)
	public void sequencePositionsEmpty() throws Exception {
		rover.sequenceOfPositions("");

	}

	@Test
	public void changeTwoPositionsRover() {
		comunication.startPosition("1 3 N", rover);
		rover.move();
		rover.move();

		assertEquals("1 5 N", rover.exibitCoordinate());
	}

	@Test
	public void changePositionNorthToWest() throws Exception {
		comunication.startPosition("1 3 N", rover);
		rover.turn('L');
		assertEquals("1 3 W", rover.exibitCoordinate());
	}

	@Test
	public void changePositionNorthToEast() throws Exception {
		comunication.startPosition("1 3 N", rover);
		rover.turn('R');
		assertEquals("1 3 E", rover.exibitCoordinate());
	}

	
	@Test
	public void sequencePosition() throws Exception {
		comunication.startPosition("1 3 N", rover);
		rover.sequenceOfPositions("LLLLRRRMMMM");
		assertEquals("-3 3 W", rover.exibitCoordinate());

	}

	@Test
	public void endToend() throws Exception {

		Rover rover1= new Rover() ;	
		Rover rover2= new Rover() ;
		
		Comunication comunicacao = new Comunication();		
		Plateau plateau = new Plateau(5, 5);
		

		rover1 = comunicacao.startPosition("1 2 N", rover1);		
		rover1.sequenceOfPositions("LMLMLMLMM");
		System.out.println(rover1.exibitCoordinate());
		
		
		rover2 = comunicacao.startPosition("3 3 E", rover2);
		rover2.sequenceOfPositions("MMRMMRMRRM");
		System.out.println(rover2.exibitCoordinate());


		

		
		

	}

}
