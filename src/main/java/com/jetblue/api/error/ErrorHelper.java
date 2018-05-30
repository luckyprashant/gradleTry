package com.jetblue.api.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.jetblue.api.constant.AppEnum;

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
	 * Sets the errors.
	 *
	 * @param applicationError the application error
	 * @param errorDetail the error detail
	 * @return the application error
	 */
	public ApplicationError setErrors(final ApplicationError applicationError, final ErrorDetail errorDetail) {
        List<ErrorDetail> errorDetails = new ArrayList<>();
        errorDetails.add(errorDetail);
        if(null == applicationError) {
        	return new ApplicationError(errorDetails);	
        }
        applicationError.addError(errorDetail);
        return applicationError;
    }
	
	/**
	 * Form application error.
	 *
	 * @param allErrors the all errors
	 * @return the application error
	 */
	public ApplicationError formApplicationError(List<ObjectError> allErrors) {
		ApplicationError applicationError = new ApplicationError();
		applicationError.setTimestamp(new Date());
		applicationError.setDetails("This is a dummy details");
		applicationError.setMessage(AppEnum.ErrorCode.VALIDATION_COORDINATES.getErrorMessageKey());
		for(ObjectError error: allErrors) {
			FieldError fieldError = (FieldError) error;
			ErrorDetail errorDetail= new ErrorDetail(AppEnum.ErrorCode.VALIDATION_COORDINATES.getErrorCode(), fieldError.getField(), fieldError.getDefaultMessage());
			applicationError.addError(errorDetail);
		}
		return applicationError;
	}
}
