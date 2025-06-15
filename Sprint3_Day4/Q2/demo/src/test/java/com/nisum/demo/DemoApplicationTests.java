package com.nisum.demo;



import com.nisum.demo.model.ProductModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreateAndGetProduct() throws Exception {
		ProductModel product = new ProductModel();
		product.setName("Pensile");
		product.setPrice(BigDecimal.valueOf(150));
		product.setCategory("Stationary");

		mockMvc.perform(post("/products")
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(product)))
				.andExpect(status().isOk());

		mockMvc.perform(get("/products"))
				.andExpect(status().isOk());
	}
}


