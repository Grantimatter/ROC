package com.banking.util.menu;

import com.banking.exception.BankException;
import com.banking.model.Customer;
import com.banking.service.CustomerLoginService;
import com.banking.service.impl.CustomerLoginServiceImpl;
import com.banking.util.CustomerUtil;
import com.banking.util.InputUtil;

import java.util.Scanner;

public class CustomerMenus {

    CustomerLoginService customerLoginService = new CustomerLoginServiceImpl();

    public void startLoginDialog(){
        do{
            try{
                System.out.println("Type \"exit\" to return to the main menu\n");
                System.out.println("Please input the email associated with your account");
                String email = InputUtil.getStringInput();
                System.out.println("Please input your account password");
                String password = InputUtil.getStringInput();
                Customer customer = customerLoginService.validateLogin(email, password);
                if(customer!=null){
                    startCustomerMenuLoggedIn(customer);
                }
            } catch(BankException e){
                System.out.println(e.getMessage());
            }
        }while(InputUtil.getStringInput() != "exit");
    }

    public void startCustomerMenuLoggedIn(Customer customer){
        int choice = 0;
        do{
            System.out.println(MenuFormatting.createOptionsMenu(customer.getName() + " | " + customer.getContactEmail(), "View Account(s)", "Create a New Account"));
            choice = InputUtil.getIntInput();
            switch (choice){
                case 1:
                        int account = InputUtil.getIntInput();
                        if(customer.getAccountNumbers() != null && customer.getAccountNumbers().length > 0){
                            startAccountMenu(customer);
                        }
                    break;
            }
        }while(choice != 4);
    }

    public void startAccountMenu(Customer customer){
        int choice = 0;
        do{
            String[] accountStrings = new String[] {customer.getAccountNumbers().toString()};
            MenuFormatting.createOptionsMenu("Accounts", accountStrings);
            choice = InputUtil.getIntInput();
            switch (choice){
                case 1:
                    break;
            }
        }while(choice != 3);
    }

    public void startCreateAccountMenu(Customer customer, Scanner scanner){

    }
}
