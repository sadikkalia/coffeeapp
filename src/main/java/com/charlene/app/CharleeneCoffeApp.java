package com.charlene.app;

import com.charlene.app.api.CoffeeConsole;
import com.charlene.app.model.Order;
import com.charlene.app.model.Product;
import com.charlene.app.repository.CustomerRepository;
import com.charlene.app.repository.CustomerRepositoryImpl;
import com.charlene.app.repository.ProductRepository;
import com.charlene.app.repository.ProductRepositoryImpl;
import com.charlene.app.service.OrderService;
import com.charlene.app.service.OrderServiceImpl;
import com.charlene.app.service.ReceiptService;
import com.charlene.app.service.ReceiptServiceImpl;

import java.util.List;

public class CharleeneCoffeApp {

    public static void main(String[] args) {
        CoffeeConsole coffeeConsole = new CoffeeConsole();
        coffeeConsole.displayMenu();
        String orderString = coffeeConsole.getOrderFromClient();

        ProductRepository productRepository = new ProductRepositoryImpl();
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        OrderService orderService = new OrderServiceImpl(productRepository, customerRepository);
        ReceiptService receiptService = new ReceiptServiceImpl();

        List<Product> products = orderService.getProductsFromOrder(orderString);
        Order order = orderService.createOrder(products, coffeeConsole.getCustomerID());

        coffeeConsole.printReceiptOnScreen(receiptService.createReceipt(order));

    }
}
