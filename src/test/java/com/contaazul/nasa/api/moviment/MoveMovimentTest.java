package com.contaazul.nasa.api.moviment;

import static com.contaazul.nasa.api.model.CardinalPoint.EAST;
import static com.contaazul.nasa.api.model.CardinalPoint.NORTH;
import static com.contaazul.nasa.api.model.CardinalPoint.SOUTH;
import static com.contaazul.nasa.api.model.CardinalPoint.WEST;

import org.junit.Before;
import org.junit.Test;

import com.contaazul.nasa.api.exception.InvalidPositionException;
import com.contaazul.nasa.api.model.Position;
import com.contaazul.nasa.api.model.Terrain;

public class MoveMovimentTest {
	
	private MoveMoviment moveMoviment;
	private Terrain terrain;

	@Before
	public void setUp() {
		terrain = new Terrain();
		terrain.setSizeY(5);
		terrain.setSyzeX(5);
		
		moveMoviment = new MoveMoviment();
	}
	
	@Test(expected = InvalidPositionException.class)
	public void shouldThrowExceptionWhenMoveToNorth() {
		Position position = new Position(0, 5, NORTH);
		moveMoviment.getNewPosition(position, terrain);
	}
	
	@Test(expected = InvalidPositionException.class)
	public void shouldThrowExceptionWhenMoveToEast() {
		Position position = new Position(5, 0, EAST);
		moveMoviment.getNewPosition(position, terrain);
	}
	
	@Test(expected = InvalidPositionException.class)
	public void shouldThrowExceptionWhenMoveToSouth() {
		Position position = new Position(0, 0, SOUTH);
		moveMoviment.getNewPosition(position, terrain);
	}
	
	@Test(expected = InvalidPositionException.class)
	public void shouldThrowExceptionWhenMoveToWest() {
		Position position = new Position(0, 0, WEST);
		moveMoviment.getNewPosition(position, terrain);
	}

}
