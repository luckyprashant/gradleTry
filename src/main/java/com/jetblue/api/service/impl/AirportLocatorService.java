package com.jetblue.api.service.impl;

import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jetblue.api.constant.AppEnum;
import com.jetblue.api.csvreader.CsvReader;
import com.jetblue.api.domain.Airport;
import com.jetblue.api.domain.Location;
import com.jetblue.api.domain.NearByAirport;
import com.jetblue.api.exception.AirportNotFoundException;
import com.jetblue.api.exception.AirportNotInRangeException;
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
	 * @param location
	 *            the location coordinate
	 * @return the airport
	 */
	@Override
	public NearByAirport getAirport(Location location) {
		Airport closestAirport = getClosestAirport(location);
		if (null == closestAirport) {
			throw new AirportNotFoundException(String.format(
					"No nearest airport found for provided co-ordinates. Latitude: %s, longitude: %s",
					location.getCoordinate().getLatitude(), location.getCoordinate().getLongitude()));
		}
		return new NearByAirport(closestAirport,
				String.format("Nearest airport %s is %s %s far.", closestAirport.getName(),
						closestAirport.getDistanceWithLocation(), StringUtils.isBlank(location.getUnit())? AppEnum.LenghtUnit.MILES : location.getUnit()));
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
		if(null == location.getMaxDistance() || isAirportWithinRange(location, closestAirport)) {
			return closestAirport;
		}
		return null;
	}

	/**
	 * Checks if is airport within range.
	 *
	 * @param location the location
	 * @param closestAirport the closest airport
	 * @return true, if is airport within range
	 */
	private boolean isAirportWithinRange(Location location, Airport closestAirport) {
		Double maxDistance = location.getMaxDistance();
		double distanceToAirport = closestAirport.distanceTo(location);
		if(distanceToAirport > maxDistance) {
			LOG.warn("Closet airport ({}) not in range {}", closestAirport, location.getMaxDistance());
			throw new AirportNotInRangeException(String.format("No airport found within provided range of: %s %s", location.getMaxDistance(), location.getUnit()));
		}
		closestAirport.setDistanceWithLocation(distanceToAirport);
		return true;
	}

}
