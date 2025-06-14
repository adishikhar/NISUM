package com.nisum.demo.controller;

import com.nisum.demo.model.ProductModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private List<ProductModel> products = new ArrayList<>();


    public ProductController() {
        products.add(new ProductModel(1, "Bottle", 1000.0));
        products.add(new ProductModel(2, "Brush", 500.0));
    }

    @GetMapping
    public List<ProductModel> getAllProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public ProductModel getProductById(@PathVariable int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public String addProduct(@RequestBody ProductModel product) {
        products.add(product);
        return "Product added successfully";
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody ProductModel updatedProduct) {
        for (ProductModel p : products) {
            if (p.getId() == id) {
                p.setName(updatedProduct.getName());
                p.setPrice(updatedProduct.getPrice());
                return "Product updated successfully";
            }
        }
        return "Product not found.";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        boolean removed = products.removeIf(p -> p.getId() == id);
        return removed ? "Product deleted successfully" : "Product not found";
    }
}
