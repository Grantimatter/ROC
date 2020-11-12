package com.grantwiswell.banking.dao;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;

public interface AccountCrudDao {
    public int createNewAccount(Account account) throws BankException;
    public int depositToAccount(double depositAmount, Account account) throws BankException;
    public int withdrawalFromAccount(double withdrawalAmount, Account account) throws BankException;
    public int updateAccountStatus(Account account, String status) throws BankException;
}
