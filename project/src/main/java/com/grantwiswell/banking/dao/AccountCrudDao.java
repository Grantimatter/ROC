package com.grantwiswell.banking.dao;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;

public interface AccountCrudDao {
    public void createNewAccount(Account account) throws BankException;
    public void depositToAccount(double depositAmount, Account account) throws BankException;
    public void withdrawalFromAccount(double withdrawalAmount, Account account) throws BankException;
    public void updateAccountStatus(Account account, String status) throws BankException;
}
