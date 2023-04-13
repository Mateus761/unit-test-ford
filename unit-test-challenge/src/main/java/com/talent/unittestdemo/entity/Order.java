package com.talent.unittestdemo.entity;

import lombok.Getter;

import java.util.List;

@Getter
public class Order {
    private final String id;
    private final String customerId;
    private final List<OrderItem> items;
    private Double total;

    public Order(String id, String customerId, List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.items = items;
        validation();
        total();
    }

    public void total() {
        this.total = items.stream().mapToDouble(OrderItem::getPrice).sum();
    }

    public String toString() {
        return String.format("Order %s for customer %s with total of $%s", id, customerId, total);
    }

    private void validation() {
        if (id.isEmpty() || id.isBlank()) {
            throw new IllegalArgumentException("Order id is required");
        }
        if (customerId.isEmpty() || customerId.isBlank()) {
            throw new IllegalArgumentException("Customer id is required");
        }
    }
}
