package com.banking.dao;

import com.banking.exception.BankException;

public interface AccountCrudDao {
    public void createNewAccount(int customer_id, int number, double balance, String name) throws BankException;
}
