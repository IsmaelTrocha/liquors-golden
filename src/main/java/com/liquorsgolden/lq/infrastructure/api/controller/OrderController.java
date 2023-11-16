package com.liquorsgolden.lq.infrastructure.api.controller;

import com.liquorsgolden.lq.application.order.CreateOrderApplication;
import com.liquorsgolden.lq.domain.entities.Order;
import com.liquorsgolden.lq.infrastructure.api.dto.request.order.OrderRequest;
import com.liquorsgolden.lq.infrastructure.api.dto.response.OrderResponse;
import com.liquorsgolden.lq.infrastructure.api.mapper.request.order.OrderRequestMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/orders")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {

  private final CreateOrderApplication createOrderApplication;
  private final OrderRequestMapper orderRequestMapper;

  @PostMapping("/create")
  @Operation(summary = "Crear una orden", description = "Crea una nueva orden con los datos proporcionados en la solicitud.")
  public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
    Order order = orderRequestMapper.toEntity(orderRequest);
    Order createdOrder = createOrderApplication.createProduct(order);

    // Crear una respuesta que incluye el total, el customer y el id de la venta
    OrderResponse orderResponse = new OrderResponse();
    orderResponse.setTotal(createdOrder.getTotal());
    orderResponse.setCustomerId(createdOrder.getCustomer().getId());
    orderResponse.setOrderId(createdOrder.getId());
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setTotalProducts(createdOrder.getTotalProducts());
        orderResponse.setIva(createdOrder.getIva());
        orderResponse.setConsumo(createdOrder.getConsumo());
        orderResponse.setTotal(createdOrder.getTotal());
        orderResponse.setCustomerId(createdOrder.getCustomer().getId());
        orderResponse.setOrderId(createdOrder.getId());

    return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
  }

}
