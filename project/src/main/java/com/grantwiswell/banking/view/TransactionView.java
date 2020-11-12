package com.grantwiswell.banking.view;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.util.menu.Menu;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Transaction;
import com.grantwiswell.banking.service.AccountSearchService;
import com.grantwiswell.banking.service.TransactionService;
import com.grantwiswell.banking.service.impl.AccountSearchServiceImpl;
import com.grantwiswell.banking.service.impl.TransactionServiceImpl;
import com.grantwiswell.banking.util.InputUtil;
import com.grantwiswell.banking.util.menu.MenuOption;
import org.apache.log4j.Logger;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TransactionView {

    private TransactionService transactionService = new TransactionServiceImpl();
    private AccountSearchService accountSearchService = new AccountSearchServiceImpl();

    private static Logger log = Logger.getLogger(TransactionView.class);

    public void showTransactionListMenu(Account account) {
        // Update account
        try {
            account = accountSearchService.getAccountById(account.getId());
            Account updatedAccount = account;
            List<Transaction> transactions = transactionService.getTransactionsByAccountId(account.getId());
            List<Transaction> pastTransactions = getPastTransactions(transactions);
            Menu transactionListMenu = new Menu("Transfers | " + account.toString(), "Account Options").setIsLooping(false);
            transactionListMenu.setAfterLoopConsumer(x -> showTransactionListMenu(updatedAccount));
            transactionListMenu.addOption("Start a Transfer", x -> startCreateTransactionMenu(updatedAccount));
            // Add Completed transactions list if there are any
            if (pastTransactions != null && pastTransactions.size() > 0) {
                transactionListMenu.addOption("View Past Transactions", x -> showPastTransactionMenu(updatedAccount, pastTransactions));
                transactions.removeAll(pastTransactions);
            }
            transactionListMenu.addOptions(getMenuOptionsFromTransactions(transactions, updatedAccount));

            // Display the menu and initiate the loop
            transactionListMenu.startMenu();
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
    }

    public List<MenuOption> getMenuOptionsFromTransactions(List<Transaction> transactionList, Account account){
        List<MenuOption> menuOptionList = new ArrayList<>();
        if(transactionList != null && transactionList.size() > 0)
        for (Transaction t:transactionList){
            menuOptionList.add(new MenuOption(formatTransaction(account, t), x -> startViewTransactionMenu(account, t)));
        }
        return menuOptionList;
    }

    public List<Transaction> getPastTransactions(List<Transaction> allTransactions){
        List<Transaction> pastTransactionList = new ArrayList<>();
        if(pastTransactionList != null && pastTransactionList.size() > 0) {
            for (Transaction transaction : allTransactions) {
                if (transaction.getStatus().equalsIgnoreCase("COMPLETED") || transaction.getStatus().equalsIgnoreCase("REJECTED")) {
                    pastTransactionList.add(transaction);
                }
            }
            return pastTransactionList;
        }
        return null;
    }

    private void showPastTransactionMenu(Account account, List<Transaction> transactions) {
        Menu pastTransactionMenu = new Menu("Past Transactions | " + account.toString());
        pastTransactionMenu.addOptions(getMenuOptionsFromTransactions(transactions, account));
        pastTransactionMenu.startMenu();
    }

    public void startViewTransactionMenu(Account account, Transaction transaction) {
        try {
            transaction = transactionService.getTransactionById(transaction.getId());
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }

        boolean isActionable = !(transaction.getStatus().equalsIgnoreCase("COMPLETED") || transaction.getStatus().equalsIgnoreCase("REJECTED") || account.getId() == transaction.getAccount_from());
        if(isActionable){
            Transaction updatedTransaction = transaction;
            Menu transactionOptionsMenu = new Menu(formatTransaction(account, transaction), "Transactions").setIsLooping(false);
            transactionOptionsMenu.setAfterLoopConsumer(x -> startViewTransactionMenu(account, updatedTransaction));
            transactionOptionsMenu.addOption("Accept Transaction", x -> transactionService.completeTransaction(updatedTransaction));
            transactionOptionsMenu.addOption("Reject Transaction", x -> transactionService.rejectTransaction(updatedTransaction));
            transactionOptionsMenu.startMenu();
        }
    }

    // Make transaction pretty and readable
    private static String formatTransaction(Account account, Transaction transaction) {
        String amount = NumberFormat.getCurrencyInstance(Locale.US).format(transaction.getAmount());
        String going = transaction.getAccount_from() == account.getId() ? " | Outgoing: " : " | Incoming: ";
        String destination = transaction.getAccount_to() == account.getId() ? " | From: #" + transaction.getAccount_from() : " | Destination: #" + transaction.getAccount_to();
        String status = "Status: " + transaction.getStatus();
        String timestamp = " | Created: " + transaction.getTimestamp();
        return status + going + amount + destination + timestamp;
    }

    public void startCreateTransactionMenu(Account account) {
        int choice = 0;
        try {
            log.info("Please input the account number you would like to transfer funds to");
            int account_id = InputUtil.getIntInput();
            log.info("Please input the amount you would like to transfer to account #" + account_id);
            double amount = InputUtil.getDoubleInput();
            transactionService.createTransaction(account.getId(), account_id, amount);
            account = accountSearchService.getAccountById(account.getId());
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
    }
}
