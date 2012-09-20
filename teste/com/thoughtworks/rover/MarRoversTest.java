package com.thoughtworks.rover;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.rover.Rover;

public class MarRoversTest {

	Rover rover, roverTemp, roverTemp1, roverTemp2;
	

	@Before
	public void setUp() throws Exception {

		rover = new Rover("1 3 N");
	}

	@Test(expected = NumberFormatException.class)
	public void notTwoCoordenates() {
		new Rover("4 N");

	}

	@Test(expected = NumberFormatException.class)
	public void oneCharEmptyCoordenate() {
		new Rover(" 4 N");

	}

	@Test(expected = IllegalStateException.class)
	public void notCorrectCharPosition() {
		new Rover("1 2 D");

	}

	@Test(expected = IllegalStateException.class)
	public void charNotCorrectTurnRover() throws Exception {
		rover.turn('N');

	}

	@Test
	public void changePositionNorthToWest() throws Exception {
		roverTemp = new Rover("1 3 N");
		roverTemp.turn('L');
		assertEquals("1 3 W", roverTemp.exibitCoordinate());
	}

	@Test
	public void changePositionNorthToEast() throws Exception {
		roverTemp1 = new Rover("1 3 N");
		roverTemp1.turn('R');
		assertEquals("1 3 E", roverTemp1.exibitCoordinate());
	}

	@Test
	public void changePositionSouthToEast() throws Exception {
		roverTemp2 = new Rover("1 3 S");
		roverTemp2.turn('L');
		assertEquals("1 3 E", roverTemp2.exibitCoordinate());
	}

	@Test
	public void move() throws Exception {

		rover.move();
		assertEquals("1 4 N", rover.exibitCoordinate());
	}

	@Test
	public void sequencePosition() throws Exception {

		rover.sequenceOfPositions("LLLLRRRMMMM");
		assertEquals("-3 3 W", rover.exibitCoordinate());

	}

	@Test
	public void notNullPrintInformationRover() throws Exception {

		assertNotNull(rover.exibitCoordinate());

	}

	@Test
	public void endToend() throws Exception {

		Plateau plateau = new Plateau(5, 5);

		Rover rover1 = new Rover("1 2 N");
		rover1.sequenceOfPositions("LMLMLMLMM");
		System.out.println(rover1.exibitCoordinate());

		Rover rover2 = new Rover("3 3 E");
		rover2.sequenceOfPositions("MMRMMRMRRM");
		System.out.println(rover2.exibitCoordinate());

	}

}
