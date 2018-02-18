package com.contaazul.nasa.api.model;

public class Position {

	private int x;
	private int y;
	private CardinalPoint cardinalPoint;
	
	public Position(int x, int y, CardinalPoint cardinalPoint) {
		this.x = x;
		this.y = y;
		this.cardinalPoint = cardinalPoint;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public CardinalPoint getCardinalPoint() {
		return cardinalPoint;
	}

	public void setCardinalPoint(CardinalPoint cardinalPoint) {
		this.cardinalPoint = cardinalPoint;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + cardinalPoint.getInitials() + ")";
	}
}
