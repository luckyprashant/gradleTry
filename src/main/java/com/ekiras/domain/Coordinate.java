package com.ekiras.domain;

public class Coordinate {
	
	private Long latitude;
	private Long longitude;
	
	public Coordinate(Long latitude, Long longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Long getLatitude() {
		return latitude;
	}
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}
	public Long getLongitude() {
		return longitude;
	}
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	
	

}
