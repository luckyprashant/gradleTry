package com.jetblue.api.domain;

import javax.validation.constraints.NotNull;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class Coordinate.
 */
public class Coordinate {

	@NotNull(message = "Latitude cannot be null.")
	// @Pattern(regexp = "^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?)", message = "Latitude validation error.")
	private Long latitude;

	@NotNull(message = "Longitude cannot be null.")
	// @Pattern(regexp = "\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$", message = "Longitude validation error.")
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
	
	@Override
	public String toString() {
		JSONObject coordinateJson = new JSONObject();
		try {
			coordinateJson.put("latitude", this.latitude);
			coordinateJson.put("longitude", this.longitude);
		} catch (JSONException e) {
			LOG.error("Error in forming json for co-ordinate object. Latitude: {}, Longitude: {}", this.latitude, this.longitude);
		}
		return coordinateJson.toString();
	}


}
