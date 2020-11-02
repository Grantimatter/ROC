package com.grantwiswell.banking.util;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Customer;

public class CustomerUtil {
    public static boolean isCustomerAccount(Customer customer, Account account) throws BankException {
        for (Account checkAccount:customer.getAccounts()){
            if(account == checkAccount){
                return true;
            }
        }
        return false;
    }
}
