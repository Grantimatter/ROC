package com.banking.dao;

import com.banking.exception.BankException;
import com.banking.model.Account;

import java.util.List;

public interface AccountSearchDao {
    public Account getAccountByNumber(int number) throws BankException;
    public List<Account> getAccountsByCustomerId(int customerId) throws BankException;
    public Account[] getAccountInBalanceRange(double minBalance, double maxBalance) throws BankException;
}
