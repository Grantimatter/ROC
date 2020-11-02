package com.grantwiswell.banking.dao;

import com.grantwiswell.banking.exception.BankException;

public interface AccountCrudDao {
    public void createNewAccount(int customer_id, int number, double balance, String name) throws BankException;
}
