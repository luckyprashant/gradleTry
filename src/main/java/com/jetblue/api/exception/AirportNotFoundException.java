package com.jetblue.api.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AirportNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AirportNotFoundException(String exception) {
		super(exception);
	}

}
