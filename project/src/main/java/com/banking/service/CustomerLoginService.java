package com.banking.service;

import com.banking.exception.BankException;
import com.banking.model.Customer;

public interface CustomerLoginService {
    public Customer validateLogin(String contactEmail, String password) throws BankException;
}
