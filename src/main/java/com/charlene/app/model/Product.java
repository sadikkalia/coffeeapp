package com.charlene.app.model;

import java.math.BigDecimal;

public abstract class Product {

    String description;
    private ProductType productType;

    public Product(String description, String productType) {
        this.productType = ProductType.valueOf(productType.toUpperCase());
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public ProductType getProductType() {
        return productType;
    }

    public abstract BigDecimal cost();
}
