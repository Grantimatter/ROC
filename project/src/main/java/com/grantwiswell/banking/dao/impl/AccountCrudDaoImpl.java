package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.AccountCrudDao;
import com.grantwiswell.banking.dao.queries.AccountCrud;
import com.grantwiswell.banking.dao.util.DaoUtil;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;

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
            preparedStatement.setString(4, name.toUpperCase());
            int results = preparedStatement.executeUpdate();
            if(results == 0) throw new BankException("Account was unable to be created...");
        } catch (SQLException | ClassNotFoundException e) {
            DaoUtil.internalError(e);
        }
    }
}
