package com.charlene.app.service;

import com.charlene.app.model.Order;

public interface ReceiptService {
    String createReceipt(Order order);
}
