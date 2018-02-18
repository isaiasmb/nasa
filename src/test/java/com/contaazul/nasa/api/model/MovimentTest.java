package com.contaazul.nasa.api.model;

import org.junit.Test;

import com.contaazul.nasa.api.exception.InvalidMovimentException;

public class MovimentTest {

	@Test(expected = InvalidMovimentException.class)
	public void shouldThrowExceptionWhenParseInvalidMoviment() {
		String stringInvalidMoviment = "MMRLA";
		Moviment.parseStringToMoviments(stringInvalidMoviment);
	}
}
