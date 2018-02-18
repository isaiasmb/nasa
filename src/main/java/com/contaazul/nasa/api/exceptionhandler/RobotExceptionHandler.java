package com.contaazul.nasa.api.exceptionhandler;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.contaazul.nasa.api.exception.InvalidMovimentException;
import com.contaazul.nasa.api.exception.InvalidPositionException;

@ControllerAdvice
public class RobotExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ InvalidMovimentException.class, InvalidPositionException.class })
	public ResponseEntity<Object> handleItemException(Exception ex, WebRequest request) {
		String message = ex.getMessage();
		List<Error> errors = Arrays.asList(new Error(message));
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

}
