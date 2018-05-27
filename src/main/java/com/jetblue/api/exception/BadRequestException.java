package com.jetblue.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class BadRequestException.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new bad request exception.
	 *
	 * @param exception the exception
	 */
	public BadRequestException(String exception) {
		super(exception);
	}
	

}
