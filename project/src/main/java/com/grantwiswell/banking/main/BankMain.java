package com.grantwiswell.banking.main;

import com.grantwiswell.banking.util.InputUtil;
import com.grantwiswell.banking.util.menu.Menu;
import com.grantwiswell.banking.util.menu.MenuOption;
import com.grantwiswell.banking.view.CustomerView;
import com.grantwiswell.banking.view.EmployeeView;
import org.apache.log4j.Logger;

public class BankMain {

    private static Logger log = Logger.getLogger(BankMain.class);

    private static final char smiley = '\uD83D';

    public static void main(String[] args) {
        // Create a list of MenuOption to use for the menu
        Menu mainMenu = new Menu("Wiswell Bank", "Exit Application");
        mainMenu.addOption(new MenuOption("Returning Customer Login", x -> new CustomerView().startReturningLoginDialog()));
        mainMenu.addOption(new MenuOption("New Customer Login", x -> new CustomerView().startNewCustomerDialog()));
        mainMenu.addOption(new MenuOption("Employee Login", x -> new EmployeeView().showView()));

        InputUtil.setMessagePrompt("Welcome to the Wiswell Banking application!\n");
        mainMenu.startMenu();

        log.info("Thank you for banking with Wiswell Bank! Have a great day! \uD83D\uDE00");
        log.debug("Application closed");
    }
}
