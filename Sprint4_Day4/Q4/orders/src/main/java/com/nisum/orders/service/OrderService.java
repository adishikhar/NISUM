package com.nisum.orders.service;

import com.nisum.orders.external.PaymentGatewayClient;
import com.nisum.orders.model.Order;
import com.nisum.orders.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repo;
    private final PaymentGatewayClient gateway;

    public OrderService(OrderRepository repo, PaymentGatewayClient gateway) {
        this.repo = repo;
        this.gateway = gateway;
    }

    public Order placeOrder(String product) {
        gateway.charge(product); // Calls mocked PaymentGatewayClient
        return repo.save(new Order(product)); // Saves to real H2 DB
    }
}
