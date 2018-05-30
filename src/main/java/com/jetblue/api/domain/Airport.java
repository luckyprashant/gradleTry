package com.jetblue.api.domain;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class Airport.
 */
	
public class Airport {
	private String name;
	
	private String code;
	
	private String city;
	
	private String state;
	
	private String countryCode;
	
	private Coordinate coordinate;
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Instantiates a new airport.
	 *
	 * @param coordinate the coordinate
	 * @param name the name
	 * @param code the code
	 * @param city the city
	 * @param state the state
	 * @param countryCode the country code
	 */
	public Airport(Coordinate coordinate, String name, String code, String city, String state, String countryCode) {
		this.coordinate = coordinate;
		this.name = name;
		this.code = code;
		this.city = city;
		this.state = state;
		this.countryCode = countryCode;
	}
	
	/**
	 * Instantiates a new airport.
	 */
	public Airport() {
		
	}

	/**
	 * Instantiates a new airport object from {@link Location} object.
	 *
	 * @param location the location
	 */
	public Airport(Location location) {
//		this.coordinate = new Coordinate(location.getLatitude(), location.getLongitude());
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the coordinate.
	 *
	 * @return the coordinate
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}

	/**
	 * Sets the coordinate.
	 *
	 * @param coordinate the new coordinate
	 */
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	
	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the country code.
	 *
	 * @return the country code
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Sets the country code.
	 *
	 * @param countryCode the new country code
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Distance.
	 *
	 * @param lat1 the lat 1
	 * @param lon1 the lon 1
	 * @param lat2 the lat 2
	 * @param lon2 the lon 2
	 * @param unit the unit
	 * @return the double
	 */
	@JsonIgnore
	public double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == "K") {
			dist = dist * 1.609344;
		} else if (unit == "N") {
			dist = dist * 0.8684;
		}
		return (dist);
	}
	
	/**
	 * Distance to.
	 *
	 * @param airport the airport
	 * @return the double
	 */
	// measured in statute miles
	public double distanceTo(Location location) {
		double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
		double latitude = Math.toRadians(this.coordinate.getLatitude());
		double longitude = Math.toRadians(this.coordinate.getLongitude());
		double airportLat = Math.toRadians(location.getCoordinate().getLatitude());
		double airportLong = Math.toRadians(location.getCoordinate().getLongitude());

		// great circle distance in radians, using law of cosines formula
		double angle = Math.acos(Math.sin(latitude) * Math.sin(airportLat)
				+ Math.cos(latitude) * Math.cos(airportLat) * Math.cos(longitude - airportLong));

		// each degree on a great circle of Earth is 60 nautical miles
		double nauticalMiles = 60 * Math.toDegrees(angle);
		double statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
		return statuteMiles;
	}

	/**
	 * This function converts decimal degrees to radians .
	 *
	 * @param deg
	 *            the deg
	 * @return the double
	 */
	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/**
	 * This function converts radians to decimal degrees.
	 *
	 * @param rad
	 *            the rad
	 * @return the double
	 */
	private double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
	 /* (non-Javadoc)
 	 * @see java.lang.Object#toString()
 	 */
 	@Override
	public String toString() {
		JSONObject airportJson = new JSONObject();
		try {
			airportJson.put("code", this.code);
			airportJson.put("name", this.name);
			airportJson.put("coordinate", this.coordinate);
		} catch (JSONException e) {
			LOG.error("Error in forming json for airport object. Code: {}, name: {}, coordinate: {}", this.code, this.name, this.coordinate);
		}
		return airportJson.toString();
	}

}
