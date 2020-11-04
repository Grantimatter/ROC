package com.grantwiswell.banking.service.impl;

import com.grantwiswell.banking.dao.CustomerCrudDao;
import com.grantwiswell.banking.dao.impl.CustomerCrudDaoImpl;
import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.service.CustomerCrudService;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CustomerCrudServiceImpl implements CustomerCrudService {

    CustomerCrudDao customerCrudDao = new CustomerCrudDaoImpl();
    private Logger log = Logger.getLogger(CustomerCrudServiceImpl.class);

    @Override
    public boolean createNewCustomer(String contact_email, String password, String fullName, String dobString) throws BankException {
        if(!isValidEmail(contact_email)) throw new BankException("Invalid email address! please try again.");
        if(password.length() < 8)throw new BankException("Password must be at least 8 characters! Please try again.");
        LocalDate localDob = null;

        try{
            localDob = LocalDate.parse(dobString, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        log.info(localDob);

        if(Period.between(localDob, LocalDate.now()).getYears() < 16) throw new BankException("You must be at least 16 years old to register");

        Date dob = Date.from(localDob.atStartOfDay(ZoneId.systemDefault()).toInstant());

        //if()
        if (!dob.before(new Date())) throw new BankException("You cannot be born today...");

        String[] names = fullName.split(" ");
        if(names.length > 2){
            throw new BankException("Too many names entered, please provide only your first and last name.");
        }
        else if(names.length < 2){
            throw new BankException("You have not entered both of your names, please enter your first and last name to create an account.");
        }

        boolean createSuccessful = false;
        try{
            Customer customer = new Customer(names[0], names[1], contact_email, password, dob);
            createSuccessful = customerCrudDao.createNewCustomer(customer);
        } catch (BankException e) {
            log.warn(e.getMessage());
        }

        return createSuccessful;
    }

    private boolean isValidEmail(String email){
        // Official RFC5322 standard email syntax used for validation
        if(email != null && email.length() > 0)
            return email.toLowerCase().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        else return false;
    }
}
