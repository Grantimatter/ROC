package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.CustomerSearchDao;
import com.grantwiswell.banking.dao.queries.CustomerQueries;
import com.grantwiswell.banking.dao.util.DaoCustomerUtil;
import com.grantwiswell.banking.dao.util.DaoUtil;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;
import com.grantwiswell.banking.model.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerSearchDaoImpl implements CustomerSearchDao {

    @Override
    public Customer getCustomerById(int id) throws BankException {
        Customer customer = null;
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CustomerQueries.GET_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return DaoCustomerUtil.getCustomerFromResultSet(resultSet);
            }
            else{
                throw new BankException("Customer with ID : "+id+" not found, please try again...");
            }
        } catch (SQLException | ClassNotFoundException e) {
            DaoUtil.internalError(e);
        }

        return customer;
    }

    @Override
    public Customer getCustomerByAccount(int accountNumber) throws BankException {
        return null;
    }

    @Override
    public Customer getCustomerByContactEmail(String contactEmail) throws BankException {
        return null;
    }

    @Override
    public Customer getCustomerByContactNumber(long contactNumber) throws BankException {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() throws BankException {
        List<Customer> customers = new ArrayList<>();
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CustomerQueries.GET_ALL_CUSTOMERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                customers.add(DaoCustomerUtil.getCustomerFromResultSet(resultSet));
            }
            if(customers.size() == 0){
                throw new BankException("There are no customers in the database.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            DaoUtil.internalError(e);
        }
        return customers;
    }

    @Override
    public List<Customer> getCustomersByName(String name) throws BankException {
        return null;
    }
}
