package com.ekiras.service;

import org.springframework.stereotype.Service;

import com.ekiras.domain.Airport;
import com.ekiras.domain.Coordinate;

@Service
public class AirportLocatorService {

	public Airport getAirport(Coordinate coordinate) {
		// Read excel perform business logic
		return new Airport(new Coordinate(80l, 84l), "Amsterdam", "AMS");
	}

}
