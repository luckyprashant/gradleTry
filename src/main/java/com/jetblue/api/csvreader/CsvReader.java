package com.jetblue.api.csvreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.jetblue.api.domain.Airport;

/**
 * The Class CsvReader.
 */
@Component
public class CsvReader {

	@Autowired
	private  ResourceLoader resourceLoader;
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	private List<Airport> airportList = new ArrayList<>();
	
	/**
	 * This methods reads and create list of airports from csv file.
	 */
	@PostConstruct
	public void init() {
		BufferedReader fileReader = null;
		try {
			Resource resource = resourceLoader.getResource("classpath:JetBlue_Airports.csv");
			fileReader = new BufferedReader(new FileReader(resource.getFile()));
			airportList = CsvReaderUtil.formAirportList(fileReader);
			LOG.info("Loaded data from csv file on startup, total airports: {}", airportList.size());
		} catch (Exception e) {
			LOG.error("Exception: ", e);
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				LOG.error("Exception while closing csv file, exception: ", e);
			}
		}
	}

	/**
	 * Gets the location list from csv.
	 *
	 * @return the location list from csv
	 */
	public  List<Airport> getLocationListFromCsv() {
		return this.airportList;
	}
}
