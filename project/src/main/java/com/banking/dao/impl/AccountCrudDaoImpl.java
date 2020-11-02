package com.banking.dao.impl;

import com.banking.dao.AccountCrudDao;
import com.banking.dao.queries.AccountCrud;
import com.banking.dao.util.DaoUtil;
import com.banking.exception.BankException;
import com.banking.jdbutil.PostgresSqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountCrudDaoImpl implements AccountCrudDao {

    @Override
    public void createNewAccount(int customer_id, int number, double balance, String name) throws BankException {
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(AccountCrud.CREATE_NEW_ACCOUNT);
            preparedStatement.setInt(1, customer_id);
            preparedStatement.setInt(2, number);
            preparedStatement.setDouble(3, balance);
            preparedStatement.setString(4, name);
            int results = preparedStatement.executeUpdate();
            if(results == 0) throw new BankException("Account was unable to be created...");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(DaoUtil.INTERNAL_ERROR);
        }
    }
}
