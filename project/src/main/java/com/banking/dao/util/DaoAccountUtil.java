package com.banking.dao.util;

import com.banking.model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAccountUtil {
    public static Account getAccountFromResultSet(ResultSet resultSet) {
        Account account = null;
        try {
            account = new Account(
                    resultSet.getInt("customer_id"),
                    resultSet.getInt("number"),
                    resultSet.getDouble("balance"),
                    resultSet.getString("name")
            );
        } catch (SQLException e) {
            System.out.println(DaoUtil.INTERNAL_ERROR);
        }
        return account;
    }
}
