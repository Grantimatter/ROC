package com.banking.service;

import com.banking.exception.BankException;
import com.banking.model.Customer;

public interface CustomerCrudService {
    public void createNewCustomer(String name, String contact_email, String password) throws BankException;
}
