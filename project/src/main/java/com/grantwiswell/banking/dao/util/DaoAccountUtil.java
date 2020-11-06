package com.grantwiswell.banking.dao.util;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoAccountUtil {

    private static Logger log = Logger.getLogger(DaoAccountUtil.class);

    public static Account getAccountFromResultSet(ResultSet resultSet) {
        Account account = null;
        try {
            account = new Account(
                    resultSet.getInt("customer_id"),
                    resultSet.getInt("id"),
                    resultSet.getDouble("balance"),
                    resultSet.getString("name"),
                    resultSet.getString("status")
            );
        } catch (SQLException e) {
            log.warn(e);
        }
        return account;
    }

    public static List<Account> getAccountsFromResultSet(ResultSet resultSet){
        List<Account> accountList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                accountList.add(getAccountFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            log.warn(e.getMessage());
        }
        return accountList;
    }
}
