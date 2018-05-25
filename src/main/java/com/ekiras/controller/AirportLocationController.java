package com.ekiras.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekiras.domain.Airport;
import com.ekiras.domain.Coordinate;
import com.ekiras.exception.AirportNotFoundException;
import com.ekiras.service.AirportLocatorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by ekansh on 12/7/15.
 */

@RestController
@RequestMapping("/api")
public class AirportLocationController {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AirportLocatorService airportLocatorService;
	
	@GetMapping(value = "/test")
    public String test(){
        return " hello world";
    }
	
	@PostMapping(value = "/testMe", produces = "application/json") 
	@ApiOperation(value = "To fetch nearest airport location for passed co-ordinates", response = ResponseEntity.class)
    public ResponseEntity<?> getAirport(@RequestBody Coordinate coordinate){
		LOG.debug("Passed latitude: {}", coordinate.getLatitude());
		LOG.debug("{}", coordinate);
		throw new AirportNotFoundException("Dummy exception");
//		Airport airport = airportLocatorService.getAirport(coordinate);
//		return new ResponseEntity<Airport>(airport, HttpStatus.OK);
    }
}
