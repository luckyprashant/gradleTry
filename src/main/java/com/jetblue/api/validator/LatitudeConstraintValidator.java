package com.jetblue.api.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The Class LatitudeConstraintValidator.
 */
public class LatitudeConstraintValidator implements ConstraintValidator<ValidLatitude, Long> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.
	 * Annotation)
	 */
	@Override
	public void initialize(final ValidLatitude constraintAnnotation) {
		// Not needed
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(final Long latitude, final ConstraintValidatorContext context) {
		Pattern latitudePattern = Pattern.compile("^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?)");
//		Pattern longitudePattern = Pattern.compile("\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$");
		Matcher matcher = latitudePattern.matcher(Long.toString(latitude));
		return matcher.matches();
	}

}
