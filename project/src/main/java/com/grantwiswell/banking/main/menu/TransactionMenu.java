package com.grantwiswell.banking.main.menu;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Transaction;
import com.grantwiswell.banking.service.AccountSearchService;
import com.grantwiswell.banking.service.TransactionService;
import com.grantwiswell.banking.service.impl.AccountSearchServiceImpl;
import com.grantwiswell.banking.service.impl.TransactionServiceImpl;
import com.grantwiswell.banking.util.InputUtil;
import org.apache.log4j.Logger;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TransactionMenu {

    private static TransactionService transactionService = new TransactionServiceImpl();
    private static AccountSearchService accountSearchService = new AccountSearchServiceImpl();
    private static Logger log = Logger.getLogger(TransactionMenu.class);

    public static void startTransactionListMenu(Account account){
        int optionCount = 0;
        int choice = 0;
        try {
            do {
                List<Transaction> transactions = transactionService.getTransactions(account.getId());
                List<String> optionList = new ArrayList();

                for(Transaction t:transactions){
                    if(t.getAccount_from() == account.getId()){
                        optionList.add("Outgoing : " + NumberFormat.getCurrencyInstance(Locale.US).format(t.getAmount())
                                + " | Destination : #"+t.getAccount_to()
                                + " | Status : " + t.getStatus() + " | Date Created : "+t.getDate_created());
                    }
                    else{
                        optionList.add("INCOMING");
                    }
                }

                optionList.add("Start a transfer");
                optionList.add("<- Exit");
                String[] options = optionList.stream().toArray(String[]::new);
                optionCount = options.length;
                log.info(MenuFormatting.createOptionsMenu("Transfers | " + account.toString(), options));

                choice = InputUtil.getIntInput();
                if (choice == optionCount - 1) {
                    startCreateTransactionMenu(account);
                }

                for (int i = 0; i < optionCount; i++) {

                }
            } while (choice != optionCount);
        } catch (BankException e) {
            log.info(e.getMessage());
        }
    }

    public static void startCreateTransactionMenu(Account account){
        int choice = 0;
        try{
                log.info("Please input the account number you would like to transfer funds to");
                int account_id = InputUtil.getIntInput();
                log.info("Please input the amount you would like to transfer to account #"+account_id);
                double amount = InputUtil.getDoubleInput();
                transactionService.createTransaction(account.getId(), account_id, amount);
                account = accountSearchService.getAccountById(account.getId());
        } catch (BankException e) {
            log.info(e.getMessage());
        }
    }
}
