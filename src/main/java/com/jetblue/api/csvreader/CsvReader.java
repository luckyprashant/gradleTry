package com.jetblue.api.csvreader;

import static com.jetblue.api.constant.AppConstant.CSV_LATITUDE_IDX;
import static com.jetblue.api.constant.AppConstant.CSV_LONGITUDE_IDX;
import static com.jetblue.api.constant.AppConstant.CSV_AIRPORT_CITY_IDX;
import static com.jetblue.api.constant.AppConstant.CSV_AIRPORT_CODE_IDX;
import static com.jetblue.api.constant.AppConstant.CSV_AIRPORT_COUNTRY_IDX;
import static com.jetblue.api.constant.AppConstant.CSV_AIRPORT_NAME_IDX;
import static com.jetblue.api.constant.AppConstant.CSV_AIRPORT_STATE_IDX;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.jetblue.api.domain.Airport;
import com.jetblue.api.domain.Coordinate;

/**
 * The Class CsvReader.
 */
@Component
public class CsvReader {

	@Autowired
	private  ResourceLoader resourceLoader;
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/**
	 * Gets the location list from csv.
	 *
	 * @return the location list from csv
	 */
//	@Cacheable(value="airportCsv")
	public  List<Airport> getLocationListFromCsv() {
		List<Airport> airportList = new ArrayList<Airport>();
		BufferedReader fileReader = null;
		try {
			String line = "";
			Resource resource = resourceLoader.getResource("classpath:JetBlue_Airports.csv");
			fileReader = new BufferedReader(new FileReader(resource.getFile()));
			line = fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.replaceAll("^\"|\"$", "").split(",");
				if (tokens.length > 0) {
					Coordinate coordinate = new Coordinate(Long.parseLong(tokens[CSV_LATITUDE_IDX]), Long.parseLong(tokens[CSV_LONGITUDE_IDX]));
					Airport airport = new Airport(coordinate, tokens[CSV_AIRPORT_NAME_IDX], tokens[CSV_AIRPORT_CODE_IDX],
							tokens[CSV_AIRPORT_CITY_IDX], tokens[CSV_AIRPORT_STATE_IDX], tokens[CSV_AIRPORT_COUNTRY_IDX]);
					airportList.add(airport);
				}
			}
		} catch (Exception e) {
			LOG.error("Exception: ", e);
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				LOG.error("Exception: ", e);
			}
		}
		return airportList;
	}
}
