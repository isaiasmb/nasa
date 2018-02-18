package com.contaazul.nasa.api.moviment;

import static com.contaazul.nasa.api.model.CardinalPoint.WEST;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.contaazul.nasa.api.model.Position;
import com.contaazul.nasa.api.model.Terrain;

public class RightMovimentTest {
	
	private RightMoviment rightMoviment;
	private Terrain terrain;

	@Before
	public void setUp() {
		terrain = new Terrain();
		terrain.setSizeY(5);
		terrain.setSyzeX(5);

		rightMoviment = new RightMoviment();
	}

	@Test
	public void shouldMoveToNorthWhenRightMoveAndCurrentPositionIsWest() {
		Position position = new Position(0, 0, WEST);
		rightMoviment.getNewPosition(position, terrain);
		
		Assert.assertThat(position.toString(), CoreMatchers.is("(0, 0, N)"));
	}

}
