package com.grantwiswell.banking.service;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;

public interface AccountCrudService {
    public void createNewAccount(int customer_id, double balance, String name) throws BankException;
    public void depositToAccount(double depositAmount, int number) throws BankException;
    public void withdrawalFromAccount(double withdrawalAmount, Account account) throws BankException;
    public void withdrawalFromAccount(double withdrawalAmount, int id) throws BankException;
}
