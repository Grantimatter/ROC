package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.CustomerLoginDao;
import com.grantwiswell.banking.dao.queries.CustomerQueries;
import com.grantwiswell.banking.dao.util.DaoCustomerUtil;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.service.impl.util.QueryUtil;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerLoginDaoImpl implements CustomerLoginDao {

    private Logger log = Logger.getLogger(CustomerLoginDaoImpl.class);

    public Customer getCustomerFromLogin(String contactEmail, String password) throws BankException{
        Customer customer = DaoCustomerUtil.getNextCustomerFromResultSet(QueryUtil.sendQuery(CustomerQueries.GET_CUSTOMER_BY_LOGIN, contactEmail, password));
        if(customer == null) throw new BankException("No customer found with those login credentials");
        return customer;
    }

}
