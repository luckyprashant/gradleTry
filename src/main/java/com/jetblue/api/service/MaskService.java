package com.jetblue.api.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jetblue.api.domain.Person;
import com.jetblue.api.mask.ApplicationMasker;
import com.jetblue.api.service.impl.IMaskService;

@Service
public class MaskService implements IMaskService{

	@Autowired
	private ApplicationMasker masker;
	
	@Override
	public Person getMaskResponse(Person person) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String personInString = mapper.writeValueAsString(person);
		String maskedPersonInString = masker.mask(personInString);
		Person maskedPerson = mapper.readValue(maskedPersonInString, Person.class);
		return maskedPerson;
	}

}
