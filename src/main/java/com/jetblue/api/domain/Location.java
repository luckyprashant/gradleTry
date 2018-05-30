package com.jetblue.api.domain;

import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class Location.
 */
public class Location {

	private String anyValue;

	@Valid
	private Coordinate coordinate;
	
	private final static Logger LOG = LoggerFactory.getLogger(Location.class);
	
	/**
	 * Instantiates a new location.
	 *
	 * @param anyValue the any value
	 * @param coordinate the coordinate
	 */
	public Location(String anyValue, Coordinate coordinate) {
		this.anyValue = anyValue;
		this.setCoordinate(coordinate);
	}
	
	/**
	 * Instantiates a new location.
	 */
	public Location() {
		// Default constructor for jackson binding
	}

	
	/**
	 * Distance to.
	 *
	 * @param that
	 *            the that
	 * @return the double
	 */
	// measured in statute miles
	public double distanceTo(Location location) {
		double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
		double lat1 = Math.toRadians(this.coordinate.getLatitude());
		double lon1 = Math.toRadians(this.coordinate.getLongitude());
		double lat2 = Math.toRadians(location.getCoordinate().getLatitude());
		double lon2 = Math.toRadians(location.getCoordinate().getLongitude());

		// great circle distance in radians, using law of cosines formula
		double angle = Math
				.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

		// each degree on a great circle of Earth is 60 nautical miles
		double nauticalMiles = 60 * Math.toDegrees(angle);
		double statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
		return statuteMiles;
	}

	/**
	 * Distance.
	 *
	 * @param lat1
	 *            the lat 1
	 * @param lon1
	 *            the lon 1
	 * @param lat2
	 *            the lat 2
	 * @param lon2
	 *            the lon 2
	 * @param unit
	 *            the unit
	 * @return the double
	 */
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

	
	/**
	 * Gets the any value.
	 *
	 * @return the any value
	 */
	public String getAnyValue() {
		return anyValue;
	}

	/**
	 * Sets the any value.
	 *
	 * @param anyValue the new any value
	 */
	public void setAnyValue(String anyValue) {
		this.anyValue = anyValue;
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
	 * Gets the lat and long.
	 * This is used to create the key for cache generation in {@link AiportLocatorService}
	 *
	 * @return the lat and long
	 */
	@JsonIgnore
	public String getLatAndLong() {
		return Double.toString(this.coordinate.getLatitude()) + Double.toString(this.coordinate.getLongitude());
	}
	
	@Override
	public String toString() {
		JSONObject locationJson = new JSONObject();
		try {
			locationJson.put("latitude", this.coordinate.getLatitude());
			locationJson.put("longitude", this.coordinate.getLongitude());
		} catch (JSONException e) {
			LOG.error("Error in forming json for location object. Coordinate: {}", this.coordinate);
		}
		return locationJson.toString();
	}
}
