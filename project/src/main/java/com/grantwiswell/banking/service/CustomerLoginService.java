package com.grantwiswell.banking.service;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Customer;

public interface CustomerLoginService {
    public Customer getCustomerFromLogin(String contact_email, String password) throws BankException;
}
