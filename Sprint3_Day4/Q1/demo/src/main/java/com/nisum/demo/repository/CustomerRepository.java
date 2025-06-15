package com.nisum.demo.repository;

import com.nisum.demo.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface    CustomerRepository extends JpaRepository<CustomerModel, Long> {
    List<CustomerModel> findByEmailContaining(String keyword);
    List<CustomerModel> findByRegisteredDateAfter(LocalDate date);

    @Query("SELECT c FROM CustomerModel c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<CustomerModel> findByNameContaining(String name);
}

