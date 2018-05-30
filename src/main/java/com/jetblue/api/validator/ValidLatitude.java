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
@javax.validation.Constraint(validatedBy = { LatitudeConstraintValidator.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@NotNull(message = "Latitude cannot be null.")
public @interface ValidLatitude {

	/**
	 * Message.
	 *
	 * @return the string
	 */
	String message() default "Passed latitude is not valid.";
    
    /**
     * Groups.
     *
     * @return the class[]
     */
    Class<?>[] groups() default {};
    
    /**
     * Payload.
     *
     * @return the class<? extends payload>[]
     */
    Class<? extends Payload>[] payload() default {};
}
