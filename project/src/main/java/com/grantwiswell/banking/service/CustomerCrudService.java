package com.grantwiswell.banking.service;

import com.grantwiswell.banking.exception.BankException;

public interface CustomerCrudService {
    public boolean createNewCustomer(String name, String contact_email, String password, String dob) throws BankException;
    public void acceptCustomer(int id) throws BankException;
}
