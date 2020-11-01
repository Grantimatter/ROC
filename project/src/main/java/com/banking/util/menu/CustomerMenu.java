package com.banking.util.menu;

import com.banking.exception.BankException;
import com.banking.model.Customer;
import com.banking.service.CustomerCrudService;
import com.banking.service.CustomerLoginService;
import com.banking.service.impl.CustomerCrudServiceImpl;
import com.banking.service.impl.CustomerLoginServiceImpl;
import com.banking.util.InputUtil;

public class CustomerMenu {

    private static CustomerLoginService customerLoginService = new CustomerLoginServiceImpl();
    private static CustomerCrudService customerCrudService = new CustomerCrudServiceImpl();

    public static void startReturningLoginDialog(){
        do{
            try{
                System.out.println("Type \"exit\" to return to the main menu\n");
                System.out.println("Please input the email associated with your account...");
                String email = InputUtil.getStringInput();
                // Exit the login if the user wants to return to the main menu
                if(email == "exit" || email == "quit" || email == "q" || email == "e") return;

                System.out.println("Please input your account password...");
                String password = InputUtil.getStringInput();
                if(email == "exit" || email == "quit" || email == "q" || email == "e") return;

                Customer customer = customerLoginService.validateLogin(email, password);
                if(customer!=null){
                    startCustomerAccountMenu(customer);
                }
            } catch(BankException e){
                System.out.println(e.getMessage());
            }
        }while(InputUtil.getStringInput() != "exit");
    }

    public static void startNewCustomerDialog(){
        System.out.println("Please input an email to be associated with your account...");
        String email = InputUtil.getStringInput();
        System.out.println("Please input your desired password...");
        String password = InputUtil.getStringInput();
        System.out.println("Please enter your name");
        String name = InputUtil.getStringInput();

        customerCrudService.createNewCustomer(email, password, name);
    }

    public static void startCustomerLoginDialog(){
        int choice = 0;
        System.out.println(MenuFormatting.createOptionsMenu("Customer Login", "Returning Customer", "New Customer", "<- Main Menu"));
        choice = InputUtil.getIntInput();
        do{
            switch (choice){
                case 1:
                    startReturningLoginDialog();
                    break;
                case 2:
                    startNewCustomerDialog();
                case 3:
                    break;
            }
        }while(choice != 3);
    }

    public static void startCustomerAccountMenu(Customer customer){
        int choice = 0;
        do{
            System.out.println(MenuFormatting.createOptionsMenu(customer.getName() + " | " + customer.getContactEmail(), "View Account(s)", "Create a New Account", "Logout"));
            choice = InputUtil.getIntInput();
            switch (choice){
                case 1:
                    AccountMenu.startAccountMenu(customer);
                    break;
                case 2:
                    break;
                case 3:
                    break;

                default:
                    System.out.println("Invalid input, please input one of the options listed...");
            }
        }while(choice != 3);
    }
}
