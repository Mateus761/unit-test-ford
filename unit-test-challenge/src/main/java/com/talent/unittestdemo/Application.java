package com.talent.unittestdemo;

import com.talent.unittestdemo.entity.Address;
import com.talent.unittestdemo.entity.Customer;
import com.talent.unittestdemo.entity.Order;
import com.talent.unittestdemo.entity.OrderItem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Customer customer = new Customer("1", "Jonh Doe");
		Address address = new Address("Street 1", 10,"City 1", "State 1", "09122370");
		customer.changeAddress(address);
		customer.activate();

		List<OrderItem> items = List.of(
				new OrderItem("1", "Product 1", 10.0),
				new OrderItem("2", "Product 2", 20.0),
				new OrderItem("3", "Product 3", 30.0)
		);

		Order order = new Order("1", "1", items);

		System.out.println(order.toString());
		System.out.println("To address: " + customer.getAddress().toString());
	}
}
