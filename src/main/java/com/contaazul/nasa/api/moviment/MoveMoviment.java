package com.contaazul.nasa.api.moviment;

import com.contaazul.nasa.api.exception.InvalidPositionException;
import com.contaazul.nasa.api.model.Position;
import com.contaazul.nasa.api.model.Terrain;

public class MoveMoviment implements PositionMoviment {

	@Override
	public void getNewPosition(Position position, Terrain terrain) throws InvalidPositionException {
		
		switch (position.getCardinalPoint()) {
			case NORTH:
				validateNorthMoviment(position, terrain);
				position.setY(position.getY() + 1);
				break;
			case EAST:
				validateEastMoviment(position, terrain);
				position.setX(position.getX() + 1);
				break;
			case SOUTH:
				validateSouthMoviment(position, terrain);
				position.setY(position.getY() - 1);
				break;
			case WEST:
				validateWestMoviment(position, terrain);
				position.setX(position.getX() - 1);
				break;
		}
	}
	
	private void validateNorthMoviment(Position position, Terrain terrain) throws InvalidPositionException {
		if (position.getY() == terrain.getSizeY()) {
			throw new InvalidPositionException("Posição inválida");
		}
	}
	
	private void validateEastMoviment(Position position, Terrain terrain) throws InvalidPositionException {
		if (position.getX() == terrain.getSyzeX()) {
			throw new InvalidPositionException("Posição inválida");
		}
	}
	
	private void validateSouthMoviment(Position position, Terrain terrain) throws InvalidPositionException {
		if (position.getY() == 0) {
			throw new InvalidPositionException("Posição inválida");
		}
	}
	
	private void validateWestMoviment(Position position, Terrain terrain) throws InvalidPositionException {
		if (position.getX() == 0) {
			throw new InvalidPositionException("Posição inválida");
		}
	}

}
