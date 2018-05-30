package com.jetblue.api.constant;

import static com.jetblue.api.constant.ErrorKeyConstants.ERROR_AIRPORT_NOT_FOUND;
import static com.jetblue.api.constant.ErrorKeyConstants.ERROR_TECHNICAL;
import static com.jetblue.api.constant.ErrorKeyConstants.ERROR_VALIDATION;
import static com.jetblue.api.constant.ErrorKeyConstants.ERROR_AIRPORT_NOT_IN_RANGE;

/**
 * The Class AppEnum.
 */
public class AppEnum {

	/**
	 * The Enum LenghtUnit.
	 */
	public enum LenghtUnit {

		MILES("mls"), 
		KILOMETER("km");

		private String lgthUnit;

		/**
		 * Instantiates a new lenght unit.
		 *
		 * @param lgthUnit the lgth unit
		 */
		private LenghtUnit(String lgthUnit) {
			this. lgthUnit = lgthUnit;
		}

		/**
		 * Gets the lgth unit.
		 *
		 * @return the lgth unit
		 */
		public String getLgthUnit() {
			return lgthUnit;
		}

	}
	
	/**
	 * The Enum AnyEnum.
	 */
	public enum ErrorCode {

		VALIDATION_COORDINATES("001", "Validation for provided inputs failed", ERROR_VALIDATION),
		
		TECHINCAL("002", "Technical error occurred, please try after some time.", ERROR_TECHNICAL),
		
		VALIDATION("003", "Enter co-ordinates are not valid.", ERROR_VALIDATION),
		
		AIRPORT_NOT_FOUND("004", "Airport not found", ERROR_AIRPORT_NOT_FOUND),
		
		AIRPORT_NOT_IN_RANGE("005", "No airport found withing given range", ERROR_AIRPORT_NOT_IN_RANGE);;

		private String errorCode;
		
		private String errorDescription;
		
		private String errorMessageKey;

		/**
		 * Instantiates a new error code.
		 *
		 * @param errorCode the error code
		 * @param errorDescription the error description
		 * @param errorMessageKey the error message key
		 */
		private ErrorCode(final String errorCode, final String errorDescription, final String errorMessageKey) {
			this.errorCode = errorCode;
			this.errorDescription = errorDescription;
			this.errorMessageKey = errorMessageKey;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String toString() {
			return errorCode + ":" + errorDescription;
		}

		/**
		 * Gets the error code.
		 *
		 * @return the errorCode
		 */
		public String getErrorCode() {
			return this.errorCode;
		}

		/**
		 * Gets the error description.
		 *
		 * @return the errorDescription
		 */
		public String getErrorDescription() {
			return this.errorDescription;
		}

		/**
		 * Gets the error message key.
		 *
		 * @return the errorMessageKey
		 */
		public String getErrorMessageKey() {
			return errorMessageKey;
		}
	}
	
}
