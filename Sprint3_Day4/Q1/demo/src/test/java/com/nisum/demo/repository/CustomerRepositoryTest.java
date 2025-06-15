package com.nisum.demo.repository;



import com.nisum.demo.model.CustomerModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repo;

    @Test
    void findByEmailContaining_shouldWork() {
        repo.save(new CustomerModel("Dog", "dog@gmail.com", LocalDate.now()));
        repo.save(new CustomerModel("Tiger", "tiger@gmail.com", LocalDate.now()));
        List<CustomerModel> list = repo.findByEmailContaining("dog");
        assertThat(list).hasSize(1)
                .extracting(CustomerModel::getEmail)
                .containsExactly("dog@gmail.com");
    }

    @Test
    void findByRegisteredDateAfter_shouldWork() {
        repo.save(new CustomerModel("Sir", "sir@gmail.com", LocalDate.of(2002,2,2)));
        repo.save(new CustomerModel("Mam", "mam@gmail.com", LocalDate.of(2025,1,1)));
        List<CustomerModel> list = repo.findByRegisteredDateAfter(LocalDate.of(2021,1,1));
        assertThat(list).hasSize(1)
                .extracting(CustomerModel::getName)
                .containsExactly("Mam");
    }

    @Test
    void findByNameContaining_shouldWork() {
        repo.save(new CustomerModel("Aditya", "aditya@gmail.com", LocalDate.now()));
        repo.save(new CustomerModel("Shikhar", "shikhar@gmail.com", LocalDate.now()));
        List<CustomerModel> list = repo.findByNameContaining("har");
        assertThat(list).hasSize(1)
                .extracting(CustomerModel::getName)
                .containsExactly("Shikhar");
    }
}

