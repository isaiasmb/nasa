package com.contaazul.nasa.api.model;

public enum CardinalPoint {

	NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

	private String initials;

	private CardinalPoint(String initials) {
		this.initials = initials;
	}

	public String getInitials() {
		return initials;
	}

}
