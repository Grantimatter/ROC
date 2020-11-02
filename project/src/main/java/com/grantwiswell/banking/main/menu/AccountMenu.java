package com.grantwiswell.banking.main.menu;

import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.util.InputUtil;

import java.text.NumberFormat;
import java.util.Locale;

public class AccountMenu {
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
                        startAccountViewMenu(customer, i);
                    }
                }
            } while(choice != accountNumberLength + 1);
    }

    private static void startAccountViewMenu(Customer customer, int accountIndex){
        int choice = 0;
        do{
            Account account = customer.getAccounts().get(accountIndex);
            System.out.println(MenuFormatting.createOptionsMenu(account.toString(), "Make A Deposit", "Make A Withdrawal", "Transfer Funds", "Delete Account", "<- View Accounts"));
            try{
                choice = InputUtil.getIntInput();
                switch (choice){
                    case 1: System.out.println("Depositing is not yet implemented. Please check back soon!");
                        break;
                    case 2: System.out.println("Withdrawal is not yet implemented. Please check back soon!");
                        break;
                    case 3: System.out.println("Transferring is not yet implemented. Please check back soon!");
                        break;
                    case 4: System.out.println("Deleting Account is not yet implemented. Please check back soon!");
                        break;
                    case 5:
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while(choice != 5);
    }
}
