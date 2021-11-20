package com.charlene.app.model;

import java.math.BigDecimal;

public class ConcreteProduct extends Product {

    private BigDecimal price;

    public ConcreteProduct(String description, String productType, BigDecimal price) {
        super(description, productType);
        this.price = price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal cost() {
        return price;
    }
}
