package com.grantwiswell.banking.dao.util;

import com.grantwiswell.banking.dao.AccountSearchDao;
import com.grantwiswell.banking.dao.impl.AccountSearchDaoImpl;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.util.InputUtil;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCustomerUtil {

    private static Logger log = Logger.getLogger(DaoCustomerUtil.class);
    private static AccountSearchDao accountSearchDao = new AccountSearchDaoImpl();

    public static Customer getCustomerFromResultSet(ResultSet resultSet){
        Customer customer = null;
        try{
            int id = resultSet.getInt("id");
            customer = new Customer(
                    id,
                    accountSearchDao.getAccountsByCustomerId(id),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("contact_email"),
                    resultSet.getLong("contact_number"),
                    resultSet.getString("status"),
                    resultSet.getDate("dob")
            );
        } catch (SQLException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
        return customer;
    }

    public static Customer getNextCustomerFromResultSet(ResultSet resultSet){
        try {
            if(resultSet.next()){
                return getCustomerFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
        return null;
    }

    public static List<Customer> getCustomersFromResultSet(ResultSet resultSet){
        List<Customer> customerList = new ArrayList<>();
        try{
            while(resultSet.next()){
                customerList.add(getCustomerFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
        return customerList;
    }
}
