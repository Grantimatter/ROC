package com.banking.service;

import com.banking.exception.BankException;
import com.banking.model.Customer;

public interface CustomerLoginService {
    public Customer getCustomerFromLogin(String contact_email, String password) throws BankException;
}
