package com.liquorsgolden.lq.infrastructure.repository.orderproduct;

import com.liquorsgolden.lq.infrastructure.repository.order.OrderDto;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDER_PRODUCTS")
@Entity
@Data
public class OrderProductDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderDto order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductDto product;
}
