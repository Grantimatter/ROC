package com.banking.main;

import com.banking.util.InputUtil;
import com.banking.util.menu.CustomerMenu;
import com.banking.util.menu.MenuFormatting;

public class BankMain {

    public static void main(String[] args) {
        int choice = 0;
        System.out.println("Welcome to the Banking App!");
        do {
            System.out.println(MenuFormatting.createOptionsMenu("Main Menu","Customer Login", "Employee Login", "<- Exit"));
            choice = InputUtil.getIntInput();
            switch (choice){
                case 1:
                    CustomerMenu.startCustomerLoginDialog();
                    break;
                case 2: System.out.println("Option not yet implemented, try again soon!");
                    break;
                case 3: System.out.println("Thank you for using the Banking App. Have a great day!");
                    break;
                default: System.out.println("Incorrect choice, please input a value found on the menu (1-3)");
                    break;
            }
        }while(choice != 3);
    }
}
