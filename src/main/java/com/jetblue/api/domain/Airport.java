package com.jetblue.api.domain;

import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class Airport.
 */
public class Airport {
	
	private String name;
	
	private String code;
	
	@Valid
	private Coordinate coordinate;
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Instantiates a new airport.
	 *
	 * @param coordinate the coordinate
	 * @param name the name
	 * @param code the code
	 */
	public Airport(Coordinate coordinate, String name, String code) {
		this.coordinate = coordinate;
		this.name = name;
		this.code = code;
	}
	
	/**
	 * Instantiates a new airport.
	 */
	public Airport() {
		
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
