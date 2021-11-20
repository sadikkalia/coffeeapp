package com.charlene.app.model;

import java.math.BigDecimal;

public class DatabaseItem {
    private BigDecimal price;
    private String productType;

    public DatabaseItem() {
    }

    public DatabaseItem(BigDecimal price, String productType) {
        this.price = price;
        this.productType = productType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
