package com.grantwiswell.banking.control;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.main.menu.MenuFormatting;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Transaction;
import com.grantwiswell.banking.service.AccountSearchService;
import com.grantwiswell.banking.service.TransactionService;
import com.grantwiswell.banking.service.impl.AccountSearchServiceImpl;
import com.grantwiswell.banking.service.impl.TransactionServiceImpl;
import com.grantwiswell.banking.util.InputUtil;
import com.grantwiswell.banking.view.TransactionView;
import org.apache.log4j.Logger;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TransactionController {

    private static TransactionService transactionService = new TransactionServiceImpl();
    private static AccountSearchService accountSearchService = new AccountSearchServiceImpl();

    private static Logger log = Logger.getLogger(TransactionView.class);

    public static void startTransactionListMenu(Account account) {
        int optionCount = 0;
        int choice = 0;
        try {
            do {
                List<Transaction> transactions = transactionService.getTransactionsByAccountId(account.getId());
                List<Transaction> completedTransactionList = new ArrayList<>();
                List<String> optionList = new ArrayList();
                optionList.add("Start a transfer");
                if (transactions != null && transactions.size() > 0) {
                    for (Transaction t : transactions) {
                        if (t != null) {
                            if (t.getStatus().equalsIgnoreCase("COMPLETED") || t.getStatus().equalsIgnoreCase("REJECTED")) {
                                completedTransactionList.add(t);
                                continue;
                            }
                        }
                    }
                    transactions.removeAll(completedTransactionList);
                    for (Transaction t : transactions) {
                        String option = formatTransaction(account, t);
                        optionList.add(option);
                    }
                }

                if (completedTransactionList.size() > 0) optionList.add("Completed Transactions");
                optionList.add("Exit");
                String[] options = optionList.stream().toArray(String[]::new);
                optionCount = options.length;
                log.info(MenuFormatting.createOptionsMenu("Transfers | " + account.toString(), options));

                choice = InputUtil.getIntInput();
                if (choice == 1) {
                    startCreateTransactionMenu(account);
                } else if (completedTransactionList.size() > 0 && choice == 2) {
                    startCreateCompletedTransactionMenu(account, completedTransactionList);
                } else if (transactions.size() > 0) {
                    startViewTransactionMenu(account, transactions.get(choice - 2));
                }

                try {
                    account = accountSearchService.getAccountById(account.getId());
                } catch (BankException e) {
                    log.warn("Unable to update account information " + e.getMessage());
                }
            } while (choice != optionCount);
        } catch (BankException e) {
            log.warn(e.getMessage());
        }
    }

    private static void startCreateCompletedTransactionMenu(Account account, List<Transaction> transactions) {
        int choice = 0;
        int optionCount = 0;
        do {
            List<String> options = new ArrayList<>();
            for (Transaction t : transactions) {
                String option = formatTransaction(account, t);
                options.add(option);
            }
            options.add("Pending Transfers");
            String[] optionsArray = options.stream().toArray(String[]::new);
            optionCount = options.size();
            log.info(MenuFormatting.createOptionsMenu("Completed Transactions | " + account.toString(), optionsArray));
            choice = InputUtil.getIntInput();
            if (choice > 0 && choice <= optionCount && optionsArray != null && optionsArray.length > 0) {
                startViewTransactionMenu(account, transactions.get(choice - 1));
            }
        } while (choice != optionCount);
    }

    public static void startViewTransactionMenu(Account account, Transaction transaction) {
        int choice = 0;
        String[] options;
        do {
            boolean isActionable = !(transaction.getStatus().equalsIgnoreCase("COMPLETED") || transaction.getStatus().equalsIgnoreCase("REJECTED"));

            if (isActionable) options = new String[]{"Accept Transaction", "Reject Transaction", "Transfers"};
            else options = new String[]{"Transfers"};
            log.info(MenuFormatting.createOptionsMenu(formatTransaction(account, transaction), options));
            choice = InputUtil.getIntInput();
            switch (choice) {
                case 1:
                    if ((account.getId() == transaction.getAccount_from() && account.getId() == transaction.getAccount_to()) || account.getId() == transaction.getAccount_to()) {
                        try {
                            transactionService.completeTransaction(transaction);
                        } catch (BankException e) {
                            log.info(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    if ((account.getId() == transaction.getAccount_from() && account.getId() == transaction.getAccount_to()) || account.getId() == transaction.getAccount_to()) {
                        try {
                            transactionService.rejectTransaction(transaction);
                        } catch (BankException e) {
                            log.info(e.getMessage());
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    log.info("Invalid input, you must select an option (1-3)...");
                    break;
            }
            transaction = transactionService.getTransactionById(transaction.getId());
        } while (choice != options.length);


    }

    // Make transaction pretty and readable
    private static String formatTransaction(Account account, Transaction transaction) {
        String amount = NumberFormat.getCurrencyInstance(Locale.US).format(transaction.getAmount());
        String going = transaction.getAccount_from() == account.getId() ? " | Outgoing : " : " | Incoming : ";
        String destination = transaction.getAccount_to() == account.getId() ? " | From : #" + transaction.getAccount_from() : " | Destination : #" + transaction.getAccount_to();
        String status = "Status : " + transaction.getStatus();
        String timestamp = " | Created : " + transaction.getTimestamp();
        return status + going + amount + destination + timestamp;
    }

    public static void startCreateTransactionMenu(Account account) {
        int choice = 0;
        try {
            log.info("Please input the account number you would like to transfer funds to");
            int account_id = InputUtil.getIntInput();
            log.info("Please input the amount you would like to transfer to account #" + account_id);
            double amount = InputUtil.getDoubleInput();
            transactionService.createTransaction(account.getId(), account_id, amount);
            account = accountSearchService.getAccountById(account.getId());
        } catch (BankException e) {
            log.warn(e.getMessage());
        }
    }
}
