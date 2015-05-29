package com.synisys.excaptions.api;

import com.synisys.excaptions.exceptions.ExistingCustomerIdException;
import com.synisys.excaptions.exceptions.LowBalanceException;
import com.synisys.excaptions.exceptions.UnknownCustomerIdException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by arpine on 5/28/15.
 */
public class Bank {
	private String name;
	private String adress;
	private String licenseId;
	private File bankDir;

	private Map<String, Account> bankAccounts = new HashMap<String, Account>();
	private Map<String, File> securityFiles = new HashMap<String, File>();
	private static final Logger log = Logger.getLogger(Bank.class.getName());

	public Bank(String name, String adress, String licenseId) {
		this.name = name;
		this.adress = adress;
		this.licenseId = licenseId;

		//create File directory
		try {
			this.bankDir = new File(this.name + this.licenseId);
			if (!this.bankDir.exists() && !this.bankDir.mkdirs()) {
				throw new IOException("Unable to create " + this.bankDir.getAbsolutePath());
			}
		} catch (IOException e) {
			log.log(Level.FINE, "Cannot create directory with name" + this.bankDir.getAbsolutePath());
			e.printStackTrace();
		}

	}

	/**
	 * Add new account for given customer
	 *
	 * @param idCardNumber
	 * @param firstName
	 * @param lastName
	 * @throws com.synisys.excaptions.exceptions.ExistingCustomerIdException throw new exception if customer id card number is exist
	 */

	public void createNewAccount(String idCardNumber, String firstName, String lastName) throws ExistingCustomerIdException {
		if (bankAccounts.containsKey(idCardNumber)) {
			throw new ExistingCustomerIdException();
		} else {
			Account newAccount = new Account(firstName, lastName, idCardNumber);
			bankAccounts.put(idCardNumber, newAccount);
			addFileForCustomer(idCardNumber);
		}
	}

	/**
	 * @param idCardNumber
	 * @param amount
	 * @throws com.synisys.excaptions.exceptions.UnknownCustomerIdException
	 * @throws com.synisys.excaptions.exceptions.LowBalanceException
	 */
	public void decreaseBalance(String idCardNumber, double amount) throws UnknownCustomerIdException, LowBalanceException {
		if (!this.bankAccounts.containsKey(idCardNumber)) {
			throw new UnknownCustomerIdException();
		} else {
			Account acount = this.bankAccounts.get(idCardNumber);
			acount.decrease(amount);
			updateFileForCustomer(idCardNumber, acount.getBalance());

		}

	}

	/**
	 * @param idCardNumber
	 * @param amount
	 * @throws UnknownCustomerIdException
	 */
	public void increaseBalance(String idCardNumber, double amount) throws UnknownCustomerIdException {
		if (!this.bankAccounts.containsKey(idCardNumber)) {
			throw new UnknownCustomerIdException();
		} else {
			Account acount = this.bankAccounts.get(idCardNumber);
			acount.increase(amount);

			updateFileForCustomer(idCardNumber, acount.getBalance());
		}

	}

	/**
	 * Add new file for given customer for bank security
	 *
	 * @param idCardNumber
	 */
	private void addFileForCustomer(String idCardNumber) {
		File file = new File(this.bankDir, idCardNumber + ".txt");

		try {
			file.createNewFile();
			securityFiles.put(idCardNumber, file);
		} catch (IOException e) {
			log.log(Level.FINE, "Cannot create txt file for customer" + idCardNumber);
			e.printStackTrace();
		}

	}

	private void updateFileForCustomer(String idCardNumber, double balance) {
		try {
			PrintWriter writer = new PrintWriter(this.securityFiles.get(idCardNumber));
			writer.print("");
			writer.print(balance);
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.log(Level.FINE, "Cannot write file balance for customer" + idCardNumber);

		}

	}
}
