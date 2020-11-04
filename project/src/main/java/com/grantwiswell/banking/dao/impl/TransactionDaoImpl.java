package com.grantwiswell.banking.dao.impl;

import com.grantwiswell.banking.dao.TransactionDao;
import com.grantwiswell.banking.dao.queries.TransactionQueries;
import com.grantwiswell.banking.dao.util.DaoTransactionUtil;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.jdbutil.PostgresSqlConnection;
import com.grantwiswell.banking.model.Transaction;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {

    private Logger log = Logger.getLogger(TransactionDaoImpl.class);

    @Override
    public void createTransaction(Transaction transaction) throws BankException {
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(TransactionQueries.CREATE_NEW_TRANSACTION);
            preparedStatement.setInt(1, transaction.getAccount_from());
            preparedStatement.setInt(2, transaction.getAccount_to());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setTimestamp(4, transaction.getTimestamp());
            int results = preparedStatement.executeUpdate();
            if (results == 0) throw new BankException("Transaction was unable to be created.");
            log.debug("Transaction created : " + transaction.toString());
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
    }

    @Override
    public Transaction getTransactionById(int id) throws BankException {
        Transaction transaction = null;
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(TransactionQueries.GET_TRANSACTION_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                transaction = DaoTransactionUtil.getTransactionFromResultSet(resultSet);
            }
        }catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
        return transaction;
    }

    @Override
    public List<Transaction> getTransactions(int account_id) throws BankException {
        List<Transaction> transactions = new ArrayList<>();
        try (Connection connection = PostgresSqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(TransactionQueries.GET_TRANSACTIONS_INVOLVING_ACCOUNT);
            preparedStatement.setInt(1, account_id);
            preparedStatement.setInt(2, account_id);
            transactions = DaoTransactionUtil.getTransactionsFromResultSet(preparedStatement.executeQuery());
            if (transactions.size() <= 0) throw new BankException("No transactions were found.");
            log.debug("Transactions from account : " + account_id + "\n" + transactions);
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
        return transactions;
    }

    @Override
    public Transaction getNewTransaction(Transaction transaction) throws BankException {
        Transaction newTransaction = null;
        try(Connection connection = PostgresSqlConnection.getConnection()){
            log.debug("Looking for Transaction : " + transaction);
            PreparedStatement preparedStatement = connection.prepareStatement(TransactionQueries.GET_NEW_TRANSACTION);
            preparedStatement.setInt(1, transaction.getAccount_from());
            preparedStatement.setInt(2, transaction.getAccount_to());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setTimestamp(4, transaction.getTimestamp());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                newTransaction = DaoTransactionUtil.getTransactionFromResultSet(resultSet);
                log.debug("Found New Transaction : " + newTransaction);
            }
            else throw new BankException("Was not able to retrieve newly created transaction");
        }catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
        return newTransaction;
    }

    @Override
    public String getTransactionStatus(Transaction transaction) throws BankException {
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(TransactionQueries.GET_TRANSACTION_STATUS);
            log.debug("Looking up transaction with ID : " + transaction.getId());
            preparedStatement.setInt(1, transaction.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString("status").toUpperCase();
            }
            throw new BankException("Could not verify transaction status");
        }catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
        throw new BankException("Could not verify transaction status");
    }

    @Override
    public void completeTransaction(Transaction transaction) throws BankException {
            try (Connection connection = PostgresSqlConnection.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(TransactionQueries.UPDATE_TRANSACTION_STATUS);
                preparedStatement.setString(1, "COMPLETED");
                preparedStatement.setInt(2, transaction.getId());
                int results = preparedStatement.executeUpdate();
                if(results == 0) throw new BankException("Was not able to update transaction status");
            } catch (SQLException | ClassNotFoundException e) {
                log.error(e);
            }
    }

    @Override
    public void rejectTransaction(Transaction transaction) throws BankException {
        try(Connection connection = PostgresSqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(TransactionQueries.UPDATE_TRANSACTION_STATUS);
            preparedStatement.setInt(1, transaction.getId());
            preparedStatement.setString(2, "REJECTED");
            int results = preparedStatement.executeUpdate();
            if(results == 0) throw new BankException("Unable to update Transaction status to REJECTED");
        }catch (SQLException | ClassNotFoundException e) {
            log.error(e);
        }
    }
}
