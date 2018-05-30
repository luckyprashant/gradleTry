package com.jetblue.api.domain;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jetblue.api.validator.ValidLatitude;
import com.jetblue.api.validator.ValidLongitude;

/**
 * The Class Coordinate.
 */
public class Coordinate {

	@ValidLatitude
	private Long latitude;

	@ValidLongitude
	private Long longitude;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/**
	 * Instantiates a new coordinate.
	 *
	 * @param latitude
	 *            the latitude
	 * @param longitude
	 *            the longitude
	 */
	public Coordinate(Long latitude, Long longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Instantiates a new coordinate.
	 */
	public Coordinate() {

	}

	/**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	public Long getLatitude() {
		return latitude;
	}

	/**
	 * Sets the latitude.
	 *
	 * @param latitude
	 *            the new latitude
	 */
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	/**
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
	public Long getLongitude() {
		return longitude;
	}

	/**
	 * Sets the longitude.
	 *
	 * @param longitude
	 *            the new longitude
	 */
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		JSONObject coordinateJson = new JSONObject();
		try {
			coordinateJson.put("latitude", this.latitude);
			coordinateJson.put("longitude", this.longitude);
		} catch (JSONException e) {
			LOG.error("Error in forming json for co-ordinate object. Latitude: {}, Longitude: {}", this.latitude,
					this.longitude);
		}
		return coordinateJson.toString();
	}

}
