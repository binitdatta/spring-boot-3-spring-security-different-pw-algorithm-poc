package com.rollingstone.api;

import com.rollingstone.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @GetMapping
    public List<Customer> listCustomers() {
        return List.of(
                new Customer(1L, "Alice", "alice@example.com"),
                new Customer(2L, "Bob", "bob@example.com")
        );
    }
}


