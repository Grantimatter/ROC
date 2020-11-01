package com.banking.dao.util;

import com.banking.model.Customer;
import com.banking.service.AccountSearchService;
import com.banking.service.impl.AccountSearchServiceImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoCustomerUtil {

    private static AccountSearchService accountSearchService = new AccountSearchServiceImpl();

    public static Customer getCustomerFromResultSet(ResultSet resultSet){
        Customer customer = null;
        try{
            int id = resultSet.getInt("id");
            customer = new Customer(
                    id,
                    accountSearchService.getAccountsByCustomerId(id),
                    resultSet.getString("name"),
                    resultSet.getString("contact_email"),
                    resultSet.getLong("contact_number")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
