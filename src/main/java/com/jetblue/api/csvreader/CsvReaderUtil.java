package com.jetblue.api.csvreader;

import static com.jetblue.api.constant.AppConstant.CSV_AIRPORT_CITY_IDX;
import static com.jetblue.api.constant.AppConstant.CSV_AIRPORT_CODE_IDX;
import static com.jetblue.api.constant.AppConstant.CSV_AIRPORT_COUNTRY_IDX;
import static com.jetblue.api.constant.AppConstant.CSV_AIRPORT_NAME_IDX;
import static com.jetblue.api.constant.AppConstant.CSV_AIRPORT_STATE_IDX;
import static com.jetblue.api.constant.AppConstant.CSV_LATITUDE_IDX;
import static com.jetblue.api.constant.AppConstant.CSV_LONGITUDE_IDX;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jetblue.api.domain.Airport;
import com.jetblue.api.domain.Coordinate;

/**
 * The Class CsvReaderUtil.
 */
public final class CsvReaderUtil {


	/**
	 * Form airport list.
	 *
	 * @param fileReader
	 *            the file reader
	 * @return the list
	 * @throws IOException
	 */
	public static List<Airport> formAirportList(BufferedReader fileReader) throws IOException {
		List<Airport> airportList = new ArrayList<>();
		String line = fileReader.readLine();
		while ((line = fileReader.readLine()) != null) {
			String[] tokens = line.replaceAll("^\"|\"$", "").split(",");
			if (tokens.length > 0) {
				Coordinate coordinate = new Coordinate(Double.parseDouble(tokens[CSV_LATITUDE_IDX]), Double.parseDouble(tokens[CSV_LONGITUDE_IDX]));
				Airport airport = new Airport(coordinate, tokens[CSV_AIRPORT_NAME_IDX], 
														  tokens[CSV_AIRPORT_CODE_IDX],
														  tokens[CSV_AIRPORT_CITY_IDX], 
														  tokens[CSV_AIRPORT_STATE_IDX], 
														  tokens[CSV_AIRPORT_COUNTRY_IDX]);
				airportList.add(airport);
			}
		}
		return airportList;
	}

}
