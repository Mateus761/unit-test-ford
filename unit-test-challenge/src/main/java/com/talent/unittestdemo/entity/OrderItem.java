package com.talent.unittestdemo.entity;

import lombok.Getter;

@Getter
public class OrderItem {
    private final String id;
    private final String name;
    private final Double price;

    public OrderItem(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;

        validation();
    }

    private void validation() {
        if (id.isEmpty() || id.isBlank()) {
            throw new IllegalArgumentException("Order item id is required");
        }
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Order item name is required");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Order item price must be greater than zero");
        }
    }
}
