package com.banking.util.menu;

import com.banking.model.Customer;
import com.banking.util.InputUtil;

public class AccountMenu {
    public static void startAccountMenu(Customer customer){
        int choice = 0;
        do{
            int accountNumberLength = customer.getAccounts().size();
            String[] accountStrings = new String[accountNumberLength];

            for(int i = 0; i < accountNumberLength; i++){
                accountStrings[i] = String.valueOf(customer.getAccounts().get(i));
            }

            System.out.println(MenuFormatting.createOptionsMenu("Accounts | " + customer.getName() + " | " + customer.getContactEmail(), accountStrings));

            choice = InputUtil.getIntInput();

            //TODO Implement account menu options
            /*
            switch (choice){
                case 1:
                    break;
            }
            */
        }while(choice != 3);
    }
}
