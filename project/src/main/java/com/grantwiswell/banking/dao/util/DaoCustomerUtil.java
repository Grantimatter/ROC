package com.grantwiswell.banking.dao.util;

import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.service.AccountSearchService;
import com.grantwiswell.banking.service.impl.AccountSearchServiceImpl;

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
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("contact_email"),
                    resultSet.getLong("contact_number"),
                    resultSet.getString("status")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
