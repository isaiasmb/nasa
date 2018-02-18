package com.contaazul.nasa.api.moviment;

import static com.contaazul.nasa.api.model.CardinalPoint.NORTH;
import static com.contaazul.nasa.api.model.CardinalPoint.WEST;

import com.contaazul.nasa.api.model.CardinalPoint;
import com.contaazul.nasa.api.model.Position;
import com.contaazul.nasa.api.model.Terrain;

public class LeftMoviment implements PositionMoviment {

	@Override
	public void getNewPosition(Position position, Terrain terrain) {		
		if (position.getCardinalPoint().equals(NORTH)) {
			position.setCardinalPoint(WEST);
		} else {
			position.setCardinalPoint(CardinalPoint.values()[position.getCardinalPoint().ordinal() - 1]);
		}
	}

}
