package com.talent.unittestdemo.service;

import com.talent.unittestdemo.entity.Order;
import com.talent.unittestdemo.entity.OrderItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Test
    public void shouldSumAllOrdersTotal_whenCallingGetTotal() {
        List<Order> orders = List.of(
            new Order("1", "1", List.of(
                new OrderItem("1", "Product 1", 10.0),
                new OrderItem("2", "Product 2", 20.0)
            )),
            new Order("2", "2", List.of(new OrderItem("1", "Product 1", 10.0))),
            new Order("3", "3", List.of(
                new OrderItem("1", "Product 1", 10.0),
                new OrderItem("10", "Product 10", 47.0),
                new OrderItem("11", "Product 11", 12.0),
                new OrderItem("12", "Product 12", 15.0)
            ))
        );

        Double expectedTotalSum = 124.0;

        Double currentTotalSum = OrderService.getTotal(orders);

        assertEquals(expectedTotalSum, currentTotalSum);
    }
}
