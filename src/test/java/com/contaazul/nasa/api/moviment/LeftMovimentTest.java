package com.contaazul.nasa.api.moviment;

import static com.contaazul.nasa.api.model.CardinalPoint.NORTH;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.contaazul.nasa.api.model.Position;
import com.contaazul.nasa.api.model.Terrain;

public class LeftMovimentTest {

	private LeftMoviment leftMoviment;
	private Terrain terrain;

	@Before
	public void setUp() {
		terrain = new Terrain();
		terrain.setSizeY(5);
		terrain.setSyzeX(5);

		leftMoviment = new LeftMoviment();
	}

	@Test
	public void shouldMoveToWestWhenLeftMoveAndCurrentPositionIsNorth() {
		Position position = new Position(0, 0, NORTH);
		leftMoviment.getNewPosition(position, terrain);

		assertThat(position.toString(), is("(0, 0, W)"));
	}

}
