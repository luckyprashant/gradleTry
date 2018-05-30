package com.jetblue.api.service.impl;

import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jetblue.api.csvreader.CsvReader;
import com.jetblue.api.domain.Airport;
import com.jetblue.api.domain.Location;
import com.jetblue.api.domain.NearByAirport;
import com.jetblue.api.exception.AirportNotFoundException;
import com.jetblue.api.service.IAirportLocatorService;

/**
 * The Class AirportLocatorService.
 */
@Service
public class AirportLocatorService implements IAirportLocatorService {

	private final static Logger LOG = LoggerFactory.getLogger(AirportLocatorService.class);
	
	@Autowired
	private CsvReader csvReader;
	/**
	 * Gets the airport.
	 *
	 * @param airport
	 *            the aiport coordinate
	 * @return the airport
	 */
//	@Cacheable(value="nearestAirport", key="#airport.latAndLong")
	@Override
	public NearByAirport getAirport(Location location) {
		Airport closestAirport = getClosestAirport(location);
		if (null == closestAirport) {
			throw new AirportNotFoundException(String.format(
					"No nearest airport found for provided co-ordinates. Latitude: %s, longitude: %s",
					location.getCoordinate().getLatitude(), location.getCoordinate().getLongitude()));
		}
		return new NearByAirport(closestAirport, "This is a dummy description.");
	}
	
	/**
	 * Gets the closest airport.
	 *
	 * @param location the airport
	 * @return the closest airport
	 */
	private Airport getClosestAirport(Location location) {
		List<Airport> airports = csvReader.getLocationListFromCsv();
		Airport closestAirport = airports.stream()
				.min(Comparator.comparingDouble(airportCsv -> airportCsv.distanceTo(location)))
				.get();
		LOG.debug("Closest airport: {}", closestAirport);

		// for (Airport airportCsv : airports) {
		// double distance = airportCsv.distanceTo(airport);
		// if (smallestDistance == -1 || distance < smallestDistance) {
		// closestAirport = airportCsv;
		// smallestDistance = distance;
		// }
		// }
		return closestAirport;
	}

}
