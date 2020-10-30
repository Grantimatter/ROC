package com.banking.util;

import com.banking.exception.BankException;
import com.banking.model.Customer;

public class CustomerUtil {
    public static boolean isCustomerAccount(Customer customer, int account) throws BankException {
        for (int i:customer.getAccountNumbers()){
            if(account == i){
                return true;
            }
        }
        return false;
    }
}
