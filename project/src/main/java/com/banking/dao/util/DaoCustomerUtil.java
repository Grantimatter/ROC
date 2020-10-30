package com.banking.dao.util;

import com.banking.model.Customer;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DaoCustomerUtil {

    public static Customer getCustomerFromResultSet(ResultSet resultSet){
        Customer customer = null;
        try{

            ResultSet intarray = resultSet.getArray("account_numbers").getResultSet();

            List<Integer> accountNumberList = new ArrayList<>();

            while(intarray.next()){
                accountNumberList.add(intarray.getInt(2));
            }

            int[] accountNumbers = accountNumberList.stream().mapToInt(i->i).toArray();

            customer = new Customer(
                    resultSet.getInt("id"),
                    accountNumbers,
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
