package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.impl.CustomerSearchDaoImpl;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.service.CustomerSearchService;
import com.grantwiswell.banking.util.RandomUtil;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomerSearchServiceImplTest {

    private static Logger log = Logger.getLogger(CustomerSearchServiceImplTest.class);
    private static CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();

    @Test
    void getCustomerById() {
        assertCustomer(customerSearchService.getCustomerById(RandomUtil.getRandomInRange(629, 728)));
    }

    @Test
    void getCustomerByContactEmail() {
        assertCustomer(customerSearchService.getCustomerByContactEmail("wiswellgrant@gmail.com"));
    }

    @Test
    void getAllCustomers() {
        assertCustomers(customerSearchService.getAllCustomers());
    }

    @Test
    void getCustomersByFirstName() {
        assertCustomers(customerSearchService.getCustomersByFirstName("Georgette"));
    }

    @Test
    void getCustomersByLastName() {
        assertCustomers(customerSearchService.getCustomersByLastName("Wiswell"));
    }

    @Test
    void getCustomersByStatus() {
        assertCustomers(customerSearchService.getCustomersByStatus("Accepted"));
    }

    void assertCustomers(List<Customer> customerList){
        assert(customerList != null);
        for (Customer customer:customerList){
            assertCustomer(customer);
        }
    }

    void assertCustomer(Customer customer){
        assert(customer != null);
        assert(customer.getContactEmail() != null);
        assert(customer.getFirst_name() != null);
        assert(customer.getLast_name() != null);
        assert(customer.getDob() != null);
        assert(customer.getStatus() != null);
    }
}