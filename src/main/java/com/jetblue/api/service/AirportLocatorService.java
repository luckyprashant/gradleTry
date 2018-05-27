package com.jetblue.api.service;

import org.springframework.stereotype.Service;

import com.jetblue.api.domain.Airport;
import com.jetblue.api.domain.Coordinate;
import com.jetblue.api.domain.NearByAirport;

@Service
public class AirportLocatorService {

	public NearByAirport getAirport(Airport coordinate) {
		// Read excel perform business logic
		return new NearByAirport(new Airport(new Coordinate(80l, 84l), "Amsterdam", "AMS"), "This is nearby");
	}

}
