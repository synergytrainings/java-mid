package com.synisys.excaptions.test;

import com.synisys.excaptions.api.Bank;
import com.synisys.excaptions.exceptions.ExistingCustomerIdException;
import com.synisys.excaptions.exceptions.LowBalanceException;
import com.synisys.excaptions.exceptions.UnknownCustomerIdException;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by arpine on 5/29/15.
 */
public class BankTest {
	private Bank bank;
	private String customerIdCardNumber = "jkj-4556-Hksd";

	/**
	 * Create new dummy bank
	 * ADd new customer
	 *
	 * @throws ExistingCustomerIdException
	 */
	@Before
	public void setUp()
			throws ExistingCustomerIdException {
		this.bank = new Bank("HSBC", "TeryanXXXX", "GFDP-BNM-JFKH");
		bank.createNewAccount(customerIdCardNumber, "Grigoryan", "Arpine");

	}

	/**
	 * Increase and decrease customer balance
	 *
	 * @throws UnknownCustomerIdException throw exception when customer id card Number is not exist
	 * @throws LowBalanceException        throw exception when decrease more amount
	 */
	@Test
	public void testSimpleUpdateBalance() throws UnknownCustomerIdException, LowBalanceException {
		bank.increaseBalance(customerIdCardNumber, 100000);
		bank.decreaseBalance(customerIdCardNumber, 9999);
	}

	/**
	 * Add new customer with existing idCardNumber
	 *
	 * @throws ExistingCustomerIdException throw new exception when customer with given id is register
	 */
	@Test(expected = ExistingCustomerIdException.class)
	public void testAddExistingCustomer() throws ExistingCustomerIdException {
		bank.createNewAccount(customerIdCardNumber, "Grig", "Arp");
	}

	/**
	 * Update balance for not existing customer
	 *
	 * @throws UnknownCustomerIdException throw exception when customer id card Number is not exist
	 */
	@Test(expected = UnknownCustomerIdException.class)
	public void testUpdateUnknownCustomerBalance() throws UnknownCustomerIdException {
		bank.increaseBalance(customerIdCardNumber + "_1", 100000);
	}

	/**
	 * Decrease more amount when exist
	 *
	 * @throws UnknownCustomerIdException throw exception when customer id card Number is not exist
	 * @throws LowBalanceException        throw exception when decrease more amount
	 */
	@Test(expected = LowBalanceException.class)
	public void testDecreaseMoreAmount() throws UnknownCustomerIdException, LowBalanceException {
		bank.decreaseBalance(customerIdCardNumber, 1000000000);
	}

}
