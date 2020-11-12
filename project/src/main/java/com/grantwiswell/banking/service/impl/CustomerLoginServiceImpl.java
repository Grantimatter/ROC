package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.CustomerLoginDao;
import com.grantwiswell.banking.dao.impl.CustomerLoginDaoImpl;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.service.CustomerLoginService;
import com.grantwiswell.banking.service.impl.util.ValidationUtil;
import com.grantwiswell.banking.util.CustomerUtil;
import com.grantwiswell.banking.util.InputUtil;
import org.apache.log4j.Logger;

public class CustomerLoginServiceImpl implements CustomerLoginService {

    private static Logger log = Logger.getLogger(CustomerLoginServiceImpl.class);
    private CustomerLoginDao customerLoginDao = new CustomerLoginDaoImpl();

    @Override
    public Customer getCustomerFromLogin(String contactEmail, String password) throws BankException {
        Customer customer = null;
        if(ValidationUtil.isValidEmail(contactEmail) && password != null && password.length() > 7){
            try{
                customer = customerLoginDao.getCustomerFromLogin(contactEmail, password);
            } catch (BankException e) {
                InputUtil.setMessagePrompt(e.getMessage());
            }
        } else{
            throw new BankException("Password must be at least 8 characters... Try again");
        }
        if(customer != null) {
            if (customer.getStatus().equalsIgnoreCase("PENDING"))
                throw new BankException("User has not been approved, please contact the bank to have your account approved by an employee!");
            if (customer.getStatus().equalsIgnoreCase("TERMINATED"))
                throw new BankException("User account has been terminated. You may no longer bank with us under this account");
            if (!customer.getStatus().equalsIgnoreCase("ACCEPTED"))
                throw new BankException("User does not have access to the bank at this time, sorry for the inconvenience");
        }
        return customer;
    }
}
