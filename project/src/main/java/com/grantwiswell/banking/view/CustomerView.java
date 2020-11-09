package com.grantwiswell.banking.view;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.util.menu.Menu;
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
import org.apache.log4j.Logger;

public class CustomerView {

    private static Logger log = Logger.getLogger(CustomerView.class);
    private CustomerLoginService customerLoginService = new CustomerLoginServiceImpl();
    private CustomerCrudService customerCrudService = new CustomerCrudServiceImpl();
    private AccountCrudService accountCrudService = new AccountCrudServiceImpl();
    private CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();

    private Customer customer;

    public void startNewCustomerDialog() {
        log.info("Please input an email to be associated with your account...");
        String email = InputUtil.getStringInput();
        log.info("Please input your desired password...");
        String password = InputUtil.getStringInput();
        log.info("Please input your first and last name...");
        String full_name = InputUtil.getStringInput();
        log.info("Please input your date of birth in mm-dd-yyyy format");
        String dob = InputUtil.getStringInput();

        try {
            if (customerCrudService.createNewCustomer(email, password, full_name, dob)) {
                customer = customerLoginService.getCustomerFromLogin(email, password);
                log.info("Customer found! : " + customer.toString());
            }
            if (customer != null) startCustomerLoggedInMenu();
        } catch (BankException e) {
            log.warn(e.getMessage());
        }
    }

    public void startReturningLoginDialog() {
        try {
            log.info("Please input the email associated with your account...");
            String email = InputUtil.getStringInput();
            log.info("Please input your account password...");
            String password = InputUtil.getStringInput();

            customer = customerLoginService.getCustomerFromLogin(email, password);
            if (customer != null) {
                startCustomerLoggedInMenu();
            }
        } catch (BankException e) {
            log.warn(e.getMessage());
        }
    }

    public void startCustomerLoggedInMenu() {
        try {
            customer = customerSearchService.getCustomerById(customer.getId());
        } catch (BankException e) {
            e.getMessage();
        }
        String menuTitle = customer.getFirst_name() + " " + customer.getLast_name() + " | " + customer.getContactEmail();
        Menu customerLoggedInMenu = new Menu(menuTitle, "Logout").setIsLooping(false);
        customerLoggedInMenu.setAfterLoopConsumer(x -> startCustomerLoggedInMenu());
        customerLoggedInMenu.setBeforePrintConsumer(x -> customer = customerSearchService.getCustomerById(customer.getId()));
        if (customer.getAccounts().size() > 0)
            customerLoggedInMenu.addOption("View Account" + (customer.getAccounts().size() > 1 ? "s" : ""), x -> new AccountView().startAccountListMenu(customer));
        customerLoggedInMenu.addOption("Open a new account", x -> createNewAccountDialog());

        customerLoggedInMenu.startMenu();
    }

    public void createNewAccountDialog() {
        log.info("Please enter a name for your new account");
        String accountName = InputUtil.getStringInput();
        log.info("What will your starting balance be in your account?");
        double balance = InputUtil.getDoubleInput();
        try {
            accountCrudService.createNewAccount(customer.getId(), balance, accountName);
            log.info("Account \""+accountName+"\" created. Please contact an employee to have your account approved for use");
        } catch (BankException e) {
            log.warn(e.getMessage());
        }
    }
}
