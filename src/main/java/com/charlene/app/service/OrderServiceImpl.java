package com.charlene.app.service;

import com.charlene.app.model.*;
import com.charlene.app.repository.CustomerRepository;
import com.charlene.app.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private ProductRepository productRepository;
    private CustomerRepository customerRepository;

    public OrderServiceImpl(ProductRepository productRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Product> getProductsFromOrder(String order) {
        List<Product> products = new ArrayList<>();

        String[] items = order.split(",");

        for (String item : items) {

            if (items.length > 2) {
                String[] extras = item.split("with");
                Product concreteProduct = getConcreteProduct(extras[0].trim().toLowerCase());

                for (int i = 1; i < extras.length; i++) {
                    concreteProduct = getConcreteProductExtras(extras[i].trim().toLowerCase(), concreteProduct);
                }
                products.add(concreteProduct);
            } else {
                Product concreteProduct = getConcreteProduct(item.trim().toLowerCase());
                products.add(concreteProduct);
            }
        }

        return products;
    }

    @Override
    public Order createOrder(List<Product> products, String customerID) {
        Customer customer = customerRepository.findCustomerByID(customerID);
        Order order = new Order.OrderBuilder(customer)
                .withProductList(products)
                .build();

        customerRepository.updateNumberOfStamps(customerID, order.getNumberOfStamps());
        return order;
    }

    private ConcreteProductDecorator getConcreteProductExtras(String extra, Product concreteProduct) {
        DatabaseItem product = productRepository.findProduct(extra);
        return new ConcreteProductDecorator(concreteProduct, product.getPrice(), extra, product.getProductType());
    }

    private ConcreteProduct getConcreteProduct(String item) {
        DatabaseItem product = productRepository.findProduct(item);
        return new ConcreteProduct(item, product.getProductType(), product.getPrice());
    }
}
