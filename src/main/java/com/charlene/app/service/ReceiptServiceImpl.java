package com.charlene.app.service;

import com.charlene.app.model.*;


public class ReceiptServiceImpl implements ReceiptService {

    @Override
    public String createReceipt(Order order) {
        StringBuilder receipt = new StringBuilder(String.format("%-15s\n", "Charlene's Coffee Shop"));
        receipt.append(String.format("%-15s\n", "--------------------------------"));
        receipt.append(String.format("%-15s %5s %10s\n", "Item", "Qty", "Price"));
        receipt.append(String.format("%-15s %5s %10s\n", "----", "---", "-----"));
        for (Product product : order.getProducts()) {
            if (ProductType.EXTRAS == product.getProductType()) {
                receipt.append(String.format("%-15s %5d %10.2f\n",  ((ConcreteProductDecorator)product).getDescription(), 1,
                        ((ConcreteProductDecorator)product).getPrice()));
                receipt.append(String.format("%-15s %5d %10.2f\n", ((ConcreteProductDecorator) product).getProduct().getDescription(),
                        1, (((ConcreteProductDecorator) product).getProduct()).cost()));
            } else {
                receipt.append(String.format("%-15s %5d %10.2f\n", product.getDescription(), 1,
                        ((ConcreteProduct)product).cost()));
            }
        }
        receipt.append(String.format("%-15s\n", "--------------------------------"));
        receipt.append(String.format("%-15s  %10.2f%s\n", "Total", order.getTotalAmount(), "  CHF"));
        
        return receipt.toString();
    }
}
