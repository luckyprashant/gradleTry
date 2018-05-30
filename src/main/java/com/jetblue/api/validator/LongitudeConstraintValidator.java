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
public class LongitudeConstraintValidator implements ConstraintValidator<ValidLongitude, Double> {

	private static final String LONGITUDE_PATTERN="^(\\+|-)?(?:180(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\.[0-9]{1,6})?))$";
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.
	 * Annotation)
	 */
	@Override
	public void initialize(final ValidLongitude validLongitude) {
		// No need to initialize.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(final Double longitude, final ConstraintValidatorContext context) {
		if(null == longitude) {
			return false;
		}
		Pattern longitudePattern = Pattern.compile(LONGITUDE_PATTERN);
		Matcher matcher = longitudePattern.matcher(Double.toString(longitude));
		return matcher.matches();
	}

}
