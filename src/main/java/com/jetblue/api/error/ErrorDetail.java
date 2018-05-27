package com.jetblue.api.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class Error.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDetail {

	private String code;
	
	private String field;
	
	private String description;
	
	/**
	 * Instantiates a new error.
	 *
	 * @param code the code
	 * @param field the field
	 * @param description the description
	 */
	public ErrorDetail(String code, String field, String description) {
		this.code = code;
		this.field = field;
		this.description = description;
	}
	
	/**
	 * Instantiates a new error detail.
	 *
	 * @param field the field
	 * @param description the description
	 */
	public ErrorDetail(String field, String description) {
		this.field = field;
		this.description = description;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the field.
	 *
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * Sets the field.
	 *
	 * @param field the new field
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
