package com.banking.service;

import com.banking.exception.BankException;
import com.banking.model.Account;

public interface AccountCrudService {
    public void createNewAccount(int customer_id, double balance, String name) throws BankException;
}
