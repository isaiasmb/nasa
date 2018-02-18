package com.contaazul.nasa.api.exception;

public class InvalidPositionException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidPositionException(String errorMessage) {
		super(errorMessage);
	}
	
}
