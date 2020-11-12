package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.CustomerCrudDao;
import com.grantwiswell.banking.dao.queries.CustomerCrud;
import com.grantwiswell.banking.dao.util.DaoCustomerUtil;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.service.impl.util.QueryUtil;
import com.grantwiswell.banking.util.InputUtil;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerCrudDaoImpl implements CustomerCrudDao {

    private Logger log = Logger.getLogger(CustomerCrudDaoImpl.class);

    @Override
    public int createNewCustomer(Customer customer) throws BankException {
        return QueryUtil.sendUpdate(CustomerCrud.CREATE_CUSTOMER, customer.getFirst_name(), customer.getLast_name(),
                customer.getContactEmail(), customer.getPassword(), new java.sql.Date(customer.getDob().getTime()),
                customer.getStatus());
    }

    @Override
    public int updateCustomerStatus(int id, String status) throws BankException {
        return QueryUtil.sendUpdate(CustomerCrud.UPDATE_CUSTOMER_STATUS, status, id);
    }
}
