package com.nisum.demo.controller;



import com.nisum.demo.model.CustomerModel;
import com.nisum.demo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository repo;

    public CustomerController(CustomerRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public String addCustomer(@RequestBody CustomerModel c) {

        if (c.getName() == null || c.getName().isBlank()) {
            throw new RuntimeException("Name is required");
        }
        if (c.getEmail() == null || !c.getEmail().contains("@")) {
            throw new RuntimeException("A email is required");
        }
        if (c.getRegisteredDate() == null) {
            throw new RuntimeException("A Registered Date is required");
        }
        repo.save(c);
        return "Customer added!";
    }

    @GetMapping("/{id}")
    public CustomerModel getCustomer(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @GetMapping
    public List<CustomerModel> getAllCustomers() {
        return repo.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        repo.deleteById(id);
        return "Customer deleted!";
    }

}
