package com.talent.unittestdemo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private String id;
    private String name;
    private Address address;
    private Boolean active = false;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        validation();
    }

    public void changeAddress(Address address) {
        this.address = address;
    }

    public void activate() {
        if(address == null) {
            throw new IllegalArgumentException("Address is required to active a customer");
        }

        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    public Boolean isActive() {
        return this.active;
    }

    private void validation() {
        if (id.isEmpty() || id.isBlank()) {
            throw new IllegalArgumentException("Customer id cannot be empty");
        }
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
    }
}
