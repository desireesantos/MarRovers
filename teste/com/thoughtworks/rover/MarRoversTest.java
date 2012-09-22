package com.thoughtworks.rover;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.COMM_FAILURE;

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

	@Test
	public void shouldTurnLeft() {
		roverTemp = new Rover("1 3 N");
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
		roverTemp = new Rover("1 3 N");
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
		assertEquals("1 4 N", rover.exibitCoordinate());
	}

	@Test
	public void notNullPrintInformationRover() throws Exception {

		assertNotNull(rover.exibitCoordinate());

	}

	@Test
	public void endToend() throws Exception {

		Plateau plateau = new Plateau(5, 5);
		Comunication comunication = new Comunication();

		Rover rover1 = new Rover("1 2 N");
		comunication.sequenceOfPositions("LMLMLMLMM", rover1);
		System.out.println(rover1.exibitCoordinate());

		Rover rover2 = new Rover("3 3 E");
		comunication.sequenceOfPositions("MMRMMRMRRM", rover2);
		System.out.println(rover2.exibitCoordinate());

	}

}
