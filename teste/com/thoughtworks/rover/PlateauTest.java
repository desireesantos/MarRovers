package com.thoughtworks.rover;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PlateauTest {

	Plateau plateau, plateauTest;

	@Before
	public void setUp() throws Exception {

		plateau = new Plateau(5, 5);
	}

	@Test
	public void exibirAreaPlateau() {

		plateauTest = new Plateau(10, 30);

		assertEquals("10 30", plateauTest.toString());
	}

}
