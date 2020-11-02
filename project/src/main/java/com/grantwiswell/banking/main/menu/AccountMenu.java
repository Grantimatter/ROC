package com.grantwiswell.banking.main.menu;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.service.AccountCrudService;
import com.grantwiswell.banking.service.AccountSearchService;
import com.grantwiswell.banking.service.impl.AccountCrudServiceImpl;
import com.grantwiswell.banking.service.impl.AccountSearchServiceImpl;
import com.grantwiswell.banking.util.FormatStrings;
import com.grantwiswell.banking.util.InputUtil;

import java.text.NumberFormat;
import java.util.Locale;

public class AccountMenu {

    private static AccountCrudService accountCrudService = new AccountCrudServiceImpl();
    private static AccountSearchService accountSearchService = new AccountSearchServiceImpl();

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

                optionStrings[optionStrings.length-1] = "<- Customer Menu";

                System.out.println(MenuFormatting.createOptionsMenu("Accounts | " + customer.getFirst_name() +" " + customer.getLast_name() + " | "+ customer.getContactEmail() + " | Total Balance : "+ NumberFormat.getCurrencyInstance(Locale.US).format(totalBalance), optionStrings));
                choice = InputUtil.getIntInput();
                for(int i = 0; i < accountNumberLength; i++){
                    if(choice - 1 == i){
                        startAccountViewMenu(customer.getAccounts().get(i));
                    }
                }
            } while(choice != accountNumberLength + 1);
    }

    private static void startAccountViewMenu(Account account){
        int choice = 0;
        do{
            try{
                account = accountSearchService.getAccountByNumber(account.getNumber());
                System.out.println(MenuFormatting.createOptionsMenu(account.toString(), "Make A Deposit", "Make A Withdrawal", "Transfer Funds", "Delete Account", "<- View Accounts"));
                choice = InputUtil.getIntInput();
                switch (choice){
                    case 1:
                        try{
                            System.out.println("Please input the amount you would like to deposit...");
                            double amount = InputUtil.getDoubleInput();
                            accountCrudService.depositToAccount(amount, account.getNumber());
                            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(amount) + " deposited into " + account.getName());
                        }catch(BankException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        try{
                        System.out.println("Please input the amount you would like to withdrawal...");
                        double amount = InputUtil.getDoubleInput();
                        accountCrudService.withdrawalFromAccount(amount, account);
                        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(amount) + " withdrawn from " + account.getName());
                        }catch(BankException e){
                        System.out.println(e.getMessage());
                    }
                        break;
                    case 3: System.out.println("Transferring is not yet implemented. Please check back soon!");
                        break;
                    case 4: System.out.println("Deleting Account is not yet implemented. Please check back soon!");
                        break;
                    case 5:
                        break;

                    default: System.out.println("Please select a valid option (1-5)");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while(choice != 5);
    }
}
