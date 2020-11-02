package com.grantwiswell.banking.dao;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Customer;

public interface CustomerLoginDao {
    public Customer getCustomerFromLogin(String contactEmail, String password) throws BankException;
}
