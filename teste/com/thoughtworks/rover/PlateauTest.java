package com.thoughtworks.rover;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class PlateauTest {

	Plateau plateau, plateauTest;

	@Before
	public void setUp() throws Exception {

		plateau = new Plateau(5,5);
	}

	@Test
	public void positionInicialX() {

		assertEquals(5, plateau.x());
	}

	
	@Test
	public void exibirAreaPlateau() {
		
		plateauTest = new Plateau(10, 30);

		assertEquals( "10 30", plateauTest.exibitCoordinate());
	}

	
	@Test
	public void endToend() {
				

		assertEquals( "Maior coordenada do plateau Ž (x,y):", "5 5", plateau.exibitCoordinate());
	}

}
