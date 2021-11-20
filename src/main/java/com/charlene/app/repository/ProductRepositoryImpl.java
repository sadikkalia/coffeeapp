package com.charlene.app.repository;

import com.charlene.app.model.DatabaseItem;

import java.util.HashMap;
import java.util.Map;

import static java.math.BigDecimal.valueOf;

public class ProductRepositoryImpl implements ProductRepository {

    private static Map<String, DatabaseItem> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put("bacon roll", new DatabaseItem(valueOf(4.50),"snack"));
        productMap.put("small coffee", new DatabaseItem(valueOf(2.50),"beverage"));
        productMap.put("medium coffee", new DatabaseItem(valueOf(3.00),"beverage"));
        productMap.put("large coffee", new DatabaseItem(valueOf(3.50),"beverage"));
        productMap.put("orange juice", new DatabaseItem(valueOf(3.95),"beverage"));
        productMap.put("special roast", new DatabaseItem(valueOf(0.90),"extras"));
        productMap.put("extra milk", new DatabaseItem(valueOf(0.30),"extras"));
        productMap.put("foamed milk", new DatabaseItem(valueOf(0.50),"extras"));
    }

    public ProductRepositoryImpl() {
    }

    public DatabaseItem findProduct(String productName) {
        return productMap.get(productName);
    }

}
