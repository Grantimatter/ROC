package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.CustomerSearchDao;
import com.grantwiswell.banking.dao.queries.CustomerQueries;
import com.grantwiswell.banking.dao.util.DaoCustomerUtil;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;
import com.grantwiswell.banking.model.Customer;
import org.apache.log4j.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerSearchDaoImpl implements CustomerSearchDao {

    Logger log = Logger.getLogger(CustomerSearchDaoImpl.class);

    @Override
    public Customer getCustomerById(int id) throws BankException {
        Customer customer = null;
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CustomerQueries.GET_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                customer = DaoCustomerUtil.getCustomerFromResultSet(resultSet);
                log.debug("Customer found by ID: " + customer);
                return customer;
            }
            else{
                throw new BankException("Customer with ID: "+id+" not found, please try again...");
            }
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }

        throw new BankException("Was not able to find customer by ID: " + id);
    }

    @Override
    public Customer getCustomerByContactEmail(String contactEmail) throws BankException {
        throw new NotImplementedException();
    }

    @Override
    public Customer getCustomerByContactNumber(long contactNumber) throws BankException {
        throw new NotImplementedException();
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
            if(customers.size() == 0) throw new BankException("There are no customers in the database.");
            log.debug("All customers: " + customers);
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
        return customers;
    }

    @Override
    public List<Customer> getCustomersByFirstName(String first_name) throws BankException {
        throw new NotImplementedException();
    }

    @Override
    public List<Customer> getCustomersByStatus(String status) throws BankException {
        List<Customer> customerList = new ArrayList<>();
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CustomerQueries.GET_CUSTOMER_BY_STATUS);
            preparedStatement.setString(1, status);
            customerList = DaoCustomerUtil.getCustomersFromResultSet(preparedStatement.executeQuery());
        }catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
        return customerList;
    }
}
