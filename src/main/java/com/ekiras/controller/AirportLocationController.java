package com.ekiras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ekiras.domain.Airport;
import com.ekiras.domain.Coordinate;
import com.ekiras.service.AirportLocatorService;

/**
 * Created by ekansh on 12/7/15.
 */

@RestController
public class AirportLocationController {
	
	@Autowired
	private AirportLocatorService airportLocatorService;
	
	@GetMapping(value = "/test")
    public String test(){
        return " hello world";
    }
	
	@PostMapping(value = "/testMe")
    public ResponseEntity<?> getAirport(@RequestBody Coordinate coordinate){
		System.out.println(coordinate.getLatitude());
		Airport airport = airportLocatorService.getAirport(coordinate);
		return new ResponseEntity<Airport>(airport, HttpStatus.OK);
    }
}
