package com.jetblue.api.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.jetblue.api.service.impl.AirportLocatorService;

@RunWith(MockitoJUnitRunner.class)
public class AirportLocationControllerTest {

	@InjectMocks
	public AirportLocationController airportLocationController;
	
	@Mock
	private AirportLocatorService airportLocatorService;
	
	@Test
	public void testAirportFetchSuccessful() {
		
	}
	
	@Test
	public void testAirportFetchNotFound() {
		
	}
	
	@Test
	public void testAirportFetchBadRequest() {
		
	}
}
