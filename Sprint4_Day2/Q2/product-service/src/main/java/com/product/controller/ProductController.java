package com.product.controller;

import com.product.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<Product> getAllProducts() {
        return List.of(
                new Product(1, "Laptop", 75000),
                new Product(2, "Mouse", 1500)
        );
    }

    @GetMapping("/test")
    public String test() {
        return "PRODUCT SERVICE REACHED";
    }

}

