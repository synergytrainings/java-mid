package com.synisys.excaptions.api;

/**
 * Created by arpine on 5/28/15.
 */
public class Customer {
	private String firstName;
	private String lastName;
	private String idCardNumber;

	public Customer(String firstName, String lastName, String idCardNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idCardNumber = idCardNumber;
	}

	/**
	 * Getter for customer first name
	 *
	 * @return The first name of customer
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 *
	 * Getter for customer last name
	 *
	 * @return The last name of customer
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Getter for customer idCardNumber
	 *
	 * @return The idCardNumber of customer
	 */
	public String getIdCardNumber() {
		return idCardNumber;
	}

}
