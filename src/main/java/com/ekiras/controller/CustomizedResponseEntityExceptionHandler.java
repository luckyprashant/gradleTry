package com.ekiras.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ekiras.exception.AirportNotFoundException;
import com.ekrias.error.ApplicationError;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
//	Logger Log = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(AirportNotFoundException.class)
	public final ResponseEntity<ApplicationError> handleUserNotFoundException(AirportNotFoundException ex,
			WebRequest request) {
		ApplicationError applicationError = new ApplicationError(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(applicationError, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ApplicationError> handleAllExceptions(Exception ex, WebRequest request) {
	  ApplicationError applicationError = new ApplicationError(new Date(), ex.getMessage(),
	      request.getDescription(false));
	  return new ResponseEntity<>(applicationError, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
