package com.jetblue.api.csvreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.jetblue.api.domain.Location;

/**
 * The Class CsvReader.
 */
@Component
public class CsvReader {

	private static final int LOCATION_NAME_IDX = 0;
	
	private static final int LOCATION_LATITUDE_IDX = 1;
	
	private static final int LOCATION_LONGITUDE_IDX = 2;
	
	@Autowired
	private  ResourceLoader resourceLoader;

	/**
	 * Gets the location list from csv.
	 *
	 * @return the location list from csv
	 */
	@Cacheable(value="airportCsv")
	public  List<Location> getLocationListFromCsv() {
		List<Location> locationList = new ArrayList<Location>();
		BufferedReader fileReader = null;
		try {
			String line = "";
			Resource resource = resourceLoader.getResource("classpath:locations.csv");
			fileReader = new BufferedReader(new FileReader(resource.getFile()));
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.replaceAll("^\"|\"$", "").split(",");
				if (tokens.length > 0) {
//					Location customer = new Location(tokens[LOCATION_NAME_IDX], Long.parseLong(tokens[LOCATION_LATITUDE_IDX]),
//							Long.parseLong(tokens[LOCATION_LONGITUDE_IDX]));
					Location location = new Location("test", 23l, 12l);
					locationList.add(location);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return locationList;
	}
}
