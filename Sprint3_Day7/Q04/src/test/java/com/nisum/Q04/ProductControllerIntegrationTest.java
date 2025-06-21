package com.nisum.Q04;



import com.nisum.Q04.model.Product;
import com.nisum.Q04.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductService ProductService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        ProductService.clearAll(); // Reset state before each test
    }

    @Test
    public void testAddProduct() throws Exception {
        Product product = new Product();
        product.setName("Pen");
        product.setDescription("Blue ink pen");
        product.setPrice(10.0);
        product.setStockQuantity(100);
        product.setCategory("Stationery");

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Pen")));
    }

    @Test
    public void testGetAllProducts() throws Exception {
        Product p = new Product();
        p.setName("Book");
        p.setDescription("Notebook");
        p.setPrice(50);
        p.setStockQuantity(20);
        p.setCategory("Stationery");
        ProductService.addProduct(p);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("Book")));
    }

    @Test
    public void testGetProductById() throws Exception {
        Product p = new Product();
        p.setName("Mouse");
        p.setDescription("Wireless mouse");
        p.setPrice(500);
        p.setStockQuantity(15);
        p.setCategory("Electronics");
        Product saved = ProductService.addProduct(p);

        mockMvc.perform(get("/products/" + saved.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Mouse")));
    }

    @Test
    public void testUpdateProduct() throws Exception {
        Product p = new Product();
        p.setName("Chair");
        p.setDescription("Plastic chair");
        p.setPrice(300);
        p.setStockQuantity(5);
        p.setCategory("Furniture");
        Product saved = ProductService.addProduct(p);

        saved.setName("Updated Chair");

        mockMvc.perform(put("/products/" + saved.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saved)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Updated Chair")));
    }

    @Test
    public void testDeleteProduct() throws Exception {
        Product p = new Product();
        p.setName("Table");
        p.setDescription("Wooden table");
        p.setPrice(800);
        p.setStockQuantity(3);
        p.setCategory("Furniture");
        Product saved = ProductService.addProduct(p);

        mockMvc.perform(delete("/products/" + saved.getId()))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/products/" + saved.getId()))
                .andExpect(status().isNotFound());
    }
}

