package com.charlene.app.repository;

import com.charlene.app.model.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    private static CustomerRepository customerRepository;

    @BeforeAll
    public static void init() {
        customerRepository = new CustomerRepositoryImpl();
    }

    @Test
    void findCustomerByIDTest() {
        Customer customer = customerRepository.findCustomerByID("C123");
        assertNotNull(customer);
        assertEquals("C123", customer.getCustomerID());
        assertEquals(0, customer.getNumberOfStamps());
    }

    @Test
    void findCustomerByIDReturnNullTest() {
        Customer customer = customerRepository.findCustomerByID("C123#");
        assertNull(customer);
    }

    @Test
    void updateNumberOfStamps() {
        customerRepository.updateNumberOfStamps("C123", 4);
        Customer customer = customerRepository.findCustomerByID("C123");
        assertEquals(4, customer.getNumberOfStamps());

        customerRepository.updateNumberOfStamps("C123", 0);
        customer = customerRepository.findCustomerByID("C123");
        assertEquals(0, customer.getNumberOfStamps());
    }
}