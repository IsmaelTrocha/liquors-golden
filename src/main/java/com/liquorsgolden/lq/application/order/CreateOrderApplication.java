package com.liquorsgolden.lq.application.order;

import com.liquorsgolden.lq.domain.entities.Order;
import com.liquorsgolden.lq.domain.services.order.CreateOrderService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateOrderApplication {

    private final CreateOrderService createOrderService;

    public Order createProduct(Order order) {
        return createOrderService.createOrder(order);
    }
}