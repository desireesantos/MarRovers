package com.thoughtworks.rover;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.rover.Rover;

public class MarRoversTest {

	Rover marRovers, maRoverTest;

	@Before
	public void setUp() throws Exception {

		marRovers = new Rover();
	}

	@Test
	public void changeOnePositionRover() {
		marRovers.startPositionRover("1 3 N");
		marRovers.moveRoverPosition();

		assertEquals("1 4 N",
				marRovers.printActualyCoordenateXYAndPositionRover());
	}

	@Test(expected = IllegalStateException.class)
	public void startPositionNull() throws Exception {
		marRovers.startPositionRover(null);

	}

	@Test(expected = IllegalStateException.class)
	public void startPositionEmpty() throws Exception {
		marRovers.startPositionRover("");

	}

	@Test(expected = IllegalStateException.class)
	public void CharNotCorrectForPosition() {
		marRovers.startPositionRover("1 2 K");

	}
	
	@Test(expected = IllegalStateException.class)
	public void CharNotCorrectForSideRover() throws Exception {
		marRovers.changeDirectionRover('N');

	}
	
	@Test(expected=IllegalStateException.class)
	public void SideRoverWithCharLower() throws Exception {
		marRovers.changeDirectionRover('l');

	}
	

	@Test(expected= IllegalStateException.class)
	public void sequencePositionsNull() throws Exception {
		marRovers.sequenceOfPositions(null);

	}

	@Test(expected=IllegalStateException.class)
	public void sequencePositionsEmpty() throws Exception {
		marRovers.sequenceOfPositions("");

	}
	@Test
	public void changeTwoPositionsRover() {
		marRovers.startPositionRover("1 3 N");
		marRovers.moveRoverPosition();
		marRovers.moveRoverPosition();

		assertEquals("1 5 N",
				marRovers.printActualyCoordenateXYAndPositionRover());
	}

	@Test
	public void changePositionNorthToWest() throws Exception {
		marRovers.startPositionRover("1 3 N");
		marRovers.changeDirectionRover('L');
		assertEquals("1 3 W",
				marRovers.printActualyCoordenateXYAndPositionRover());
	}

	@Test
	public void changePositionNorthToEast() throws Exception {
		marRovers.startPositionRover("1 3 N");
		marRovers.changeDirectionRover('R');
		assertEquals("1 3 E",
				marRovers.printActualyCoordenateXYAndPositionRover());
	}
	
	@Test
	public void sequences() throws Exception {
		marRovers.startPositionRover("1 3 N");
		marRovers.changeDirectionRover('L');
		marRovers.moveRoverPosition();
		marRovers.moveRoverPosition();
		marRovers.changeDirectionRover('R');
		marRovers.moveRoverPosition();
		marRovers.moveRoverPosition();
		marRovers.changeDirectionRover('R');
		marRovers.moveRoverPosition();
		
		assertEquals("0 5 E", marRovers.printActualyCoordenateXYAndPositionRover() );
	}
	
	@Test(expected = IllegalStateException.class)
	public void firstCoordenateNull() throws Exception {
		marRovers.firstCoordenateXAndYRover(null);

	}

	@Test(expected = IllegalStateException.class)
	public void firstCoordenateEmpty() throws Exception {
		marRovers.firstCoordenateXAndYRover("");

	}

	@Test
	public void sequencePosition() throws Exception {
		marRovers.startPositionRover("1 3 N");
		marRovers.sequenceOfPositions("LLLLRRRMMMM");
		assertEquals("-3 3 W", marRovers.printActualyCoordenateXYAndPositionRover() );
		
		
	}
	
	
	@Test
	public void endToEnd() throws Exception{
		
		Rover marRoverONE = new Rover();
		Rover marRoverTWO = new Rover();

		marRoverONE.firstCoordenateXAndYRover("5 5");
		marRoverONE.startPositionRover("1 2 N");
		marRoverONE.sequenceOfPositions("LMLMLMLMM");

		marRoverTWO.startPositionRover("3 3 E");
		marRoverTWO.sequenceOfPositions("MMRMMRMRRM");

		assertEquals( "1 3 N" , marRoverONE
				.printActualyCoordenateXYAndPositionRover());
		
		assertEquals( "5 1 E" , marRoverTWO
				.printActualyCoordenateXYAndPositionRover());



		
	}
	

	

}
