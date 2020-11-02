package com.grantwiswell.banking.service;

import com.grantwiswell.banking.exception.BankException;

public interface AccountCrudService {
    public void createNewAccount(int customer_id, double balance, String name) throws BankException;
}
