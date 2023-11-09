package com.liquorsgolden.lq.infrastructure.adapter.order;

import com.liquorsgolden.lq.domain.entities.Order;
import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.order.CreateOrderService;
import com.liquorsgolden.lq.domain.services.product.GetProductByIdService;
import com.liquorsgolden.lq.domain.services.product.UpdateProductStockService;
import com.liquorsgolden.lq.infrastructure.repository.order.OrderDto;
import com.liquorsgolden.lq.infrastructure.repository.order.OrderDtoMapper;
import com.liquorsgolden.lq.infrastructure.repository.order.OrderRepository;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CreateOrderAdapter implements CreateOrderService {

    private final OrderRepository orderRepository;
    private final OrderDtoMapper orderDtoMapper;
    private final GetProductByIdService productService;
    private final UpdateProductStockService updateProductStockService;

    @Override
    @Transactional
    public Order createOrder(Order order) {
        order.setCreationOrder(LocalDateTime.now());
        // Calcular el total como la suma de los precios de los productos
        double total = calculateTotal(order.getProductIds());

        // Establecer el total en la orden
        order.setTotal(total);

        // Calcular el iva de los productos
        double iva = calculateIva(order.getProductIds());

        // Establecer el iva en la orden
        order.setIva(iva);

        // calcular el total sin iva
        double totalProducts = total - iva;

        // Establecer el total sin iva en la orden
        order.setTotalProducts(totalProducts);

        // Calcular la cantidad de productos en la orden
        int quantity = order.getProductIds().size();

        // Establecer la cantidad en la orden
        order.setQuantity(quantity);


        for (Long productId : order.getProductIds()) {
            updateProductStockService.updateStock(productId, 1); // Restar 1 unidad del stock
        }

        // Mapear la orden a su DTO
        OrderDto orderDto = orderDtoMapper.toDto(order);

        // Configurar las relaciones con los productos en la entidad OrderDto
        List<ProductDto> productDtos = new ArrayList<>();
        for (Long productId : order.getProductIds()) {
            Product product = productService.getProductById(productId);
            ProductDto productDto = new ProductDto();
            productDto.setId(productId);
            productDtos.add(productDto);
        }
        orderDto.setProducts(productDtos);

        // Guardar la orden en la base de datos
        OrderDto savedOrderDto = orderRepository.save(orderDto);

        // Mapear la orden guardada de nuevo a la entidad Order

        return orderDtoMapper.toEntity(savedOrderDto);

        //return orderDtoMapper.toEntity(orderRepository.save(orderDtoMapper.toDto(order)));

    }

    private double calculateTotal(List<Long> productIds) {
        double total = 0.0;

        for (Long productId : productIds) {
            Product product = productService.getProductById(productId);
            total += product.getPrice();
        }

        return total;
    }

    private double calculateIva(List<Long> productIds) {
        double iva = 0.0;

        for (Long productId : productIds) {
            Product product = productService.getProductById(productId);
            iva += product.getIva();
        }

        return iva;
    }



}


