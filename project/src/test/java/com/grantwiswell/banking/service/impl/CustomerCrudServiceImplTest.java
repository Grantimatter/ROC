package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.CustomerCrudDao;
import com.grantwiswell.banking.dao.impl.CustomerCrudDaoImpl;
import com.grantwiswell.banking.service.CustomerCrudService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class CustomerCrudServiceImplTest {

    CustomerCrudService customerCrudService = new CustomerCrudServiceImpl();
    CustomerCrudDao mockCustomerCrudDao = mock(CustomerCrudDaoImpl.class);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCreateNewCustomer() {
        //mockCustomerCrudDao.createNewCustomer()
    }

    @Test
    void testAcceptCustomer() {
    }

    @Test
    void testRejectCustomer() {
    }
}