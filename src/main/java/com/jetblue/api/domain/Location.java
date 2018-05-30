package com.jetblue.api.domain;

import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jetblue.api.constant.AppEnum;
import com.jetblue.api.validator.LengthUnitEnumeration;

/**
 * The Class Location.
 */
public class Location {

	private String anyValue;

	private Double maxDistance;
	
	@LengthUnitEnumeration(enumClass = AppEnum.LenghtUnit.class)
	private String unit;
	
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
	 * Gets the max distance.
	 *
	 * @return the max distance
	 */
	public Double getMaxDistance() {
		return maxDistance;
	}

	/**
	 * Sets the max distance.
	 *
	 * @param maxDistance the new max distance
	 */
	public void setMaxDistance(Double maxDistance) {
		this.maxDistance = maxDistance;
	}

	/**
	 * Gets the unit.
	 *
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * Sets the unit.
	 *
	 * @param unit the new unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
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
			if(null != this.coordinate) {
				locationJson.put("latitude", this.coordinate.getLatitude());
				locationJson.put("longitude", this.coordinate.getLongitude());
			}
		} catch (JSONException e) {
			LOG.error("Error in forming json for location object. Coordinate: {}", this.coordinate);
		}
		return locationJson.toString();
	}
}
