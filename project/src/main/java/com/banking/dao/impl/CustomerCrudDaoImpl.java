package com.banking.dao.impl;

import com.banking.dao.CustomerCrudDao;
import com.banking.dao.queries.CustomerCrud;
import com.banking.dao.util.DaoUtil;
import com.banking.exception.BankException;
import com.banking.jdbutil.PostgresSqlConnection;
import com.banking.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerCrudDaoImpl implements CustomerCrudDao {
    @Override
    public void createNewCustomer(String contact_email, String password, String name) throws BankException {
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CustomerCrud.CREATE_CUSTOMER);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,contact_email);
            preparedStatement.setString(3,password);
            int results = preparedStatement.executeUpdate();
            if(results == 0){
                throw new BankException("Unable to add customer account...");
            }
        } catch (SQLException | ClassNotFoundException e) {
                System.out.println(DaoUtil.INTERNAL_ERROR);
        }
    }
}
