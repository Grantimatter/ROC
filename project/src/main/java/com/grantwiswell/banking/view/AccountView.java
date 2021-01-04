package com.grantwiswell.banking.view;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.util.menu.Menu;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.service.AccountCrudService;
import com.grantwiswell.banking.service.AccountSearchService;
import com.grantwiswell.banking.service.CustomerSearchService;
import com.grantwiswell.banking.service.impl.AccountCrudServiceImpl;
import com.grantwiswell.banking.service.impl.AccountSearchServiceImpl;
import com.grantwiswell.banking.service.impl.CustomerSearchServiceImpl;
import com.grantwiswell.banking.util.InputUtil;
import com.grantwiswell.banking.util.menu.MenuOption;
import org.apache.log4j.Logger;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AccountView {

    private static AccountCrudService accountCrudService = new AccountCrudServiceImpl();
    private static AccountSearchService accountSearchService = new AccountSearchServiceImpl();
    private static CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();

    private static Logger log = Logger.getLogger(AccountView.class);

    public List<MenuOption> updateAccountMenuOptions(List<Account> accountList){
        List<MenuOption> accountMenuOptions = new ArrayList<>();
        for(Account acc:accountList){
            if(acc.getStatus().equalsIgnoreCase("ACCEPTED"))
                accountMenuOptions.add(new MenuOption(acc.toString(), x -> startAccountViewMenu(acc)));
            else if(acc.getStatus().equalsIgnoreCase("PENDING"))
                accountMenuOptions.add(new MenuOption(acc.toString() + " | Status: " + acc.getStatus(), x -> InputUtil.setMessagePrompt("This account has not been accepted!")));
        }
        return accountMenuOptions;
    }

    public double getBalanceFromAccounts(List<Account> accountList){
        double totalBalance = 0;
        for(Account acc:accountList){
            if(acc.getStatus().equalsIgnoreCase("ACCEPTED"))
                totalBalance += acc.getBalance();
        }
        return totalBalance;
    }

    public void startAccountListMenu(Customer customer) {
        try {
            customer = customerSearchService.getCustomerById(customer.getId());
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
        Customer newCustomer = customer;
        List<MenuOption> accountMenuOptions = updateAccountMenuOptions(newCustomer.getAccounts());
        double totalBalance = getBalanceFromAccounts(newCustomer.getAccounts());

        String menuTitle = "Accounts | " + newCustomer.getFirst_name() + " " + newCustomer.getLast_name() + " | " + newCustomer.getContactEmail() + " | Total Balance: " + NumberFormat.getCurrencyInstance(Locale.US).format(totalBalance);
        Menu accountListMenu = new Menu(menuTitle, "User Profile").setIsLooping(false);
        accountListMenu.setAfterLoopConsumer(x -> startAccountListMenu(newCustomer));
        accountListMenu.addOptions(accountMenuOptions);
        accountListMenu.startMenu();
    }

    private void startAccountViewMenu(Account account) {
        try {
            account = accountSearchService.getAccountById(account.getId());
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }

        Account updatedAccount = account;

        Menu accountViewMenu = new Menu(account.toString(),"View Accounts").setIsLooping(false);
        accountViewMenu.addOption("Make Deposit", x -> startDeposit(updatedAccount));
        accountViewMenu.addOption("Make A Withdrawal", x -> startWithdrawal(updatedAccount));
        accountViewMenu.addOption("Transfer Funds", x -> new TransactionView().showTransactionListMenu(updatedAccount));
        accountViewMenu.setAfterLoopConsumer(x -> startAccountViewMenu(updatedAccount));

        accountViewMenu.startMenu();
    }

    public void startDeposit(Account account){
        log.info("Please input the amount you would like to deposit...");
        double amount = InputUtil.getDoubleInput();
        try {
            accountCrudService.depositToAccount(amount, account);
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
    }

    public void startWithdrawal(Account account){
        log.info("Please input the amount you would like to withdrawal...");
        double amount = InputUtil.getDoubleInput();
        try {
            accountCrudService.withdrawalFromAccount(amount, account);
        } catch (BankException e) {
            InputUtil.setMessagePrompt(e.getMessage());
        }
    }
}
