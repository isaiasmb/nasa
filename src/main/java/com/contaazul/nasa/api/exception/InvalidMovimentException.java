package com.contaazul.nasa.api.exception;

public class InvalidMovimentException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidMovimentException(String errorMessage) {
		super(errorMessage);
	}

}
