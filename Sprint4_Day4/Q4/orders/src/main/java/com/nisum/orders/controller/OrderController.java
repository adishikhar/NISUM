package com.nisum.orders.controller;



import com.nisum.orders.model.Order;
import com.nisum.orders.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;
    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order place(@RequestParam String product) {
        return service.placeOrder(product);
    }
}

