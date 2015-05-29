package com.synisys.excaptions.api;

import com.synisys.excaptions.exceptions.LowBalanceException;

/**
 * Created by arpine on 5/28/15.
 */
public class Account {
	private Customer customer;
	private double balance;

	public Account(String firstName, String lastName, String idCardNumber) {
		this.customer = new Customer(firstName, lastName, idCardNumber);
		this.balance = 0;

	}

	/**
	 * The account balance has been returned
	 */
	public double getBalance() {
		return (balance);
	}

	/**
	 * @param amount The balance has been increased by the amount.
	 */
	public void increase(double amount) {
		balance += amount;
	}

	/**
	 * The balance has been decreased by the amount.
	 *
	 * @param amount
	 * @throws com.synisys.excaptions.exceptions.LowBalanceException throw new exception when Not enough money in account.
	 */
	public void decrease(double amount) throws LowBalanceException {
		if (amount <= balance) {
			balance -= amount;
		} else {
			throw new LowBalanceException();
		}

	}


}
