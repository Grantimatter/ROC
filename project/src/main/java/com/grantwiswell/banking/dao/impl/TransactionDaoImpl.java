package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.TransactionDao;
import com.grantwiswell.banking.dao.queries.TransactionQueries;
import com.grantwiswell.banking.dao.util.DaoTransactionUtil;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Transaction;
import org.apache.log4j.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {

    private Logger log = Logger.getLogger(TransactionDaoImpl.class);

    @Override
    public void createTransaction(Transaction transaction) throws BankException {
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(TransactionQueries.CREATE_NEW_TRANSACTION);
            preparedStatement.setInt(1, transaction.getAccount_from());
            preparedStatement.setInt(2, transaction.getAccount_to());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setTimestamp(4, new java.sql.Timestamp(Instant.now().getEpochSecond() * 1000L));
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
    }

    @Override
    public List<Transaction> getTransactions(int account_id) throws BankException {
        List<Transaction> transactions = new ArrayList<>();
        try(Connection connection = PostgresSqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(TransactionQueries.GET_TRANSACTIONS_INVOLVING_ACCOUNT);
            preparedStatement.setInt(1, account_id);
            preparedStatement.setInt(2, account_id);
            transactions = DaoTransactionUtil.getTransactionsFromResultSet(preparedStatement.executeQuery());
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
        return transactions;
    }

    @Override
    public boolean completeTransaction(int transactionId) throws BankException {
        throw new NotImplementedException();
    }
}
