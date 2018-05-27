package com.jetblue.api.error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 * The Class ErrorHelper.
 */
@Component
public class ErrorHelper {

	/**
	 * Gets the errors.
	 *
	 * @param errorDetail the error detail
	 * @return the errors
	 */
	public ApplicationError getErrors(final ErrorDetail errorDetail) {
        List<ErrorDetail> errorDetails = new ArrayList<>();
        errorDetails.add(errorDetail);
        return new ApplicationError(errorDetails);
    }

	
	/**
	 * Form application error.
	 *
	 * @param allErrors the all errors
	 * @return the application error
	 */
	public ApplicationError formApplicationError(List<ObjectError> allErrors) {
		ApplicationError applicationError = new ApplicationError();
		for(ObjectError error: allErrors) {
			FieldError fieldError = (FieldError) error;
			ErrorDetail errorDetail= new ErrorDetail(fieldError.getField(), fieldError.getDefaultMessage());
			applicationError.addError(errorDetail);
		}
		return applicationError;
	}
}
