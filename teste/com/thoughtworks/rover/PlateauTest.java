package com.thoughtworks.rover;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class PlateauTest {

	Plateau plateau;

	@Before
	public void setUp() throws Exception {

		plateau = new Plateau();
	}

	@Test
	public void positionInicialX() {

		assertEquals(Integer.parseInt("5"), plateau.x());
	}

	

}
