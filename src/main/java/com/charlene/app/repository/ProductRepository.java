package com.charlene.app.repository;

import com.charlene.app.model.DatabaseItem;

public interface ProductRepository {
    DatabaseItem findProduct(String productName);
}
