package com.charlene.app.repository;

import com.charlene.app.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {

    private static Map<String, Customer> customerMap;

    static {
        customerMap = new HashMap<>();
        customerMap.put("C123", new Customer("C123",0));
        customerMap.put("C124", new Customer("C124",0));
        customerMap.put("C125", new Customer("C125",0));
        customerMap.put("C213", new Customer("C213",0));
        customerMap.put("C214", new Customer("C214", 0));
    }

    public CustomerRepositoryImpl() {
    }

    @Override
    public Customer findCustomerByID(String customerID) {
        return customerMap.get(customerID);
    }

    @Override
    public void updateNumberOfStamps(String customerID, int numberOfStamps) {
        Customer customer = customerMap.get(customerID);
        customer.setNumberOfStamps(numberOfStamps);
    }
}
