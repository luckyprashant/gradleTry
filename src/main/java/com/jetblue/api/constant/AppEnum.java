package com.jetblue.api.constant;

import static com.jetblue.api.constant.ErrorKeyConstants.ERROR_TECHNICAL;
import static com.jetblue.api.constant.ErrorKeyConstants.ERROR_AIRPORT_NOT_FOUND;
import static com.jetblue.api.constant.ErrorKeyConstants.ERROR_VALIDATION;
import static com.jetblue.api.constant.ErrorKeyConstants.ERROR_VALIDATION_COORDINATES;

/**
 * The Class AppEnum.
 */
public class AppEnum {

	/**
	 * The Enum AnyEnum.
	 */
	public enum ErrorCode {

		VALIDATION_COORDINATES("001", "Enter co-ordinates are not valid.", ERROR_VALIDATION_COORDINATES),
		TECHINCAL("002", "Technical error occurred, please try after some time.", ERROR_TECHNICAL),
		VALIDATION("003", "Enter co-ordinates are not valid.", ERROR_VALIDATION),
		AIRPORT_NOT_FOUND("004", "Enter co-ordinates are not valid.", ERROR_AIRPORT_NOT_FOUND);

		private String errorCode;
		private String errorDescription;
		private String errorMessageKey;

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
		 * @return the errorCode
		 */
		public String getErrorCode() {
			return this.errorCode;
		}

		/**
		 * @return the errorDescription
		 */
		public String getErrorDescription() {
			return this.errorDescription;
		}

		/**
		 * @return the errorMessageKey
		 */
		public String getErrorMessageKey() {
			return errorMessageKey;
		}
	}
}
