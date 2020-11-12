package com.grantwiswell.banking.view;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.model.Transaction;
import com.grantwiswell.banking.service.AccountCrudService;
import com.grantwiswell.banking.service.AccountSearchService;
import com.grantwiswell.banking.service.CustomerCrudService;
import com.grantwiswell.banking.service.CustomerSearchService;
import com.grantwiswell.banking.service.TransactionService;
import com.grantwiswell.banking.service.impl.AccountCrudServiceImpl;
import com.grantwiswell.banking.service.impl.AccountSearchServiceImpl;
import com.grantwiswell.banking.service.impl.CustomerCrudServiceImpl;
import com.grantwiswell.banking.service.impl.CustomerSearchServiceImpl;
import com.grantwiswell.banking.service.impl.TransactionServiceImpl;
import com.grantwiswell.banking.util.menu.Menu;
import com.grantwiswell.banking.model.Employee;
import com.grantwiswell.banking.service.EmployeeLoginService;
import com.grantwiswell.banking.service.impl.EmployeeLoginServiceImpl;
import com.grantwiswell.banking.util.InputUtil;
import com.grantwiswell.banking.util.menu.MenuOption;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class EmployeeView {

    private static Logger log = Logger.getLogger(EmployeeView.class);
    private EmployeeLoginService employeeLoginService = new EmployeeLoginServiceImpl();
    private CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
    private AccountSearchService accountSearchService = new AccountSearchServiceImpl();
    private TransactionService transactionService = new TransactionServiceImpl();
    private CustomerCrudService customerCrudService = new CustomerCrudServiceImpl();
    private AccountCrudService accountCrudService = new AccountCrudServiceImpl();

    private Employee employee;

    public void showView() {
        if (employee == null) startEmployeeLoginDialog();
        if (employee == null) return;
        viewEmployeeLoggedInMenu();
    }

    public void startEmployeeLoginDialog() {
        log.info("Input your employee username");
        String user_name = InputUtil.getStringInput();
        log.info("Input your employee password");
        String password = InputUtil.getStringInput();
        try {
            employee = employeeLoginService.employeeLogin(user_name, password);
        } catch (Exception e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
    }

    public void viewEmployeeLoggedInMenu() {
        Menu employeeMenu = new Menu(employee.toString(), "Logout");
        employeeMenu.addOption("Search Functions", x -> new EmployeeFunctionsView().viewSearchFunctionsMenu());
        employeeMenu.addOption("View Pending Users", x -> viewPendingUsersList());
        employeeMenu.addOption("View Pending Accounts", x -> viewPendingAccountsList());
        employeeMenu.addOption("View All Transactions", x -> viewAllTransactionsList());
        employeeMenu.startMenu();
    }

    public List<MenuOption> getUserMenuOptionsFromList(List<Customer> customers) {
        List<MenuOption> menuOptionList = new ArrayList<>();
        for (Customer c : customers) {
            menuOptionList.add(new MenuOption(c.toString(), x -> viewPendingUserActions(c)));
        }
        return menuOptionList;
    }

    public void viewPendingUsersList() {
        List<Customer> pendingCustomers = new ArrayList<>();
        try {
            pendingCustomers = customerSearchService.getCustomersByStatus("PENDING");
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }

        Menu pendingUsersListMenu = new Menu("Pending Users", "Employee Menu").setIsLooping(false);
        pendingUsersListMenu.setAfterLoopConsumer(x -> viewPendingUsersList());
        pendingUsersListMenu.addOptions(getUserMenuOptionsFromList(pendingCustomers));

        pendingUsersListMenu.startMenu();
    }

    public void viewPendingUserActions(Customer customer) {
        Customer updatedCustomer = customerSearchService.getCustomerById(customer.getId());
        Menu pendingUserActionMenu = new Menu(customer.toString() + " | Status: " + customer.getStatus(), "Pending Users").setIsLooping(false);
        pendingUserActionMenu.setAfterLoopConsumer(x -> viewPendingUserActions(updatedCustomer));
        if (updatedCustomer.getStatus().equalsIgnoreCase("PENDING")) {
            pendingUserActionMenu.addOption("Accept User", x -> customerCrudService.acceptCustomer(updatedCustomer.getId()));
            pendingUserActionMenu.addOption("Reject User", x -> customerCrudService.rejectCustomer(updatedCustomer.getId()));
        }

        pendingUserActionMenu.startMenu();
    }

    public List<MenuOption> getMenuOptionsFromAccountList(List<Account> accountList) {
        List<MenuOption> menuOptionList = new ArrayList<>();
        for (Account acc : accountList) {
            menuOptionList.add(new MenuOption(acc.toString(), x -> viewPendingAccountMenu(acc)));
        }
        return menuOptionList;
    }

    public void viewPendingAccountsList() {
        List<Account> pendingAccountList = new ArrayList<>();
        try {
            pendingAccountList = accountSearchService.getAccountsByStatus("PENDING");
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
        Menu pendingAccountListMenu = new Menu("Pending Accounts", "Employee Menu").setIsLooping(false);
        pendingAccountListMenu.setAfterLoopConsumer(x -> viewPendingAccountsList());
        if (pendingAccountList != null && pendingAccountList.size() > 0) {
            pendingAccountListMenu.addOptions(getMenuOptionsFromAccountList(pendingAccountList));
        }
        pendingAccountListMenu.startMenu();
    }

    public void viewPendingAccountMenu(Account account) {
        try {
            Account updatedAccount = accountSearchService.getAccountById(account.getId());

            Menu pendingAccountMenu = new Menu(account.toString(), "Pending Accounts").setIsLooping(false);
            pendingAccountMenu.setAfterLoopConsumer(x -> viewPendingAccountMenu(updatedAccount));
            if (updatedAccount.getStatus().equalsIgnoreCase("PENDING")) {
                pendingAccountMenu.addOption("Accept Account", x -> accountCrudService.updateAccountStatus(updatedAccount, "ACCEPTED"));
                pendingAccountMenu.addOption("Reject Account", x -> accountCrudService.updateAccountStatus(updatedAccount, "REJECTED"));
            }
            pendingAccountMenu.startMenu();
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
    }

    public void viewAllTransactionsList() {
        List<Transaction> transactionList;
        try {
            transactionList = transactionService.getAllTransactions();
            String allTransactionsString = "";
            for (Transaction t : transactionList) {
                allTransactionsString += t.toString()+"\n";
            }
            InputUtil.setMessagePrompt(allTransactionsString);
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
    }
}
