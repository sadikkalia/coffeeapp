package com.charlene.app.model;

public class Customer {
    private String customerID;
    private int numberOfStamps;

    public Customer(String customerID, int numberOfStamps) {
        this.customerID = customerID;
        this.numberOfStamps = numberOfStamps;
    }

    public int getNumberOfStamps() {
        return numberOfStamps;
    }

    public void setNumberOfStamps(int numberOfStamps) {
        this.numberOfStamps = numberOfStamps;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
}
