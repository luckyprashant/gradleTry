package com.jetblue.api.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The Class LatitudeConstraintValidator.
 */
public class LongitudeConstraintValidator implements ConstraintValidator<ValidLongitude, Long> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.
	 * Annotation)
	 */
	@Override
	public void initialize(final ValidLongitude constraintAnnotation) {
		// Not needed
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(final Long longitude, final ConstraintValidatorContext context) {
		Pattern longitudePattern = Pattern.compile("\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$");
		Matcher matcher = longitudePattern.matcher(Long.toString(longitude));
		return matcher.matches();
	}

}
