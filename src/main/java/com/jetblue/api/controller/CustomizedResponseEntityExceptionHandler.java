package com.jetblue.api.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.jetblue.api.constant.AppEnum;
import com.jetblue.api.error.ApplicationError;
import com.jetblue.api.error.ErrorDetail;
import com.jetblue.api.error.ErrorHelper;
import com.jetblue.api.exception.AirportNotFoundException;
import com.jetblue.api.exception.AirportNotInRangeException;

/**
 * The Class CustomizedResponseEntityExceptionHandler.
 */
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ErrorHelper errorHelper;

	/**
	 * Handle user not found exception.
	 *
	 * @param ex
	 *            the ex
	 * @param request
	 *            the request
	 * @return the response entity
	 */
	@ExceptionHandler(AirportNotFoundException.class)
	public final ResponseEntity<ApplicationError> handleAirportNotFoundException(AirportNotFoundException ex, WebRequest request) {
		ApplicationError applicationError = new ApplicationError(new Date(), ex.getMessage(), request.getDescription(false));
		applicationError = errorHelper.setErrors(applicationError, new ErrorDetail(AppEnum.ErrorCode.AIRPORT_NOT_FOUND.getErrorCode(), AppEnum.ErrorCode.AIRPORT_NOT_FOUND.getErrorMessageKey(), AppEnum.ErrorCode.AIRPORT_NOT_FOUND.getErrorDescription()));
		return new ResponseEntity<>(applicationError, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Handle airport not in range exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(AirportNotInRangeException.class)
	public final ResponseEntity<ApplicationError> handleAirportNotInRangeException(AirportNotInRangeException ex, WebRequest request) {
		ApplicationError applicationError = new ApplicationError(new Date(), ex.getMessage(), request.getDescription(false));
		applicationError = errorHelper.setErrors(applicationError, new ErrorDetail(AppEnum.ErrorCode.AIRPORT_NOT_IN_RANGE.getErrorCode(), AppEnum.ErrorCode.AIRPORT_NOT_IN_RANGE.getErrorMessageKey(), AppEnum.ErrorCode.AIRPORT_NOT_IN_RANGE.getErrorDescription()));
		return new ResponseEntity<>(applicationError, HttpStatus.NOT_FOUND);
	}

	/**
	 * Handle all exceptions.
	 *
	 * @param ex
	 *            the ex
	 * @param request
	 *            the request
	 * @return the response entity
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ApplicationError> handleAllExceptions(Exception ex, WebRequest request) {
		ApplicationError applicationError = new ApplicationError(new Date(), ex.getMessage(), request.getDescription(false));
		applicationError = errorHelper.setErrors(applicationError, new ErrorDetail(AppEnum.ErrorCode.TECHINCAL.getErrorCode(), AppEnum.ErrorCode.TECHINCAL.getErrorMessageKey(), AppEnum.ErrorCode.TECHINCAL.getErrorDescription()));
		return new ResponseEntity<>(applicationError, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(JsonParseException.class)
	public final ResponseEntity<ApplicationError> handleJsonParseExceptions(JsonParseException ex, WebRequest request) {
		ApplicationError applicationError = new ApplicationError(new Date(), ex.getMessage(), request.getDescription(false));
		applicationError = errorHelper.setErrors(applicationError, new ErrorDetail(AppEnum.ErrorCode.TECHINCAL.getErrorCode(), AppEnum.ErrorCode.TECHINCAL.getErrorMessageKey(), AppEnum.ErrorCode.TECHINCAL.getErrorDescription()));
		return new ResponseEntity<>(applicationError, HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
