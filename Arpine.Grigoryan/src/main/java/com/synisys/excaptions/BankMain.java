package com.synisys.excaptions;

import com.synisys.excaptions.api.Bank;
import com.synisys.excaptions.exceptions.ExistingCustomerIdException;
import com.synisys.excaptions.exceptions.LowBalanceException;
import com.synisys.excaptions.exceptions.UnknownCustomerIdException;

import java.util.logging.Logger;

/**
 * Created by arpine on 5/14/15.
 */
public class BankMain {

	private static final Logger log = Logger.getLogger(BankMain.class.getName());

	public static void main(String[] args) throws ExistingCustomerIdException, UnknownCustomerIdException, LowBalanceException {

		// create new Bank

		Bank bank = new Bank("HSBC", "TeryanXXXX", "GFDP-BNM-JFKH-1");

		String customerIdCardNumber = "jkj-4556-Hksd-1-1";

		bank.createNewAccount(customerIdCardNumber, "Grigoryan", "Arpine");
		bank.increaseBalance(customerIdCardNumber, 100000);
		bank.decreaseBalance(customerIdCardNumber, 9999);


//		} catch (ExistingCustomerIdException e) {
//			e.printStackTrace();
//			log.log( Level.FINE, "Existing customer id" + customerIdCardNumber);
//
//		} catch (UnknownCustomerIdException e) {
//			e.printStackTrace();
//			log.log( Level.FINE, "Existing customer id" + customerIdCardNumber);
//		} catch (LowBalanceException e) {
//			e.printStackTrace();
//			log.log( Level.FINE, "Existing customer id" + customerIdCardNumber);
//		}

	}
}
