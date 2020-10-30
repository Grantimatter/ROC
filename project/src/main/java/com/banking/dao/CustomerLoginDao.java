package com.banking.dao;

import com.banking.exception.BankException;
import com.banking.model.Customer;

public interface CustomerLoginDao {
    public Customer validateLogin(String contactEmail, String password) throws BankException;
}
