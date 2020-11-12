package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.AccountCrudDao;
import com.grantwiswell.banking.dao.queries.AccountCrud;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.service.impl.util.QueryUtil;
import org.apache.log4j.Logger;

import javax.management.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

public class AccountCrudDaoImpl implements AccountCrudDao {

    private Logger log = Logger.getLogger(AccountCrudDaoImpl.class);

    @Override
    public int createNewAccount(Account account) throws BankException {
        int results = QueryUtil.sendUpdate(AccountCrud.CREATE_NEW_ACCOUNT, account.getCustomer_id(), account.getId(), account.getBalance(), account.getName(), account.getStatus());
        if (results == 0) throw new BankException("Unable to create new account..." + account.getName());
        return results;
    }

    @Override
    public int depositToAccount(double depositAmount, Account account) throws BankException {
        int results = QueryUtil.sendUpdate(AccountCrud.DEPOSIT_TO_ACCOUNT, depositAmount, account.getId());
        if (results == 0) throw new BankException("Unable to Deposit to account #" + account.getId());
        return results;
    }

    @Override
    public int withdrawalFromAccount(double withdrawalAmount, Account account) throws BankException {
        int results = QueryUtil.sendUpdate(AccountCrud.WITHDRAWAL_FROM_ACCOUNT, withdrawalAmount, account.getId());
        if (results == 0) throw new BankException("Unable to withdrawal from account #" + account.getId());
        return results;
    }

    @Override
    public int updateAccountStatus(Account account, String status) throws BankException {
        int results = QueryUtil.sendUpdate(AccountCrud.UPDATE_ACCOUNT_STATUS, status, account.getId());
        if (results == 0) throw new BankException("Unable to update account #" + account.getId() + " status to " + status);
        return results;
    }
}
