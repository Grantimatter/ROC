package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.CustomerLoginDao;
import com.grantwiswell.banking.dao.queries.CustomerQueries;
import com.grantwiswell.banking.dao.util.DaoCustomerUtil;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;
import com.grantwiswell.banking.model.Customer;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerLoginDaoImpl implements CustomerLoginDao {

    private Logger log = Logger.getLogger(CustomerLoginDaoImpl.class);

    public Customer getCustomerFromLogin(String contactEmail, String password) throws BankException{
        Customer customer = null;
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CustomerQueries.GET_CUSTOMER_BY_LOGIN);
            preparedStatement.setString(1, contactEmail.toUpperCase());
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                customer = DaoCustomerUtil.getCustomerFromResultSet(resultSet);
            }
            else{
                throw new BankException("User and Password combo not found, please try again...");
            }
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
        return customer;
    }

}
