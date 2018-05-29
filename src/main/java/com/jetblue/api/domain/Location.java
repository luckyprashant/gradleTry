package com.jetblue.api.domain;

// TODO: Auto-generated Javadoc
/**
 * The Class Location.
 */
public class Location {

	private String name;

	private long longitude;

	private long latitude;

	/**
	 * Instantiates a new location.
	 *
	 * @param name
	 *            the name
	 * @param latitude
	 *            the latitude
	 * @param longitude
	 *            the longitude
	 */
	public Location(String name, long latitude, long longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * Instantiates a new location form {@link Airport} object.
	 *
	 * @param aiportCoordinate the aiport coordinate
	 */
	public Location(Airport aiportCoordinate) {
		this.name = aiportCoordinate.getName();
		this.latitude = aiportCoordinate.getCoordinate().getLatitude();
		this.longitude = aiportCoordinate.getCoordinate().getLongitude();
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
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
	public long getLongitude() {
		return longitude;
	}

	/**
	 * Sets the longitude.
	 *
	 * @param longitude
	 *            the new longitude
	 */
	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	/**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	public long getLatitude() {
		return latitude;
	}

	/**
	 * Sets the latitude.
	 *
	 * @param latitude
	 *            the new latitude
	 */
	public void setLatitude(long latitude) {
		this.latitude = latitude;
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
		double lat1 = Math.toRadians(this.latitude);
		double lon1 = Math.toRadians(this.longitude);
		double lat2 = Math.toRadians(location.getLatitude());
		double lon2 = Math.toRadians(location.getLongitude());

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	// return string representation of this point
	public String toString() {
		return name + " (" + latitude + ", " + longitude + ")";
	}
}
