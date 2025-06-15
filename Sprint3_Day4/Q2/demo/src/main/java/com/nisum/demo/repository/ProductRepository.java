package com.nisum.demo.repository;



import com.nisum.demo.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    List<ProductModel> findByCategory(String category);

    List<ProductModel> findByPriceBetween(BigDecimal min, BigDecimal max);

    List<ProductModel> findByNameContainingIgnoreCase(String name);

    @Query("SELECT p FROM ProductModel p WHERE LOWER(p.name) LIKE %:name% AND LOWER(p.category) = LOWER(:category)")
    List<ProductModel> searchByNameAndCategory(String name, String category);
}

