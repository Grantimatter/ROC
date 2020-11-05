package com.grantwiswell.banking.main;

import com.grantwiswell.banking.util.InputUtil;
import com.grantwiswell.banking.view.CustomerView;
import com.grantwiswell.banking.main.menu.MenuFormatting;
import org.apache.log4j.Logger;

public class BankMain {

    private static Logger log = Logger.getLogger(BankMain.class);

    public static void main(String[] args) {

        int choice = 0;
        log.info("Welcome to the Banking App!");
        do {
            log.info(MenuFormatting.createOptionsMenu("Main Menu","Customer Login", "Employee Login", "Exit"));
            choice = InputUtil.getIntInput();
            switch (choice){
                case 1:
                    CustomerView.startCustomerLoginDialog();
                    break;
                case 2: log.info("Option not yet implemented, try again soon!");
                    break;
                case 3: log.info("Thank you for using the Banking App. Have a great day!");
                    break;
                default: log.info("Incorrect choice, please input a value found on the menu (1-3)");
                    break;
            }
        }while(choice != 3);
        log.debug("Application closed");
    }
}
