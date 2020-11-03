package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.CustomerCrudDao;
import com.grantwiswell.banking.dao.queries.CustomerCrud;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;
import com.grantwiswell.banking.model.Customer;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerCrudDaoImpl implements CustomerCrudDao {

    private Logger log = Logger.getLogger(CustomerCrudDaoImpl.class);

    @Override
    public boolean createNewCustomer(Customer customer) throws BankException {
        int results = 0;
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CustomerCrud.CREATE_CUSTOMER);
            preparedStatement.setString(1,customer.getFirst_name());
            preparedStatement.setString(2,customer.getLast_name());
            preparedStatement.setString(3,customer.getContactEmail());
            preparedStatement.setString(4,customer.getPassword());
            preparedStatement.setDate(5, new java.sql.Date(customer.getDob().getTime()));
            results = preparedStatement.executeUpdate();
            if(results == 0){
                throw new BankException("Unable to add customer account...");
            }
        } catch (SQLException | ClassNotFoundException e) {
                log.error(e);
        }

        return results > 0;
    }
}
