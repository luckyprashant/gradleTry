package com.jetblue.api.domain;

/**
 * The Class NearByAirport.
 */
public class NearByAirport {

	private Airport airport;
	
	private String description;
	
	/**
	 * Instantiates a new near by airport.
	 *
	 * @param airport the airport
	 * @param description the description
	 */
	public NearByAirport(Airport airport, String description) {
		this.airport = airport;
		this.description = description;
	}

	/**
	 * Gets the airport.
	 *
	 * @return the airport
	 */
	public Airport getAirport() {
		return airport;
	}

	/**
	 * Sets the airport.
	 *
	 * @param airport the new airport
	 */
	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
