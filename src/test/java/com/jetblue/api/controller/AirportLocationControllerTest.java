package com.jetblue.api.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.jetblue.api.domain.Airport;
import com.jetblue.api.domain.Coordinate;
import com.jetblue.api.domain.Location;
import com.jetblue.api.domain.NearByAirport;
import com.jetblue.api.service.impl.AirportLocatorService;

@RunWith(MockitoJUnitRunner.class)
public class AirportLocationControllerTest {

	@InjectMocks
	public AirportLocationController airportLocationController;
	
	@Mock
	private AirportLocatorService airportLocatorServiceMock;
	
	@Mock 
	private BindingResult bindingResultMock;
	
	private final static String AIRPORT_NAME = "Dummy name";
	private final static String AIRPORT_CODE = "Dummy code";
	private final static String AIRPORT_CITY = "Dummy city";
	private final static String AIRPORT_STATE = "Dummy state";
	private final static String AIRPORT_COUNTRY = "Dummy country code";
	private final static Double LATITUDE = 35.0;
	private final static Double LONGITUDE = 76.8;
	@Test
	public void testAirportFetchSuccessful() {
		when(airportLocatorServiceMock.getAirport(any(Location.class))).thenReturn(new NearByAirport(new Airport(new Coordinate(LATITUDE, LONGITUDE), AIRPORT_NAME, AIRPORT_CODE, AIRPORT_CITY, AIRPORT_STATE, AIRPORT_COUNTRY), "Dummy description"));
		when(bindingResultMock.hasErrors()).thenReturn(false);
		ResponseEntity<?> response = airportLocationController.getAirport(new Location(), bindingResultMock);
		NearByAirport nearByAirport = (NearByAirport) response.getBody();
		assertEquals("Name is not as expected", AIRPORT_NAME, nearByAirport.getAirport().getName());
		assertEquals("Code is not as expected", AIRPORT_CODE, nearByAirport.getAirport().getCode());
		assertEquals("City is not as expected", AIRPORT_CITY, nearByAirport.getAirport().getCity());
		assertEquals("State is not as expected", AIRPORT_STATE, nearByAirport.getAirport().getState());
		assertEquals("Country is not as expected", AIRPORT_COUNTRY, nearByAirport.getAirport().getCountryCode());
		assertEquals("Latitude is not as expected", LATITUDE, nearByAirport.getAirport().getCoordinate().getLatitude());
		assertEquals("Longitude is not as expected", LONGITUDE, nearByAirport.getAirport().getCoordinate().getLongitude());
		verify(airportLocatorServiceMock).getAirport(Mockito.any(Location.class));
		verify(bindingResultMock).hasErrors();
		verifyNoMoreInteractions(airportLocatorServiceMock, bindingResultMock);
	}
	
	@Test
	public void testValidationError() {
		
	}
	
}
