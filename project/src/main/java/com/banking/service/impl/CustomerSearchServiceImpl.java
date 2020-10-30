package com.banking.service.impl;

import com.banking.dao.queries.CustomerQueries;
import com.banking.exception.BankException;
import com.banking.jdbutil.PostgresSqlConnection;
import com.banking.model.Customer;
import com.banking.service.CustomerSearchService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerSearchServiceImpl implements CustomerSearchService {

    @Override
    public Customer getCustomerById(int id) throws BankException {
        return null;
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
        return null;
    }

    @Override
    public List<Customer> getCustomersByName(String name) throws BankException {
        return null;
    }
}
