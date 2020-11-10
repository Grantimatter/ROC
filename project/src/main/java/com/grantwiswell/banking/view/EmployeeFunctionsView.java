package com.grantwiswell.banking.view;

import com.grantwiswell.banking.exception.BankException;
import com.grantwiswell.banking.model.Customer;
import com.grantwiswell.banking.service.CustomerCrudService;
import com.grantwiswell.banking.service.CustomerSearchService;
import com.grantwiswell.banking.service.impl.CustomerCrudServiceImpl;
import com.grantwiswell.banking.service.impl.CustomerSearchServiceImpl;
import com.grantwiswell.banking.util.InputUtil;
import com.grantwiswell.banking.util.menu.Menu;
import com.grantwiswell.banking.util.sorting.NameComparator;
import org.apache.log4j.Logger;

import java.util.List;


public class EmployeeFunctionsView {

    private static Logger log = Logger.getLogger(EmployeeFunctionsView.class);
    private static CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
    private static CustomerCrudService customerCrudService = new CustomerCrudServiceImpl();

    public void viewSearchFunctionsMenu(){
        Menu searchFunctionsMenu = new Menu("Customer Search", "Employee Menu");
        searchFunctionsMenu.addOption("View All Customers", x -> viewCustomerList(customerSearchService.getAllCustomers(), ""));
        searchFunctionsMenu.addOption("Search Customer By ID", x -> viewCustomerById());
        searchFunctionsMenu.addOption("Search Customer By Email", x -> viewCustomerByEmail());
        searchFunctionsMenu.addOption("Search Customer By Status", x -> viewCustomerByStatus());

        searchFunctionsMenu.startMenu();
    }

    public void viewCustomerByStatus(){
        Menu statusOptionsMenu = new Menu("View Customers By Status", "Customer Search");
        statusOptionsMenu.addOption("Accepted", x-> viewCustomerList(customerSearchService.getCustomersByStatus("ACCEPTED"), "Status"));
        statusOptionsMenu.addOption("Pending", x-> viewCustomerList(customerSearchService.getCustomersByStatus("PENDING"), "Status"));
        statusOptionsMenu.addOption("Rejected", x-> viewCustomerList(customerSearchService.getCustomersByStatus("REJECTED"), "Status"));
        statusOptionsMenu.startMenu();
    }

    public void viewCustomerById(){
        try{
            log.info("Please input the customer ID");
            viewCustomer(customerSearchService.getCustomerById(InputUtil.getIntInput()));
        } catch (BankException e) {
            log.warn(e.getMessage());
        }
    }

    public void viewCustomerByEmail(){
        try{
            log.info("Please input the customer email");
            viewCustomer(customerSearchService.getCustomerByContactEmail(InputUtil.getStringInput()));
        } catch (BankException e) {
            log.warn(e.getMessage());
        }
    }

    public void viewCustomerList(List<Customer> customerList, String searchedBy){
        // Return if there is nothing to display
        if(customerList == null  || customerList.size() == 0) return;

        Menu customerListMenu = new Menu("Customers"+(searchedBy.length() > 0 ? "Searched by: " + searchedBy : "")).setIsLooping(false);
        customerListMenu.setAfterLoopConsumer(x -> viewCustomerList(customerList, searchedBy));
        NameComparator nameComparator = new NameComparator();
        customerList.sort(nameComparator);
        for (Customer customer:customerList){
            customerListMenu.addOption(customer.toString(), x-> viewCustomer(customer));
        }
        customerListMenu.startMenu();
    }

    public static void viewCustomer(Customer customer){
        Customer updatedCustomer = customerSearchService.getCustomerById(customer.getId());
        Menu userActionMenu = new Menu(customer.toString(), "Customer Search").setIsLooping(false);
        userActionMenu.setAfterLoopConsumer(x -> viewCustomer(updatedCustomer));
        if (updatedCustomer.getStatus().equalsIgnoreCase("PENDING")) {
            userActionMenu.addOption("Accept User", x -> customerCrudService.acceptCustomer(updatedCustomer.getId()));
            userActionMenu.addOption("Reject User", x -> customerCrudService.rejectCustomer(updatedCustomer.getId()));
        }
        userActionMenu.startMenu();
    }
}
