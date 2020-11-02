package com.grantwiswell.banking.dao;

import com.grantwiswell.banking.exception.BankException;

public interface CustomerCrudDao {
    public boolean createNewCustomer(String first_name, String last_name, String contact_email, String password) throws BankException;
}
