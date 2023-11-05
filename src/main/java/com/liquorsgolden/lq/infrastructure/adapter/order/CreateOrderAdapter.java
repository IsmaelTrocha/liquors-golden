package com.liquorsgolden.lq.infrastructure.adapter.order;

import com.liquorsgolden.lq.domain.entities.Order;
import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.order.CreateOrderService;
import com.liquorsgolden.lq.domain.services.product.GetProductByIdService;
import com.liquorsgolden.lq.infrastructure.repository.order.OrderDtoMapper;
import com.liquorsgolden.lq.infrastructure.repository.order.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class CreateOrderAdapter implements CreateOrderService {

    private final OrderRepository orderRepository;
    private final OrderDtoMapper orderDtoMapper;
    private final GetProductByIdService productService;

    @Override
    public Order createOrder(Order order) {
        order.setCreationOrder(LocalDateTime.now());
        // Calcular el total como la suma de los precios de los productos
        double total = calculateTotal(order.getProductIds());

        // Establecer el total en la orden
        order.setTotal(total);

        // Realizar el mapeo y guardar la orden en la base de datos
        return orderDtoMapper.toEntity(orderRepository.save(orderDtoMapper.toDto(order)));
    }

    private double calculateTotal(List<Long> productIds) {
        double total = 0.0;

        for (Long productId : productIds) {
            Product product = productService.getProductById(productId); // Obtén el producto por su ID desde la base de datos
            total += product.getPrice();
        }

        return total;
    }
}

