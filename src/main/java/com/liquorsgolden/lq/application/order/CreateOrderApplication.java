package com.liquorsgolden.lq.application.order;

import com.liquorsgolden.lq.application.customer.FindCustomerByIdApplication;
import com.liquorsgolden.lq.domain.entities.Order;
import com.liquorsgolden.lq.domain.services.order.CreateOrderService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class CreateOrderApplication {

  private final CreateOrderService createOrderService;
  private final FindCustomerByIdApplication findCustomerByIdApplication;

  public Order createProduct(Order order) {
    findCustomerByIdApplication.exists(order.getCustomer().getId());
    return createOrderService.createOrder(order);
  }
}