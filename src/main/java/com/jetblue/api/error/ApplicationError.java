package com.jetblue.api.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class ApplicationError.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationError {

	private Date timestamp;
	
	private String message;
	
	private String details;
	
	private List<ErrorDetail> errorDetails;
	

	/**
	 * Instantiates a new application error.
	 *
	 * @param timestamp the timestamp
	 * @param message the message
	 * @param details the details
	 */
	public ApplicationError(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public ApplicationError(List<ErrorDetail> errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	public ApplicationError() {
		
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the details.
	 *
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * Sets the details.
	 *
	 * @param details the new details
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	
	/**
	 * Gets the error list.
	 *
	 * @return the error list
	 */
	public List<ErrorDetail> getErrorList() {
		if(this.errorDetails == null) {
			this.errorDetails = new ArrayList<>();
		}
		return this.errorDetails;
	}
	
	/**
	 * Adds the error.
	 *
	 * @param errorDetail the error
	 */
	public void addError(final ErrorDetail errorDetail) {
		if(this.errorDetails == null) {
			this.errorDetails = new ArrayList<>();
		}
		this.errorDetails.add(errorDetail);
	}

}
