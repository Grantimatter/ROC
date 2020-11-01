package com.banking.service;

import com.banking.exception.BankException;

public interface CustomerCrudService {
    public void createNewCustomer(String name, String contact_email, String password) throws BankException;
}
