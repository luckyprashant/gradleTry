package com.jetblue.api.service;

import com.jetblue.api.domain.Location;
import com.jetblue.api.domain.NearByAirport;

/**
 * The Interface IAirportLocatorService.
 */
public interface IAirportLocatorService {

	/**
	 * Gets the airport.
	 *
	 * @param airport the airport
	 * @return the airport
	 */
	public NearByAirport getAirport(Location location);
	
}
