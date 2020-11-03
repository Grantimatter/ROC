package com.grantwiswell.banking.dao.util;

import com.grantwiswell.banking.model.Transaction;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoTransactionUtil {
    private static Logger log = Logger.getLogger(DaoTransactionUtil.class);

    public static Transaction getTransactionFromResultSet(ResultSet resultSet) {
        Transaction transaction = null;
        try {
            transaction = new Transaction(
                    resultSet.getInt("id"),
                    resultSet.getInt("account_from"),
                    resultSet.getInt("account_to"),
                    resultSet.getDouble("amount"),
                    resultSet.getTimestamp("date_created"),
                    resultSet.getString("status")
            );
        } catch (SQLException e) {
            log.warn(e);
        }
        return transaction;
    }

    public static List<Transaction> getTransactionsFromResultSet(ResultSet resultSet){
        List<Transaction> transactions = new ArrayList<>();
            try {
                while(resultSet.next()){
                    transactions.add(getTransactionFromResultSet(resultSet));
                }
            } catch (SQLException e) {
                log.warn(e);
            }
            return transactions;
    }
}
