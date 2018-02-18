package com.contaazul.nasa.api.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.contaazul.nasa.api.exception.InvalidMovimentException;
import com.contaazul.nasa.api.moviment.LeftMoviment;
import com.contaazul.nasa.api.moviment.MoveMoviment;
import com.contaazul.nasa.api.moviment.PositionMoviment;
import com.contaazul.nasa.api.moviment.RightMoviment;

public enum Moviment {
	L {
		@Override
		public PositionMoviment getPositionMoviment() {
			return new LeftMoviment();
		}
	},

	R {
		@Override
		public PositionMoviment getPositionMoviment() {
			return new RightMoviment();
		}
	},

	M {
		@Override
		public PositionMoviment getPositionMoviment() {
			return new MoveMoviment();
		}
	};

	public static List<Moviment> parseStringToMoviments(String stringMoviments) {
		List<String> strings = Arrays.asList(stringMoviments.replace(" ", "").split(""));
		List<Moviment> moviments = new ArrayList<>();		
		
		strings.forEach(string -> {
			switch (string) {
			case "L":
				moviments.add(L);
				break;
			case "R":
				moviments.add(R);
				break;
			case "M":
				moviments.add(M);
				break;
			default:
				throw new InvalidMovimentException("Comando inválido");
			}
		});
		return moviments;
	}

	public abstract PositionMoviment getPositionMoviment();
}
