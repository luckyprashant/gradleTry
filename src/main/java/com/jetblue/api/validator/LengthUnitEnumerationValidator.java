package com.jetblue.api.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The Class LengthUnitEnumerationValidator.
 */
public class LengthUnitEnumerationValidator implements ConstraintValidator<LengthUnitEnumeration, String> {

	private Set<String> AVAILABLE_ENUM_LENGTH_UNIT;

	/**
	 * Gets the names set.
	 *
	 * @param e the e
	 * @return the names set
	 */
	public static Set<String> getNamesSet(Class<? extends Enum<?>> e) {
		Enum<?>[] enums = e.getEnumConstants();
		String[] names = new String[enums.length];
		for (int i = 0; i < enums.length; i++) {
			names[i] = enums[i].name();
		}
		Set<String> mySet = new HashSet<String>(Arrays.asList(names));
		return mySet;
	}

	/* (non-Javadoc)
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
	 */
	@Override
	public void initialize(LengthUnitEnumeration stringEnumeration) {
		Class<? extends Enum<?>> enumSelected = stringEnumeration.enumClass();
		AVAILABLE_ENUM_LENGTH_UNIT = getNamesSet(enumSelected);
	}

	/* (non-Javadoc)
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		} else {
			return AVAILABLE_ENUM_LENGTH_UNIT.contains(value);
		}
	}

}