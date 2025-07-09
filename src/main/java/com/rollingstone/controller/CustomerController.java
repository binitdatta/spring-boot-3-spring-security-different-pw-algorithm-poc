package com.rollingstone.controller;


import com.rollingstone.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {

    @GetMapping("/customers")
    public String listCustomers(Model model) {
        List<Customer> customers = List.of(
                new Customer(1L, "Alice", "alice@example.com"),
                new Customer(2L, "Bob", "bob@example.com")
        );

        model.addAttribute("customers", customers);
        return "customers"; // resolves to src/main/resources/templates/customers.html
    }
}

