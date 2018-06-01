package com.jetblue.api.service.impl;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jetblue.api.domain.Person;

/**
 * The Interface IMaskService.
 */
public interface IMaskService {

	/**
	 * Gets the mask response.
	 *
	 * @param person the person
	 * @return the mask response
	 * @throws JsonProcessingException 
	 * @throws IOException 
	 */
	public Person getMaskResponse(Person person) throws IOException;
}
