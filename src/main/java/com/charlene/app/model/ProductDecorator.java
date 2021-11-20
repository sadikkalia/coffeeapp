package com.charlene.app.model;

public abstract class ProductDecorator extends Product {

    public ProductDecorator(String description, String productType) {
        super(description, productType);
    }

    public abstract String getDescription();
}
