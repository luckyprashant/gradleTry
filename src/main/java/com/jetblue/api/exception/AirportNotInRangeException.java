package com.jetblue.api.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * The Class AirportNotInRangeException.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AirportNotInRangeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new airport not found exception.
	 *
	 * @param exception the exception
	 */
	public AirportNotInRangeException(String exception) {
		super(exception);
	}

}
