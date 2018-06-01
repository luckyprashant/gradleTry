package com.jetblue.api.mask;

import java.util.Collection;
import java.util.Collections;
import java.util.Properties;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;

/**
 * The Class ApplicationMaskConfig.
 */
public class ApplicationMaskConfig {

	private final boolean dumpPayLoad;
	
	private final Collection<String> masks = new TreeSet<String>();
	
	private final static String MASKING_KEYWORD = "jsonmask.configuration.mask.";
	

	/**
	 * Instantiates a new application mask config.
	 *
	 * @param jsonProperty the json property
	 */
	public ApplicationMaskConfig(Properties jsonProperty) {
		dumpPayLoad = Boolean.parseBoolean(jsonProperty.getProperty("jsonmask.configuration.dumpPayload", "true"));
		masks.addAll(jsonProperty.stringPropertyNames()
				.stream()
				.filter(name -> StringUtils.startsWith(name, MASKING_KEYWORD))
				.map(name -> jsonProperty.getProperty(name))
				.collect(Collectors.toList()));
	}

	/**
	 * Checks if is dump payload.
	 *
	 * @return true, if is dump payload
	 */
	public boolean isDumpPayload() {
		return dumpPayLoad;
	}

	/**
	 * Gets the masks.
	 *
	 * @return the masks
	 */
	public Iterable<String> getMasks() {
		return Collections.unmodifiableCollection(masks);
	}
	
}
