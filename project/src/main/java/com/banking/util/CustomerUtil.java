package com.banking.util;

import com.banking.exception.BankException;
import com.banking.model.Account;
import com.banking.model.Customer;

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
