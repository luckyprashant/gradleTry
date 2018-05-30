package com.jetblue.api.validator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Payload;
import javax.validation.constraints.NotNull;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;

/**
 * The Interface ValidLatitude.
 */
@javax.validation.Constraint(validatedBy = { LongitudeConstraintValidator.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@NotNull(message = "Longitude cannot be null.")
public @interface ValidLongitude {

	String message() default "Passed longitude is not valid.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
