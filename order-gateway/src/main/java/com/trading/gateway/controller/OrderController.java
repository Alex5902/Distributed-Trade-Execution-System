package com.trading.gateway.controller;

import com.trading.common.model.Order;
import com.trading.gateway.service.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        orderProducer.sendOrder(order);
        return "Order sent to Kafka!";
    }
}
