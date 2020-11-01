package com.banking.dao;

import com.banking.exception.BankException;

public interface CustomerCrudDao {
    public void createNewCustomer(String name, String contact_email, String password) throws BankException;
}
