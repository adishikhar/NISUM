package com.nisum.orders;

import com.nisum.orders.external.PaymentGatewayClient;
import com.nisum.orders.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private PaymentGatewayClient gatewayClient;

    @Test
    void placeOrder_callsGateway_andPersistsOrder() {
        // Mock payment gateway
        doNothing().when(gatewayClient).charge("Book");

        // Send real HTTP request
        ResponseEntity<Order> response = restTemplate.postForEntity(
                "/orders?product=Book", null, Order.class
        );

        // Assertions
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Order order = response.getBody();
        assertThat(order).isNotNull(); // <- this failed before
        assertThat(order.getId()).isNotNull();
        assertThat(order.getProduct()).isEqualTo("Book");

        // Verify gateway interaction
        verify(gatewayClient, times(1)).charge("Book");
    }
}
