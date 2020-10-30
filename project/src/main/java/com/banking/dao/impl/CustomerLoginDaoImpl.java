package com.banking.dao.impl;

import com.banking.dao.CustomerLoginDao;
import com.banking.dao.queries.CustomerQueries;
import com.banking.dao.util.DaoCustomerUtil;
import com.banking.dao.util.DaoUtil;
import com.banking.exception.BankException;
import com.banking.jdbutil.PostgresSqlConnection;
import com.banking.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerLoginDaoImpl implements CustomerLoginDao {

    public Customer validateLogin(String contactEmail, String password) throws BankException{
        Customer customer = null;
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CustomerQueries.GET_CUSTOMER_BY_LOGIN);
            preparedStatement.setString(1, contactEmail);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                customer = DaoCustomerUtil.getCustomerFromResultSet(resultSet);
                //if(customer != null)
            }
            else{
                throw new BankException("User and Password combo not found, please try again...");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(DaoUtil.INTERNAL_ERROR);
        }
        return customer;
    }

}
