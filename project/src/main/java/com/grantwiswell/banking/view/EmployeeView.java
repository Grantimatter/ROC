package com.grantwiswell.banking.view;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.model.Transaction;
import com.grantwiswell.banking.service.AccountSearchService;
import com.grantwiswell.banking.service.CustomerCrudService;
import com.grantwiswell.banking.service.CustomerSearchService;
import com.grantwiswell.banking.service.TransactionService;
import com.grantwiswell.banking.service.impl.AccountSearchServiceImpl;
import com.grantwiswell.banking.service.impl.CustomerCrudServiceImpl;
import com.grantwiswell.banking.service.impl.CustomerSearchServiceImpl;
import com.grantwiswell.banking.service.impl.TransactionServiceImpl;
import com.grantwiswell.banking.util.menu.Menu;
import com.grantwiswell.banking.util.menu.MenuFormatting;
import com.grantwiswell.banking.model.Employee;
import com.grantwiswell.banking.service.EmployeeLoginService;
import com.grantwiswell.banking.service.impl.EmployeeLoginServiceImpl;
import com.grantwiswell.banking.util.InputUtil;
import com.grantwiswell.banking.util.menu.MenuOption;
import javafx.scene.input.Mnemonic;
import org.apache.log4j.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import sun.util.resources.cldr.so.CurrencyNames_so;

import java.util.ArrayList;
import java.util.List;

public class EmployeeView {

    private static Logger log = Logger.getLogger(EmployeeView.class);
    private EmployeeLoginService employeeLoginService = new EmployeeLoginServiceImpl();
    private CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
    private AccountSearchService accountSearchService = new AccountSearchServiceImpl();
    private TransactionService transactionService = new TransactionServiceImpl();
    private CustomerCrudService customerCrudService = new CustomerCrudServiceImpl();

    private Employee employee;

    public void showView(){
        if(employee == null) startEmployeeLoginDialog();
        if(employee == null) return;
        viewEmployeeLoggedInMenu();
    }

    public void startEmployeeLoginDialog(){
        log.info("Input your employee username");
        String user_name = InputUtil.getStringInput();
        log.info("Input your employee password");
        String password = InputUtil.getStringInput();
        try{
            employee = employeeLoginService.employeeLogin(user_name,password);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
    }

    public void viewEmployeeLoggedInMenu(){

        Menu employeeMenu = new Menu(employee.toString(), "Logout");
        employeeMenu.addOption("Search Functions", x -> viewEmployeeSearchOptions());
        employeeMenu.addOption("View Pending Users", x -> viewPendingUsersList());
        employeeMenu.addOption("View Pending Accounts", x -> viewPendingAccountsList());
        employeeMenu.addOption("View All Transactions", x -> viewAllTransactionsList());
        employeeMenu.startMenu();
    }

    public void viewEmployeeSearchOptions(){
        throw new NotImplementedException();
    }

    public List<MenuOption> getUserMenuOptionsFromList(List<Customer> customers){
        List<MenuOption> menuOptionList = new ArrayList<>();
        for (Customer c:customers){
            menuOptionList.add(new MenuOption(c.toString(), x -> viewPendingUserActions(c)));
        }
        return menuOptionList;
    }

    public void viewPendingUsersList(){
        List<Customer> pendingCustomers = new ArrayList<>();
        try {
            pendingCustomers = customerSearchService.getCustomersByStatus("PENDING");
        } catch (BankException e) {
            log.error(e.getMessage());
        }

        Menu pendingUsersListMenu = new Menu("Pending Users", "Employee Menu");
        pendingUsersListMenu.addOptions(getUserMenuOptionsFromList(pendingCustomers));

        pendingUsersListMenu.startMenu();
    }

    public void viewPendingUserActions(Customer customer){
        int choice = 0;
        do{
            log.info(MenuFormatting.createOptionsMenu( "PENDING USER: " + customer.toString(), "Pending Users", "Accept User", "Reject User"));
            choice = InputUtil.getIntInput();
            switch (choice){
                case 1:
                    break;
            }
        }while(choice != 3);
    }

    public void viewPendingAccountsList(){
        int choice = 0;
        List<Account> pendingAccounts = new ArrayList<>();
        do {
            try {
                // Retrieve list of pending accounts
                pendingAccounts = accountSearchService.getAccountsByStatus("PENDING");
                if (pendingAccounts.size() == 0){
                    log.info("There are no pending accounts!");
                    return;
                }
                String[] pendingAccountStrings = new String[pendingAccounts.size()];
                for (int i = 0; i < pendingAccountStrings.length; i++) {
                    pendingAccountStrings[i] = pendingAccounts.get(i).toString();
                }

                // Print out pending accounts menu and get selection
                log.info(MenuFormatting.createOptionsMenu("Pending Accounts", "Employee Menu", pendingAccountStrings));
                choice = InputUtil.getIntInput();

                // Get the account chosen
                if(choice > 0 && choice <= pendingAccounts.size()){
                    viewPendingAccountMenu(pendingAccounts.get(choice - 1));
                }else if(choice != pendingAccounts.size() + 1){
                    log.info("Not a valid choice! Please choose a valid option... (1-"+(pendingAccounts.size()+1)+")");
                }

            } catch (BankException e) {
                log.warn(e.getMessage());
            }
        }while (choice != pendingAccounts.size() + 1);
    }

    public void viewPendingAccountMenu(Account account){

        Menu pendingAccountMenu = new Menu(account.toString(), "Pending Accounts");
        pendingAccountMenu.addOption("Accept Account", x -> acc.acceptCustomer());

        int choice = 0;
        do{
            try{
                log.info(MenuFormatting.createOptionsMenu(account.toString(), "Pending Accounts", "Accept Account", "Reject Account"));
                choice = InputUtil.getIntInput();
                switch (choice){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default: log.warn("Invalid option chosen, please try again!");
                        break;
                }

            } catch (BankException e) {
                log.warn(e.getMessage());
            }
        }while(choice != 3);
    }

    public void viewAllTransactionsList(){
        List<Transaction> transactionList;
        try{
            transactionList = transactionService.getAllTransactions();
            for(Transaction t:transactionList){
                log.info(t.toString());
            }
        } catch (BankException e) {
            log.warn(e.getMessage());
        }
    }
}
