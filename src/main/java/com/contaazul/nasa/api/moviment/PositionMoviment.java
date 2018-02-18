package com.contaazul.nasa.api.moviment;

import com.contaazul.nasa.api.exception.InvalidPositionException;
import com.contaazul.nasa.api.model.Position;
import com.contaazul.nasa.api.model.Terrain;

public interface PositionMoviment {
	
	public void getNewPosition(Position position, Terrain terrain) throws InvalidPositionException;

}
