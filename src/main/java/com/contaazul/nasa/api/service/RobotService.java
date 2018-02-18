package com.contaazul.nasa.api.service;

import static com.contaazul.nasa.api.model.CardinalPoint.NORTH;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contaazul.nasa.api.model.Moviment;
import com.contaazul.nasa.api.model.Position;
import com.contaazul.nasa.api.model.Terrain;
import com.contaazul.nasa.api.moviment.PositionMoviment;

@Service
public class RobotService {

	public String executeMoviment(List<Moviment> moviments) {
		Position position = new Position(0, 0, NORTH);
		Terrain terrain = new Terrain();
		terrain.setSizeY(5);
		terrain.setSyzeX(5);
		
		moviments.forEach(moviment -> {
			PositionMoviment positionMoviment = moviment.getPositionMoviment();
			positionMoviment.getNewPosition(position, terrain);
		});

		return position.toString();
	}
}
