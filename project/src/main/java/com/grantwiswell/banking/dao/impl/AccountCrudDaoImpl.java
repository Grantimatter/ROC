package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.AccountCrudDao;
import com.grantwiswell.banking.dao.queries.AccountCrud;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;
import com.grantwiswell.banking.model.Account;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

public class AccountCrudDaoImpl implements AccountCrudDao {

    private Logger log = Logger.getLogger(AccountCrudDaoImpl.class);

    @Override
    public void createNewAccount(Account account) throws BankException {
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(AccountCrud.CREATE_NEW_ACCOUNT);
            preparedStatement.setInt(1, account.getCustomer_id());
            preparedStatement.setInt(2, account.getId());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setString(4, account.getName().toUpperCase());
            preparedStatement.setString(5, account.getStatus().toUpperCase());
            int results = preparedStatement.executeUpdate();
            if(results == 0) throw new BankException("Account was unable to be created...");
            log.debug("Account Created: " + account);
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
    }

    @Override
    public void depositToAccount(double depositAmount, Account account) throws BankException {
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = PostgresSqlConnection.getConnection().prepareStatement(AccountCrud.DEPOSIT_TO_ACCOUNT);
            preparedStatement.setDouble(1, depositAmount);
            preparedStatement.setInt(2, account.getId());
            int results = preparedStatement.executeUpdate();
            if(results == 0) throw new BankException("Error completing deposit, please try again later");
        }catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
    }

    @Override
    public void withdrawalFromAccount(double withdrawalAmount, Account account) throws BankException {
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(AccountCrud.WITHDRAWAL_FROM_ACCOUNT);
            preparedStatement.setDouble(1, withdrawalAmount);
            preparedStatement.setInt(2, account.getId());
            int results = preparedStatement.executeUpdate();
            if(results == 0) throw new BankException("Error completing withdrawal, please try again later.");
        }catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
    }

    @Override
    public void updateAccountStatus(Account account, String status) throws BankException {
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(AccountCrud.UPDATE_ACCOUNT_STATUS);
            preparedStatement.setString(1,status);
            preparedStatement.setInt(2, account.getId());
            int results = preparedStatement.executeUpdate();
            if(results > 0) log.debug(account.getId() + " status updated to " + status);
            else throw new BankException("Status of account #"+account.getId()+" was unable to be updated");
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
    }
}
