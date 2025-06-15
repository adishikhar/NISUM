package com.nisum.demo.repository;


import com.nisum.demo.model.ProductModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindByCategory() {
        ProductModel p = new ProductModel();
        p.setName("Laptop");
        p.setPrice(BigDecimal.valueOf(1000));
        p.setCategory("Electronics");
        productRepository.save(p);

        List<ProductModel> result = productRepository.findByCategory("Electronics");
        assertThat(result).isNotEmpty();
    }

    @Test
    public void testFindByPriceBetween() {
        ProductModel p = new ProductModel();
        p.setName("TV");
        p.setPrice(BigDecimal.valueOf(500));
        productRepository.save(p);

        List<ProductModel> result = productRepository.findByPriceBetween(BigDecimal.valueOf(100), BigDecimal.valueOf(800));
        assertThat(result).isNotEmpty();
    }

    @Test
    public void testFindByNameContainingIgnoreCase() {
        ProductModel p = new ProductModel();
        p.setName("Phone");
        p.setPrice(BigDecimal.valueOf(300));
        productRepository.save(p);

        List<ProductModel> result = productRepository.findByNameContainingIgnoreCase("phone");
        assertThat(result).isNotEmpty();
    }
}

