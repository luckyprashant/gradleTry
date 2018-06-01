package com.jetblue.api.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jetblue.api.domain.Person;
import com.jetblue.api.error.ApplicationError;
import com.jetblue.api.error.ErrorHelper;
import com.jetblue.api.service.impl.IMaskService;

import io.swagger.annotations.ApiOperation;

@RestController
public class MaskController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IMaskService maskService;

	@Autowired
	private ErrorHelper errorHelper;


	/**
	 * Gets the airport.
	 *
	 * @param airport
	 *            the airport
	 * @return the airport
	 * @throws IOException
	 */
	@PostMapping(value = "/get-mask-response", produces = "application/json")
	@ApiOperation(value = "To get mask response.", response = ResponseEntity.class)
	public ResponseEntity<?> getAirport(@Valid @RequestBody Person person, BindingResult bindingErrors) throws IOException {
		LOG.debug("Details of the person to be masked", person); // Just logging for testing purpose, we shouldn't log
																	// since this contains sensetive data
		if (bindingErrors.hasErrors()) {
			LOG.error("Validation error in passed person. Details: {}", person);
			ApplicationError applicationError = errorHelper.formApplicationError(bindingErrors.getAllErrors());
			return new ResponseEntity<ApplicationError>(applicationError, HttpStatus.BAD_REQUEST);
		}
		Person maskedPerson = maskService.getMaskResponse(person);
		return new ResponseEntity<Person>(maskedPerson, HttpStatus.OK);
	}

}
