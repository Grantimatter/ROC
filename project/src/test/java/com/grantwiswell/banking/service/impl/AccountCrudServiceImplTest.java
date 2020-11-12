package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.service.AccountCrudService;
import com.grantwiswell.banking.service.AccountSearchService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountCrudServiceImplTest {

    private static AccountCrudService accountCrudService = new AccountCrudServiceImpl();
    private static AccountSearchService accountSearchService = new AccountSearchServiceImpl();
    private static Account account;

    @BeforeAll
    static void createNewAccount() {
        accountCrudService.createNewAccount(702, 750.91d, "savings");
        account = accountSearchService.getAccountsByCustomerId(702).get(0);
        updateAccountStatus();
    }

    @Test
    void depositToAccount() {
        accountCrudService.depositToAccount(174.28d, account);
    }

    @Test
    void withdrawalFromAccount() {
        accountCrudService.withdrawalFromAccount(174.28d, account);
    }

    static void updateAccountStatus() {
        accountCrudService.updateAccountStatus(account, "ACCEPTED");
    }
}