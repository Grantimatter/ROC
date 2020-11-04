package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.AccountSearchDao;
import com.grantwiswell.banking.dao.queries.AccountQueries;
import com.grantwiswell.banking.dao.util.DaoAccountUtil;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;
import com.grantwiswell.banking.model.Account;
import org.apache.log4j.Logger;

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
        Account account = null;
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(AccountQueries.GET_ACCOUNT_BY_NUMBER);
            preparedStatement.setInt(1, number);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                account = DaoAccountUtil.getAccountFromResultSet(resultSet);
            }
            else{
                throw new BankException("Account with number "+number+" not found...");
            }
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
        return account;
    }

    @Override
    public List<Account> getAccountsByCustomerId(int customerId) throws BankException {
        List<Account> accountList = new ArrayList<>();

        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(AccountQueries.GET_ACCOUNTS_BY_CUSTOMER_ID);
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Account account = DaoAccountUtil.getAccountFromResultSet(resultSet);
                accountList.add(account);
            }

            log.debug(accountList);
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }

        return accountList;
    }

    @Override
    public Account[] getAccountInBalanceRange(double minBalance, double maxBalance) throws BankException {
        return new Account[0];
    }
}
