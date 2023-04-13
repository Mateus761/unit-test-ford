package com.talent.unittestdemo.service;

import com.talent.unittestdemo.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    public static Double getTotal(List<Order> orders) {
        return orders.stream().mapToDouble(Order::getTotal).sum();
    }
}
