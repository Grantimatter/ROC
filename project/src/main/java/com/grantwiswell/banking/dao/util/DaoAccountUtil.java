package com.grantwiswell.banking.dao.util;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAccountUtil {

    private static Logger log = Logger.getLogger(DaoAccountUtil.class);

    public static Account getAccountFromResultSet(ResultSet resultSet) {
        Account account = null;
        try {
            account = new Account(
                    resultSet.getInt("customer_id"),
                    resultSet.getInt("id"),
                    resultSet.getDouble("balance"),
                    resultSet.getString("name")
            );
        } catch (SQLException e) {
            log.warn(e);
        }
        return account;
    }
}
