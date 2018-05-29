package com.jetblue.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jetblue.api.csvreader.CsvReader;
import com.jetblue.api.domain.Airport;
import com.jetblue.api.domain.Location;
import com.jetblue.api.domain.NearByAirport;
import com.jetblue.api.exception.AirportNotFoundException;

/**
 * The Class AirportLocatorService.
 */
@Service
public class AirportLocatorService {

	
	@Autowired
	private CsvReader csvReader;
	/**
	 * Gets the airport.
	 *
	 * @param airport
	 *            the aiport coordinate
	 * @return the airport
	 */
	@Cacheable(value="nearestAirport", key="#airport.latAndLong")
	public NearByAirport getAirport(Airport airport) {
		Location currentLocation = new Location(airport);
		Location closestLocation = getClosestLocation(currentLocation);
		if (null == closestLocation) {
			throw new AirportNotFoundException(String.format(
					"No nearest airport found for provided co-ordinates. Latitude: %s, longitude: %s",
					airport.getCoordinate().getLatitude(), airport.getCoordinate().getLongitude()));
		}
		return new NearByAirport(new Airport(currentLocation), "This is a dummy description.");
	}

	/**
	 * Gets the closest location.
	 *
	 * @param currentLocation
	 *            the current location
	 * @return the closest location
	 */
	private Location getClosestLocation(Location currentLocation) {
		Location closestLocation = null;
		double smallestDistance = -1;
		List<Location> locations = csvReader.getLocationListFromCsv();
		for (Location location : locations) {
			double distance = currentLocation.distanceTo(location);
			if (smallestDistance == -1 || distance < smallestDistance) {
				closestLocation = location;
				smallestDistance = distance;
			}
		}
		return closestLocation;
	}


}
