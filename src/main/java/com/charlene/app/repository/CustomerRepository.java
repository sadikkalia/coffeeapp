package com.charlene.app.repository;

import com.charlene.app.model.Customer;

public interface CustomerRepository {
    Customer findCustomerByID(String customerID);

    void updateNumberOfStamps(String customerID, int numberOfStamps);
}
