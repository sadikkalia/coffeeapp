package com.charlene.app.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String customerID;
    private final int numberOfStamps;
    private final List<Product> products;
    private BigDecimal totalAmount;

    public Order(OrderBuilder builder) {
        this.customerID = builder.customer.getCustomerID();
        this.products = builder.products;
        this.numberOfStamps = builder.numberOfStamps;
        this.totalAmount = builder.totalAmount;
    }

    public static class OrderBuilder {
        private final Customer customer;
        private List<Product> products;
        private boolean beverage = false;
        private boolean snack = false;
        private int numberOfStamps;
        private BigDecimal totalAmount;

        public OrderBuilder(Customer customer) {
            this.products = new ArrayList<>();
            this.customer = customer;
            numberOfStamps = customer.getNumberOfStamps();
            totalAmount = BigDecimal.ZERO;
        }

        public OrderBuilder withProduct(Product product) {
            if (ProductType.BEVERAGE == product.getProductType() ||
                    ProductType.EXTRAS == product.getProductType()) {
                numberOfStamps++;
                beverage = true;
            } else if (ProductType.SNACK == product.getProductType()) {
                snack = true;
            }

            this.products.add(product);
            return this;
        }

        public OrderBuilder withProductList(List<Product> products) {
            products.forEach(this::withProduct);
            return this;
        }

        public Order build() {
            int freeBeverage = numberOfStamps / 5;

            for (Product product : products) {
               if (ProductType.BEVERAGE == product.getProductType()) {
                   if (freeBeverage > 0) {
                       ((ConcreteProduct) product).setPrice(BigDecimal.ZERO);
                       freeBeverage--;
                       numberOfStamps -= 5;
                   }
               }  else if (ProductType.EXTRAS == product.getProductType()) {
                   if (beverage && snack) {
                       ((ConcreteProductDecorator) product).setPrice(BigDecimal.ZERO);
                       snack = false;
                   }

                   if (freeBeverage > 0) {
                       ((ConcreteProduct) ((ConcreteProductDecorator) product).getProduct()).setPrice(BigDecimal.ZERO);
                       freeBeverage--;
                       numberOfStamps -= 5;
                   }
               }

               totalAmount = totalAmount.add(product.cost());
            }

            return new Order(this);
        }
    }


    public String getCustomerID() {
        return customerID;
    }

    public int getNumberOfStamps() {
        return numberOfStamps;
    }

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
}
