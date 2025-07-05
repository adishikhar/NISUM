package com.nisum.orders.external;



public interface PaymentGatewayClient {
    void charge(String product);
}
