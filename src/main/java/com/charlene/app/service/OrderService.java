package com.charlene.app.service;

import com.charlene.app.model.Order;
import com.charlene.app.model.Product;

import java.util.List;

public interface OrderService {
    List<Product> getProductsFromOrder(String order);

    Order createOrder(List<Product> products, String customerID);

}
