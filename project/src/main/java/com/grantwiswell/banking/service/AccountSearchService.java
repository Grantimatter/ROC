package com.grantwiswell.banking.service;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;

import java.util.List;

public interface AccountSearchService {
    public Account getAccountById(int number) throws BankException;
    public List<Account> getAccountsByCustomerId(int customerId) throws BankException;
    public List<Account> getAccountInBalanceRange(double minBalance, double maxBalance) throws BankException;
}
