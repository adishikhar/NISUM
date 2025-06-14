package com.nisum.demo.controller;

import com.nisum.demo.model.ProductModel;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    private List<ProductModel> products = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();

    @GetMapping
    public List<ProductModel> getAllProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String dir,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        List<ProductModel> filtered = products.stream()
                .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
                .filter(p -> minPrice == null || p.getPrice() >= minPrice)
                .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
                .collect(Collectors.toList());

        if (sort.equals("price")) {
            filtered.sort(Comparator.comparing(ProductModel::getPrice));
        } else if (sort.equals("name")) {
            filtered.sort(Comparator.comparing(ProductModel::getName));
        } else {
            filtered.sort(Comparator.comparing(ProductModel::getId));
        }

        if (dir.equals("desc")) {
            Collections.reverse(filtered);
        }

        int start = page * size;
        int end = Math.min(start + size, filtered.size());
        if (start > filtered.size()) {
            return new ArrayList<>();
        }

        return filtered.subList(start, end);
    }

    @GetMapping("/{id}")
    public ProductModel getProductById(@PathVariable Long id) {
        for (ProductModel p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        throw new RuntimeException("Product not found");
    }

    @PostMapping
    public String createProduct(@RequestBody ProductModel product) {
        // Simple validation
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new RuntimeException("Product name is required");
        }
        if (product.getPrice() < 0) {
            throw new RuntimeException("Price cannot be negative");
        }
        if (product.getStockQuantity() < 0) {
            throw new RuntimeException("Stock quantity cannot be negative");
        }
        if (product.getCategory() == null || product.getCategory().trim().isEmpty()) {
            throw new RuntimeException("Category is required");
        }

        product.setId(idCounter.incrementAndGet());
        products.add(product);
        return "Product created!";
    }

    @PutMapping("/{id}")
    public ProductModel updateProduct(@PathVariable Long id, @RequestBody ProductModel newProduct) {
        for (ProductModel p : products) {
            if (p.getId().equals(id)) {
                // Simple validation
                if (newProduct.getName() == null || newProduct.getName().trim().isEmpty()) {
                    throw new RuntimeException("Product name is required");
                }
                if (newProduct.getPrice() < 0) {
                    throw new RuntimeException("Price cannot be negative");
                }
                if (newProduct.getStockQuantity() < 0) {
                    throw new RuntimeException("Stock quantity cannot be negative");
                }
                if (newProduct.getCategory() == null || newProduct.getCategory().trim().isEmpty()) {
                    throw new RuntimeException("Category is required");
                }

                p.setName(newProduct.getName());
                p.setDescription(newProduct.getDescription());
                p.setPrice(newProduct.getPrice());
                p.setStockQuantity(newProduct.getStockQuantity());
                p.setCategory(newProduct.getCategory());
                return p;
            }
        }
        throw new RuntimeException("Product not found");
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        products.removeIf(p -> p.getId().equals(id));
        return "Product deleted!";
    }
}
