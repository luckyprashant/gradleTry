package com.jetblue.api.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 * The Class Person.
 */
public class Person {

	@Size(min = 1, max = 20, message = "Firstname not valid.")
	private String firstName;

	@Size(min = 1, max = 20, message = "Lastname not valid.")
	private String lastName;

	@Size(min = 6, max = 20, message = "Phone number not valid.") // We can also add a custom phone validation annotation
	private String phoneNumber;

	@Email(message = "Email is not valid.")
	private String email;

	@Size(min = 1, max = 20, message = "Type not valid.") // This can be validated via enum is some constants values are present
	private String type;

	/**
	 * Instantiates a new person.
	 */
	public Person() {

	}

	/**
	 * Instantiates a new person.
	 *
	 * @param firstName
	 *            the first name
	 * @param lastName
	 *            the last name
	 * @param phoneNumber
	 *            the phone number
	 * @param email
	 *            the email
	 * @param type
	 *            the type
	 */
	public Person(String firstName, String lastName, String phoneNumber, String email, String type) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.type = type;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber
	 *            the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", type=" + type + "]";
	}

}
