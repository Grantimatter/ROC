package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.impl.AccountSearchDaoImpl;
import com.grantwiswell.banking.model.Account;
import com.grantwiswell.banking.service.AccountSearchService;
import com.grantwiswell.banking.service.impl.util.ValidationUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

class AccountSearchServiceImplTest {

    private static AccountSearchService accountSearchService = new AccountSearchServiceImpl();

    @Test
    void testGetAccountById() {
        assertAccount(accountSearchService.getAccountById(911626));
    }

    @Test
    void testGetAccountsByCustomerId() {
        assertAccounts(accountSearchService.getAccountsByCustomerId(732));
    }

    @Test
    void testGetAccountsByStatus() {
        assertAccounts(accountSearchService.getAccountsByStatus("ACCEPTED"));
    }

    void assertAccount(Account account){
        assert(account != null);
        assert(ValidationUtil.isValidAccountId(account.getId()));
        assert(account.getName() != null);
        assert(account.getStatus() != null);
        assert(account.getBalance() >= 0.00d);
        assert(ValidationUtil.isValidCustomerId(account.getCustomer_id()));
    }

    void assertAccounts(List<Account> accountList){
        assert(accountList != null);
        for (Account account:accountList){
            assertAccount(account);
        }
    }
}