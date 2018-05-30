package com.jetblue.api.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
 
@Documented
@Constraint(validatedBy = LengthUnitEnumerationValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, PARAMETER, CONSTRUCTOR })
@Retention(RUNTIME)
public @interface LengthUnitEnumeration {

	String message() default "Passed lenght unit is not allowed. Allowed values: KILOMETER or MILES";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	Class<? extends Enum<?>> enumClass();
}
