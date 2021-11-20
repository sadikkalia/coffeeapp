package com.charlene.app.utils;

import com.charlene.app.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static Order createOrder() {
        ConcreteProduct product = new ConcreteProduct("medium coffee", ProductType.BEVERAGE.name(), BigDecimal.valueOf(3.00));
        Order order = new Order.OrderBuilder(createCustomer())
                .withProduct(new ConcreteProduct("large coffee", ProductType.BEVERAGE.name(), BigDecimal.valueOf(3.50)))
                .withProduct(new ConcreteProductDecorator(product, BigDecimal.valueOf(0.30),"extra milk", ProductType.EXTRAS.name()))
                .build();

        return order;
    }

    public static Customer createCustomer() {
        return new Customer("C123", 0);
    }

    public static List<Product> products() {
        List<Product> products = new ArrayList<>();
        products.add(new ConcreteProduct("small coffee", ProductType.BEVERAGE.name(), BigDecimal.valueOf(2.50)));
        products.add(new ConcreteProduct("large coffee", ProductType.BEVERAGE.name(), BigDecimal.valueOf(3.50)));
        ConcreteProduct product = new ConcreteProduct("medium coffee", ProductType.BEVERAGE.name(), BigDecimal.valueOf(3.00));
        products.add(new ConcreteProductDecorator(product, BigDecimal.valueOf(0.30),"extra milk", ProductType.EXTRAS.name()));

        return products;
    }

    public static List<Product> productsWithFreeExtras() {
        List<Product> products = new ArrayList<>();
        products.add(new ConcreteProduct("small coffee", ProductType.BEVERAGE.name(), BigDecimal.valueOf(2.50)));
        products.add(new ConcreteProduct("large coffee", ProductType.BEVERAGE.name(), BigDecimal.valueOf(3.50)));
        ConcreteProduct product = new ConcreteProduct("medium coffee", ProductType.BEVERAGE.name(), BigDecimal.valueOf(3.00));
        products.add(new ConcreteProductDecorator(product, BigDecimal.valueOf(0.30),"extra milk", ProductType.EXTRAS.name()));
        products.add(new ConcreteProduct("bacon roll", ProductType.SNACK.name(), BigDecimal.valueOf(4.50)));

        return products;
    }

    public static List<Product> productsWithFreeExtrasAndBeverages() {
        List<Product> products = new ArrayList<>();
        products.add(new ConcreteProduct("small coffee", ProductType.BEVERAGE.name(), BigDecimal.valueOf(2.50)));
        products.add(new ConcreteProduct("small coffee", ProductType.BEVERAGE.name(), BigDecimal.valueOf(2.50)));
        products.add(new ConcreteProduct("orange juice", ProductType.BEVERAGE.name(), BigDecimal.valueOf(3.95)));
        products.add(new ConcreteProduct("large coffee", ProductType.BEVERAGE.name(), BigDecimal.valueOf(3.50)));
        ConcreteProduct product = new ConcreteProduct("medium coffee", ProductType.BEVERAGE.name(), BigDecimal.valueOf(3.00));
        products.add(new ConcreteProductDecorator(product, BigDecimal.valueOf(0.30),"extra milk", ProductType.EXTRAS.name()));
        products.add(new ConcreteProduct("bacon roll", ProductType.SNACK.name(), BigDecimal.valueOf(4.50)));

        return products;
    }
}
