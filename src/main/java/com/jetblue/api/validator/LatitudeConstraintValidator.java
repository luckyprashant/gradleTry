package com.jetblue.api.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

/**
 * The Class LatitudeConstraintValidator.
 */
@Component
public class LatitudeConstraintValidator implements ConstraintValidator<ValidLatitude, Double> {

	private static final String LATITUDE_PATTERN="^(\\+|-)?(?:90(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\.[0-9]{1,6})?))$";
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.
	 * Annotation)
	 */
	@Override
	public void initialize(final ValidLatitude validLatitude) {
		// Not needed.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */

	@Override
	public boolean isValid(final Double latitude, final ConstraintValidatorContext context) {
		if(null == latitude) {
			return false;
		}
		Pattern latitudePattern = Pattern.compile(LATITUDE_PATTERN);
		Matcher matcher = latitudePattern.matcher(Double.toString(latitude));
		return matcher.matches();
	}

}
