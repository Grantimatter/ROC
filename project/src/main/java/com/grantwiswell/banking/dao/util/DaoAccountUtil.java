package com.grantwiswell.banking.dao.util;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.util.InputUtil;
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
            log.error(e);
        }
        return account;
    }

    public static Account getNextAccountFromResultSet(ResultSet resultSet){
        try {
            if(resultSet.next()){
                return getAccountFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
        return null;
    }

    public static List<Account> getAccountsFromResultSet(ResultSet resultSet){
        List<Account> accountList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                accountList.add(getAccountFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return accountList;
    }
}
