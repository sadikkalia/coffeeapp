package com.charlene.app.model;

import java.math.BigDecimal;


public class ConcreteProductDecorator extends ProductDecorator {

    private Product product;
    private BigDecimal price;

    public ConcreteProductDecorator(Product product, BigDecimal price, String description, String productType) {
        super(description, productType);
        this.product = product;
        this.price = price;
    }

    @Override
    public BigDecimal cost() {
        return price.add(product.cost());
    }

    @Override
    public String getDescription() {
        return super.description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
