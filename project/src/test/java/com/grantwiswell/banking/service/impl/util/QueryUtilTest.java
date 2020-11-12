package com.grantwiswell.banking.service.impl.util;

import com.grantwiswell.banking.dao.queries.CustomerQueries;
import com.grantwiswell.banking.dao.util.DaoCustomerUtil;
import com.grantwiswell.banking.model.Customer;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

class QueryUtilTest {

    private static Logger log = Logger.getLogger(QueryUtilTest.class);

    @Test
    void testSendQuery() {
        Customer customer = DaoCustomerUtil.getNextCustomerFromResultSet(QueryUtil.sendQuery(CustomerQueries.GET_CUSTOMER_BY_ID, 629));
        log.info("Customer Found with id 629:\n" + customer);

        customer = DaoCustomerUtil.getNextCustomerFromResultSet(QueryUtil.sendQuery(CustomerQueries.GET_CUSTOMER_BY_EMAIL, "wmacronaldc@unesco.org"));
        log.info("Customer Found with Email wmacronaldc@unesco.org : "+ customer);
    }
}
