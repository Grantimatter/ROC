package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.CustomerCrudDao;
import com.grantwiswell.banking.dao.queries.CustomerCrud;
import com.grantwiswell.banking.dao.util.DaoUtil;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerCrudDaoImpl implements CustomerCrudDao {
    @Override
    public boolean createNewCustomer(String contact_email, String password, String first_name, String last_name) throws BankException {
        int results = 0;
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CustomerCrud.CREATE_CUSTOMER);
            preparedStatement.setString(1,first_name);
            preparedStatement.setString(2,last_name);
            preparedStatement.setString(3,contact_email);
            preparedStatement.setString(4,password);
            results = preparedStatement.executeUpdate();
            if(results == 0){
                throw new BankException("Unable to add customer account...");
            }
        } catch (SQLException | ClassNotFoundException e) {
                DaoUtil.internalError(e);
        }

        return results > 0;
    }
}
