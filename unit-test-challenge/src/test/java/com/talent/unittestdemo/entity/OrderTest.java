package com.talent.unittestdemo.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class OrderTest {

    @Test
    public void shouldSumAllItemsPrice_whenCreatingAnOrder() {
        List<OrderItem> items = List.of(
            new OrderItem("1", "Product 1", 10.0),
            new OrderItem("2", "Product 2", 20.0),
            new OrderItem("3", "Product 3", 30.0)
        );

        Order order = new Order("1", "1", items);
        Order order2 = new Order("2", "2", List.of(new OrderItem("1", "Product 1", 10.0)));

        Double expectedPrice = 60.0;
        Double currentPrice = order.getTotal();

        Double expectedPrice2 = 10.0;
        Double currentPrice2 = order2.getTotal();

        assertEquals(expectedPrice, currentPrice);
        assertEquals(expectedPrice2, currentPrice2);
    }
}
