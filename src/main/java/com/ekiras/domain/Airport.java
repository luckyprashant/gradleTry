package com.ekiras.domain;

public class Airport {
	
	private String name;
	private String code;
	private Coordinate coordinate;
	
	
	public Airport(Coordinate coordinate, String name, String code) {
		this.coordinate = coordinate;
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	
	
}
