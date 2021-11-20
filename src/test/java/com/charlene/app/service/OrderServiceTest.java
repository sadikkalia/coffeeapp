package com.charlene.app.service;

import com.charlene.app.model.Order;
import com.charlene.app.model.Product;
import com.charlene.app.repository.CustomerRepositoryImpl;
import com.charlene.app.repository.ProductRepositoryImpl;
import com.charlene.app.utils.TestUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private static OrderService orderService;

    @BeforeAll
    public static void init() {
        orderService = new OrderServiceImpl(new ProductRepositoryImpl(), new CustomerRepositoryImpl());
    }

    @Test
    void getProductsFromOrderTest() {
        String orderString = "small coffee, large coffee, medium coffee with extra milk";

        List<Product> productsFromOrder = orderService.getProductsFromOrder(orderString);
        List<Product> products = TestUtils.products();
        assertEquals(productsFromOrder.size(), products.size());

        for (int i = 0; i < products.size(); i++) {
            assertEquals(products.get(i).getDescription(), productsFromOrder.get(i).getDescription());
            assertEquals(products.get(i).cost(), productsFromOrder.get(i).cost());
            assertEquals(products.get(i).getProductType(), productsFromOrder.get(i).getProductType());
        }
    }

    @Test
    void getProductsFromOrderWithFreeExtrasTest() {
        String orderString = "small coffee, large coffee, medium coffee with extra milk, bacon roll";

        List<Product> productsFromOrder = orderService.getProductsFromOrder(orderString);
        List<Product> products = TestUtils.productsWithFreeExtras();
        assertEquals(productsFromOrder.size(), products.size());

        for (int i = 0; i < products.size(); i++) {
            assertEquals(products.get(i).getDescription(), productsFromOrder.get(i).getDescription());
            assertEquals(products.get(i).cost(), productsFromOrder.get(i).cost());
            assertEquals(products.get(i).getProductType(), productsFromOrder.get(i).getProductType());
        }
    }

    @Test
    void getProductsFromOrderWithFreeExtrasAndFreeBeverageTest() {
        String orderString = "small coffee, small coffee, orange juice, large coffee, medium coffee with extra milk, bacon roll";

        List<Product> productsFromOrder = orderService.getProductsFromOrder(orderString);
        List<Product> products = TestUtils.productsWithFreeExtrasAndBeverages();
        assertEquals(productsFromOrder.size(), products.size());

        for (int i = 0; i < products.size(); i++) {
            assertEquals(products.get(i).getDescription(), productsFromOrder.get(i).getDescription());
            assertEquals(products.get(i).cost(), productsFromOrder.get(i).cost());
            assertEquals(products.get(i).getProductType(), productsFromOrder.get(i).getProductType());
        }
    }

    @Test
    void createOrderTest() {
        String orderString = "small coffee, large coffee, medium coffee with extra milk";

        List<Product> products = orderService.getProductsFromOrder(orderString);
        Order order = orderService.createOrder(products, "C123");

        assertNotNull(order);
        assertEquals(3, order.getNumberOfStamps());
        assertEquals(BigDecimal.valueOf(9.30), order.getTotalAmount());
        assertEquals("C123", order.getCustomerID());

        for (int i = 0; i < products.size(); i++) {
            assertEquals(products.get(i).getDescription(), order.getProducts().get(i).getDescription());
            assertEquals(products.get(i).cost(), order.getProducts().get(i).cost());
            assertEquals(products.get(i).getProductType(), order.getProducts().get(i).getProductType());
        }
    }

    @Test
    void createOrderFreeExtrasTest() {
        String orderString = "small coffee, large coffee, medium coffee with extra milk, bacon roll";

        List<Product> products = orderService.getProductsFromOrder(orderString);
        Order order = orderService.createOrder(products, "C124");

        assertNotNull(order);
        assertEquals(3, order.getNumberOfStamps());
        assertEquals(BigDecimal.valueOf(13.50), order.getTotalAmount());
        assertEquals("C124", order.getCustomerID());

        for (int i = 0; i < products.size(); i++) {
            assertEquals(products.get(i).getDescription(), order.getProducts().get(i).getDescription());
            assertEquals(products.get(i).cost(), order.getProducts().get(i).cost());
            assertEquals(products.get(i).getProductType(), order.getProducts().get(i).getProductType());
        }
    }

    @Test
    void createOrderFreeExtrasAndFreeBeverageTest() {
        String orderString = "small coffee, small coffee, orange juice, large coffee, medium coffee with extra milk, bacon roll";

        List<Product> products = orderService.getProductsFromOrder(orderString);
        Order order = orderService.createOrder(products, "C125");

        assertNotNull(order);
        assertEquals(0, order.getNumberOfStamps());
        assertEquals(BigDecimal.valueOf(17.45), order.getTotalAmount());
        assertEquals("C125", order.getCustomerID());

        for (int i = 0; i < products.size(); i++) {
            assertEquals(products.get(i).getDescription(), order.getProducts().get(i).getDescription());
            assertEquals(products.get(i).cost(), order.getProducts().get(i).cost());
            assertEquals(products.get(i).getProductType(), order.getProducts().get(i).getProductType());
        }
    }
}