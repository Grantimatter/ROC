package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.TransactionDao;
import com.grantwiswell.banking.dao.queries.TransactionQueries;
import com.grantwiswell.banking.dao.util.DaoTransactionUtil;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;
import com.grantwiswell.banking.main.BankMain;
import com.grantwiswell.banking.model.Transaction;
import com.grantwiswell.banking.service.impl.util.QueryUtil;
import org.apache.log4j.Logger;

import javax.management.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {

    private Logger log = Logger.getLogger(TransactionDaoImpl.class);

    @Override
    public int createTransaction(Transaction transaction) throws BankException {
        int results = QueryUtil.sendUpdate(TransactionQueries.CREATE_NEW_TRANSACTION, transaction.getAccount_from(),
                transaction.getAccount_to(), transaction.getAmount(), transaction.getTimestamp());
        if (results == 0) throw new BankException("Transaction was unable to be created");
        return results;
    }

    @Override
    public Transaction getTransactionById(int id) throws BankException {
        Transaction transaction = DaoTransactionUtil.getNextTransactionFromResultSet(QueryUtil.sendQuery(TransactionQueries.GET_TRANSACTION_BY_ID, id));
        if (transaction == null) throw new BankException("No transaction found by ID: " + id);
        return transaction;
    }

    @Override
    public List<Transaction> getTransactions(int account_id) throws BankException {
        List<Transaction> transactionList = DaoTransactionUtil.getTransactionsFromResultSet(QueryUtil.sendQuery(TransactionQueries.GET_TRANSACTIONS_INVOLVING_ACCOUNT, account_id, account_id));
        if (transactionList == null || transactionList.size() == 0)
            throw new BankException("No transactions were found involving account #" + account_id);
        return transactionList;
    }

    @Override
    public Transaction getNewTransaction(Transaction transaction) throws BankException {
        Transaction newTransaction = DaoTransactionUtil.getNextTransactionFromResultSet(QueryUtil.sendQuery(TransactionQueries.GET_NEW_TRANSACTION,
                transaction.getAccount_from(), transaction.getAccount_to(), transaction.getAmount(), transaction.getTimestamp()));
        if (newTransaction == null) throw new BankException("Unable to find newly created transaction");
        return newTransaction;
    }

    @Override
    public String getTransactionStatus(Transaction transaction) throws BankException {
        String transactionStatus = DaoTransactionUtil.getNextTransactionFromResultSet(QueryUtil.sendQuery(TransactionQueries.GET_TRANSACTION_STATUS, transaction.getId())).getStatus().toUpperCase();
        if (transactionStatus == null || transactionStatus.length() == 0) throw new BankException("Unable to retrieve transaction status");
        return transactionStatus;
    }

    @Override
    public int completeTransaction(Transaction transaction) throws BankException {
        int results = QueryUtil.sendUpdate(TransactionQueries.UPDATE_TRANSACTION_STATUS, "COMPLETED", transaction.getId());
        if (results == 0) throw new BankException("Unable to complete transaction #" + transaction.getId());
        return results;
    }

    @Override
    public int rejectTransaction(Transaction transaction) throws BankException {
        int results = QueryUtil.sendUpdate(TransactionQueries.UPDATE_TRANSACTION_STATUS, transaction.getId(), "REJECTED");
        if (results == 0) throw new BankException("Unable to reject transaction #" + transaction.getId());
        return results;
    }

    @Override
    public List<Transaction> getAllTransactions() throws BankException {
        List<Transaction> transactionList = DaoTransactionUtil.getTransactionsFromResultSet(QueryUtil.sendQuery(TransactionQueries.GET_TRANSACTION_DATA));
        if(transactionList == null || transactionList.size() == 0) throw new BankException("No transactions found in the database");
        return transactionList;
    }
}
