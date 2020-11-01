package com.banking.dao.impl;

import com.banking.dao.CustomerCrudDao;
import com.banking.dao.util.DaoUtil;
import com.banking.exception.BankException;
import com.banking.jdbutil.PostgresSqlConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomerCrudDaoImpl implements CustomerCrudDao {
    @Override
    public void createNewCustomer(String name, String contact_email, String password) throws BankException {
        try(Connection connection = PostgresSqlConnection.getConnection()){

        } catch (SQLException | ClassNotFoundException e) {
                System.out.println(DaoUtil.INTERNAL_ERROR);
        }
    }
}
