package com.grantwiswell.banking.main.menu;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.service.AccountCrudService;
import com.grantwiswell.banking.service.AccountSearchService;
import com.grantwiswell.banking.service.CustomerSearchService;
import com.grantwiswell.banking.service.TransactionService;
import com.grantwiswell.banking.service.impl.AccountCrudServiceImpl;
import com.grantwiswell.banking.service.impl.AccountSearchServiceImpl;
import com.grantwiswell.banking.service.impl.CustomerSearchServiceImpl;
import com.grantwiswell.banking.service.impl.TransactionServiceImpl;
import com.grantwiswell.banking.util.InputUtil;
import org.apache.log4j.Logger;

import java.text.NumberFormat;
import java.util.Locale;

public class AccountMenu {

    private static AccountCrudService accountCrudService = new AccountCrudServiceImpl();
    private static AccountSearchService accountSearchService = new AccountSearchServiceImpl();
    private static CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
    private static TransactionService transactionService = new TransactionServiceImpl();

    private static Logger log = Logger.getLogger(AccountMenu.class);

    public static void startAccountListMenu(Customer customer){
        int choice = 0;
        int accountNumberLength = 0;
            do {
                accountNumberLength = customer.getAccounts().size();
                String[] optionStrings = new String[accountNumberLength + 1];
                double totalBalance = 0;

                for(int i = 0; i < accountNumberLength; i++){
                    optionStrings[i] =  "| " + customer.getAccounts().get(i).toString() + " | ";
                    totalBalance += customer.getAccounts().get(i).getBalance();
                }

                optionStrings[optionStrings.length-1] = "Customer Menu";

                log.info(MenuFormatting.createOptionsMenu("Accounts | " + customer.getFirst_name() +" " + customer.getLast_name() + " | "+ customer.getContactEmail() + " | Total Balance : "+ NumberFormat.getCurrencyInstance(Locale.US).format(totalBalance), optionStrings));
                choice = InputUtil.getIntInput();
                for(int i = 0; i < accountNumberLength; i++){
                    if(choice - 1 == i){
                        startAccountViewMenu(customer.getAccounts().get(i));
                    }
                }

                try {
                    customer = customerSearchService.getCustomerById(customer.getId());
                } catch (BankException e) {
                    log.info("Error updating customer information");
                }
            } while(choice != accountNumberLength + 1);
    }

    private static void startAccountViewMenu(Account account){
        int choice = 0;
        do{
                log.info(MenuFormatting.createOptionsMenu(account.toString(), "Make A Deposit", "Make A Withdrawal", "Transfer Funds", "Delete Account", "View Accounts"));
                choice = InputUtil.getIntInput();
                switch (choice){
                    case 1:
                        try{
                            log.info("Please input the amount you would like to deposit...");
                            double amount = InputUtil.getDoubleInput();
                            accountCrudService.depositToAccount(amount, account);
                        }catch(BankException e){
                            log.warn(e.getMessage());
                        }
                        break;
                    case 2:
                        try{
                        log.info("Please input the amount you would like to withdrawal...");
                        double amount = InputUtil.getDoubleInput();
                        accountCrudService.withdrawalFromAccount(amount, account);
                        }catch(BankException e){
                        log.warn(e.getMessage());
                    }
                        break;
                    case 3:
                        TransactionMenu.startTransactionListMenu(account);

                        break;
                    case 4:
                        log.info("Deleting Account is not yet implemented. Please check back soon!");
                        break;
                    case 5:
                        break;

                    default: log.info("Please select a valid option (1-5)");
                        break;
                }
            account = accountSearchService.getAccountById(account.getId());
        }while(choice != 5);
    }
}
