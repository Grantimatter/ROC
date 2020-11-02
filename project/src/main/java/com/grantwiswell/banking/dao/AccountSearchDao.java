package com.grantwiswell.banking.dao;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;

import java.util.List;

public interface AccountSearchDao {
    public Account getAccountByNumber(int number) throws BankException;
    public List<Account> getAccountsByCustomerId(int customerId) throws BankException;
    public Account[] getAccountInBalanceRange(double minBalance, double maxBalance) throws BankException;
}
