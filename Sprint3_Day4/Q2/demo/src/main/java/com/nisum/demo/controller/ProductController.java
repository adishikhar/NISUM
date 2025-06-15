package com.nisum.demo.controller;


import com.nisum.demo.model.ProductModel;
import com.nisum.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<ProductModel> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getById(@PathVariable Long id) {
        Optional<ProductModel> product = productRepository.findById(id);
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public String create(@RequestBody ProductModel product) {
        productRepository.save(product);
        return "Product created! ";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody ProductModel updated) {
        Optional<ProductModel> existing = productRepository.findById(id);
        if (existing.isPresent()) {
            ProductModel p = existing.get();
            p.setName(updated.getName());
            p.setDescription(updated.getDescription());
            p.setPrice(updated.getPrice());
            p.setStockQuantity(updated.getStockQuantity());
            p.setCategory(updated.getCategory());
            ResponseEntity.ok(productRepository.save(p));
            return "Product updated! ";
        }
        ResponseEntity.notFound().build();
        return "Product not found! ";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.notFound().build();
    }
}

