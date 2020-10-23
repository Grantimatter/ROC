package eg2;

import java.util.HashSet;
import java.util.Set;

public class CustomerMain {
    public static void main(String[] args) {
        Set<Customer> customers=new HashSet<>();
        customers.add(new Customer(100,"Grant"));
        customers.add(new Customer(101,"Alfred"));
        customers.add(new Customer(102,"Gerald"));
        customers.add(new Customer(103,"Chloe"));
        System.out.println(customers.toString());
    }
}
