package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.AccountSearchDao;
import com.grantwiswell.banking.dao.queries.AccountQueries;
import com.grantwiswell.banking.dao.util.DaoAccountUtil;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.service.impl.util.QueryUtil;
import org.apache.log4j.Logger;

import javax.management.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountSearchDaoImpl implements AccountSearchDao {

    private Logger log = Logger.getLogger(AccountSearchDaoImpl.class);

    @Override
    public Account getAccountByNumber(int number) throws BankException {
        Account account = DaoAccountUtil.getNextAccountFromResultSet(QueryUtil.sendQuery(AccountQueries.GET_ACCOUNT_BY_NUMBER, number));
        if(account == null) throw new BankException("Account #"+number+" was unable to be found");
        return account;
    }

    @Override
    public List<Account> getAccountsByCustomerId(int customerId) throws BankException {
        List<Account> accountList = DaoAccountUtil.getAccountsFromResultSet(QueryUtil.sendQuery(AccountQueries.GET_ACCOUNTS_BY_CUSTOMER_ID, customerId));
        //if(accountList == null || accountList.size() == 0) throw new BankException("Customer has no accounts");
        return accountList;
    }

    @Override
    public List<Account> getAccountsByStatus(String status) throws BankException {
        List<Account> accountList = DaoAccountUtil.getAccountsFromResultSet(QueryUtil.sendQuery(AccountQueries.GET_ACCOUNTS_BY_STATUS, status));
        if(accountList == null || accountList.size() == 0) throw new BankException("No accounts found with status \""+status+"\"");
        return accountList;
    }
}
