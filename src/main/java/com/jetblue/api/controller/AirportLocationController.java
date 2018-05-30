package com.jetblue.api.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jetblue.api.domain.Location;
import com.jetblue.api.domain.NearByAirport;
import com.jetblue.api.error.ApplicationError;
import com.jetblue.api.error.ErrorHelper;
import com.jetblue.api.service.IAirportLocatorService;

import io.swagger.annotations.ApiOperation;

/**
 * RestController class for handling all incoming request -> then delegating to service layer for processing.
 * Exception handling in done in {@link CustomizedResponseEntityExceptionHandler} for keeping business logic separate from exception cases.
 */

@RestController
@RequestMapping("/api")
public class AirportLocationController {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAirportLocatorService airportLocatorService;
	
	@Autowired
	private ErrorHelper errorHelper;
	
	
	/**
	 * Gets the airport.
	 *
	 * @param airport the airport
	 * @return the airport
	 */
	@PostMapping(value = "/fetch-airport", produces = "application/json") 
	@ApiOperation(value = "To fetch nearest airport location for passed co-ordinates", response = ResponseEntity.class)
    public ResponseEntity<?> getAirport(@Valid @RequestBody Location location, BindingResult bindingErrors){
		LOG.debug("Location details for fetching nearest airport: {}", location);
		if(bindingErrors.hasErrors()) {
			LOG.error("Validation error in passed co-ordinate. Details: {}", location);
			ApplicationError applicationError = errorHelper.formApplicationError(bindingErrors.getAllErrors());
			return new ResponseEntity<ApplicationError>(applicationError, HttpStatus.BAD_REQUEST);
		}
		NearByAirport nearByAirport = airportLocatorService.getAirport(location);
		return new ResponseEntity<NearByAirport>(nearByAirport, HttpStatus.OK);
    }

}
