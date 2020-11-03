package com.grantwiswell.banking.main.menu;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.service.AccountCrudService;
import com.grantwiswell.banking.service.CustomerCrudService;
import com.grantwiswell.banking.service.CustomerLoginService;
import com.grantwiswell.banking.service.CustomerSearchService;
import com.grantwiswell.banking.service.impl.AccountCrudServiceImpl;
import com.grantwiswell.banking.service.impl.CustomerCrudServiceImpl;
import com.grantwiswell.banking.service.impl.CustomerLoginServiceImpl;
import com.grantwiswell.banking.service.impl.CustomerSearchServiceImpl;
import com.grantwiswell.banking.util.InputUtil;

import java.util.ArrayList;
import java.util.List;

public class CustomerMenu {

    private static CustomerLoginService customerLoginService = new CustomerLoginServiceImpl();
    private static CustomerCrudService customerCrudService = new CustomerCrudServiceImpl();
    private static AccountCrudService accountCrudService = new AccountCrudServiceImpl();
    private static CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();

    public static void startCustomerLoginDialog() {
        int choice = 0;
        do {
            System.out.println(MenuFormatting.createOptionsMenu("Customer Login", "Returning Customer", "New Customer", "<- Main Menu"));
            choice = InputUtil.getIntInput();
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
        System.out.println("Please input your first and last name...");
        String full_name = InputUtil.getStringInput();

        try {
            Customer customer = null;
            if(customerCrudService.createNewCustomer(email, password, full_name)){
                customer = customerLoginService.getCustomerFromLogin(email, password);
            }
            if (customer != null) startCustomerLoggedInMenu(customer);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void startReturningLoginDialog() {
            try {
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
    }

    public static void startCustomerLoggedInMenu(Customer customer) {
        int choice = 0;
        List<String> choices = new ArrayList<>();
        do {
            choices.clear();
            customer = customerSearchService.getCustomerById(customer.getId());
            System.out.println("Returning updated customer data");

            // Add choices to a list to choose from
            if (customer != null && customer.getAccounts() != null && customer.getAccounts().size() > 0)
                choices.add("View Account" + ((customer.getAccounts().size() > 1) ? "s" : ""));
            choices.add("Open A New Account");
            choices.add("<- Logout");

            String[] choiceArray = choices.stream().toArray(String[]::new);

            System.out.println(MenuFormatting.createOptionsMenu(customer.getFirst_name() + " " + customer.getLast_name() + " | " + customer.getContactEmail(), choiceArray));

            choice = InputUtil.getIntInput();
            if (choiceArray.length == 2) {
                switch(choice){
                    case 1:
                        createNewAccountDialog(customer);
                        break;
                    case 2:

                        break;
                    default: System.out.println("Please input a valid option (1-2)");

                }
            } else if (choiceArray.length == 3) {
                switch(choice){
                    case 1:
                        AccountMenu.startAccountListMenu(customer);
                        break;
                    case 2:
                        createNewAccountDialog(customer);
                        break;
                    case 3:
                        break;
                    default: System.out.println("Please input a valid option (1-3)");
                }
            }

        } while (choice != choices.size());
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