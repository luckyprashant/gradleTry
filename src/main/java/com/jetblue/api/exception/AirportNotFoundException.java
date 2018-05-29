package com.jetblue.api.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * The Class AirportNotFoundException.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AirportNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new airport not found exception.
	 *
	 * @param exception the exception
	 */
	public AirportNotFoundException(String exception) {
		super(exception);
	}

}
