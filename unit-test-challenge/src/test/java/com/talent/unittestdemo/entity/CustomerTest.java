package com.talent.unittestdemo.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CustomerTest {

    @Test
    public void shouldThrowError_whenCustomerNameIsEmpty() {
        String expectedMessage = "Customer name cannot be empty";

        IllegalArgumentException currentException = assertThrows(IllegalArgumentException.class, () -> {
            new Customer("1", "");
        });

        assertEquals(expectedMessage, currentException.getMessage());
    }

    @Test
    public void shouldThrowError_whenActivateACustomerWithoutAddress() {
        String expectedMessage = "Address is required to active a customer";

        IllegalArgumentException currentException = assertThrows(IllegalArgumentException.class, () -> {
            Customer customer = new Customer("1", "Tuba");
            customer.activate();
        });

        assertEquals(expectedMessage, currentException.getMessage());
    }

    @Test
    public void shouldActiveClient_whenHavingAnAddress() {
        Customer expectedCustomer = new Customer("1", "Tuba");
        Address address = new Address("Rua do Tuba", 10, "Santo André", "São Paulo", "21312312441");

        expectedCustomer.changeAddress(address);
        expectedCustomer.activate();

        assertTrue(expectedCustomer.isActive());
    }
}
