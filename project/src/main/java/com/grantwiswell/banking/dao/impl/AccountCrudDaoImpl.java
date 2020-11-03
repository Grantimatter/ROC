package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.AccountCrudDao;
import com.grantwiswell.banking.dao.queries.AccountCrud;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountCrudDaoImpl implements AccountCrudDao {

    private Logger log = Logger.getLogger(AccountCrudDaoImpl.class);

    @Override
    public void createNewAccount(int customer_id, int number, double balance, String name) throws BankException {
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(AccountCrud.CREATE_NEW_ACCOUNT);
            preparedStatement.setInt(1, customer_id);
            preparedStatement.setInt(2, number);
            preparedStatement.setDouble(3, balance);
            preparedStatement.setString(4, name.toUpperCase());
            int results = preparedStatement.executeUpdate();
            if(results == 0) throw new BankException("Account was unable to be created...");
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
    }

    @Override
    public void depositToAccount(double depositAmount, int number) throws BankException {
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = PostgresSqlConnection.getConnection().prepareStatement(AccountCrud.DEPOSIT_TO_ACCOUNT);
            preparedStatement.setDouble(1, depositAmount);
            preparedStatement.setInt(2, number);
            int results = preparedStatement.executeUpdate();
            if(results == 0) throw new BankException("Error completing deposit, please try again later");
        }catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
    }

    @Override
    public void withdrawalFromAccount(double withdrawalAmount, int id) throws BankException {
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(AccountCrud.WITHDRAWAL_FROM_ACCOUNT);
            preparedStatement.setDouble(1, withdrawalAmount);
            preparedStatement.setInt(2, id);
            int results = preparedStatement.executeUpdate();
            if(results == 0) throw new BankException("Error completing withdrawal, please try again later.");
        }catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
    }
}
