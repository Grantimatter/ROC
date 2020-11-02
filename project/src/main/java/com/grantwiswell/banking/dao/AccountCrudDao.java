package com.grantwiswell.banking.dao;

import com.grantwiswell.banking.exception.BankException;

public interface AccountCrudDao {
    public void createNewAccount(int customer_id, int number, double balance, String name) throws BankException;
    public void depositToAccount(double depositAmount, int number) throws BankException;
    public void withdrawalFromAccount(double withdrawalAmount, int number) throws BankException;}
