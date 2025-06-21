package com.nisum.Q04.service;



import com.nisum.Q04.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private Map<Long, Product> productMap = new HashMap<>();
    private Long currentId = 1L;

    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    public Product getProductById(Long id) {
        return productMap.get(id);
    }

    public Product addProduct(Product product) {
        product.setId(currentId++);
        productMap.put(product.getId(), product);
        return product;
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        if (productMap.containsKey(id)) {
            updatedProduct.setId(id);
            productMap.put(id, updatedProduct);
            return updatedProduct;
        }
        return null;
    }

    public boolean deleteProduct(Long id) {
        return productMap.remove(id) != null;
    }

    public void clearAll() {
        productMap.clear();
        currentId = 1L;
    }
}

