package com.banking.util.menu;

import com.banking.dao.AccountCrudDao;
import com.banking.exception.BankException;
import com.banking.model.Customer;
import com.banking.service.AccountCrudService;
import com.banking.service.CustomerCrudService;
import com.banking.service.CustomerLoginService;
import com.banking.service.impl.AccountCrudServiceImpl;
import com.banking.service.impl.CustomerCrudServiceImpl;
import com.banking.service.impl.CustomerLoginServiceImpl;
import com.banking.util.InputUtil;

import java.util.ArrayList;
import java.util.List;

public class CustomerMenu {

    private static CustomerLoginService customerLoginService = new CustomerLoginServiceImpl();
    private static CustomerCrudService customerCrudService = new CustomerCrudServiceImpl();
    private static AccountCrudService accountCrudService = new AccountCrudServiceImpl();

    public static void startCustomerLoginDialog() {
        int choice = 0;
        System.out.println(MenuFormatting.createOptionsMenu("Customer Login", "Returning Customer", "New Customer", "<- Main Menu"));
        choice = InputUtil.getIntInput();
        do {
            switch (choice) {
                case 1:
                    startReturningLoginDialog();
                    break;
                case 2:
                    startNewCustomerDialog();
                    break;
                case 3:
                    break;
            }
        } while (choice != 3);
    }

    public static void startNewCustomerDialog() {
        System.out.println("Please input an email to be associated with your account...");
        String email = InputUtil.getStringInput();
        System.out.println("Please input your desired password...");
        String password = InputUtil.getStringInput();
        System.out.println("Please input your full name...");
        String name = InputUtil.getStringInput();

        try {
            customerCrudService.createNewCustomer(email, password, name);
            Customer customer = customerLoginService.getCustomerFromLogin(email, password);
            if (customer != null) startCustomerLoggedInMenu(customer);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void startReturningLoginDialog() {
        do {
            try {
                System.out.println("Type \"exit\" to return to the main menu\n");
                System.out.println("Please input the email associated with your account...");
                String email = InputUtil.getStringInput();
                // Exit the login if the user wants to return to the main menu
                if (email == "exit" || email == "quit" || email == "q" || email == "e") return;

                System.out.println("Please input your account password...");
                String password = InputUtil.getStringInput();
                if (email == "exit" || email == "quit" || email == "q" || email == "e") return;

                Customer customer = customerLoginService.getCustomerFromLogin(email, password);
                if (customer != null) {
                    startCustomerLoggedInMenu(customer);
                }
            } catch (BankException e) {
                System.out.println(e.getMessage());
            }
        } while (InputUtil.getStringInput() != "exit");
    }

    public static void startCustomerLoggedInMenu(Customer customer) {
        int choice = 0;
        do {
            // Add choices to a list to choose from
            List<String> choices = new ArrayList<>();
            if (customer.getAccounts().size() > 0)
                choices.add("View Account" + ((customer.getAccounts().size() > 1) ? "s" : ""));
            choices.add("Open A New Account");
            choices.add("Logout");

            String[] choiceArray = choices.stream().toArray(String[]::new);

            System.out.println(MenuFormatting.createOptionsMenu(customer.getName() + " | " + customer.getContactEmail(), choiceArray));

            choice = InputUtil.getIntInput();
            if (choiceArray.length == 2) {
                switch(choice){
                    case 1:
                        createNewAccountDialog(customer);
                        break;
                    case 2:

                        break;
                }
            } else if (choiceArray.length == 3) {
                switch(choice){
                    case 1:
                        System.out.println(customer.getAccounts().toString());
                        break;
                    case 2:
                        createNewAccountDialog(customer);
                        break;
                    case 3:
                        break;
                }
            }
/*
            switch (choice){
                case 1:
                    AccountMenu.startAccountMenu(customer);
                    break;
                case 2: System.out.println("Creating a new account is under development, please try again soon!");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid input, please input one of the options listed...");
            }
 */
        } while (choice != 3);
    }

    public static void createNewAccountDialog(Customer customer){
        System.out.println("Please enter a name for your new account");
        String accountName = InputUtil.getStringInput();
        System.out.println("What will your starting balance be in your account?");
        double balance = InputUtil.getDoubleInput();
        try{
            accountCrudService.createNewAccount(customer.getId(), balance, accountName);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }
}
