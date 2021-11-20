package com.charlene.app.repository;

import com.charlene.app.model.DatabaseItem;
import com.charlene.app.model.ProductType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private static ProductRepository productRepository;

    @BeforeAll
    public static void init() {
        productRepository =  new ProductRepositoryImpl();
    }

    @Test
    void findProductTest() {
        DatabaseItem largeCoffe = productRepository.findProduct("large coffee");

        assertNotNull(largeCoffe);
        assertEquals(ProductType.BEVERAGE.name(), largeCoffe.getProductType().toUpperCase());
        assertEquals(BigDecimal.valueOf(3.50), largeCoffe.getPrice());
    }

    @Test
    void findProductNullTest() {
        DatabaseItem nullItem = productRepository.findProduct("large");

        assertNull(nullItem);
    }
}