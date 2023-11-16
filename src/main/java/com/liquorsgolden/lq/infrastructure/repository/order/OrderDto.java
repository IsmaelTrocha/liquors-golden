package com.liquorsgolden.lq.infrastructure.repository.order;

import com.liquorsgolden.lq.infrastructure.repository.address.AddressDto;
import com.liquorsgolden.lq.infrastructure.repository.customer.CustomerDto;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductDto;
import com.liquorsgolden.lq.infrastructure.repository.status.StatusDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDERS")
@Entity
@Data
public class OrderDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private CustomerDto customer;

  @ManyToMany
  @JoinTable(
          name = "ORDER_PRODUCTS",
          joinColumns = @JoinColumn(name = "order_id"),
          inverseJoinColumns = @JoinColumn(name = "product_id")
  )
  private List<ProductDto> products;


  @Column(name = "creation_date")
  private LocalDateTime creationOrder;

  @Column(name = "finish_date")
  private LocalDateTime finishDate;

  @Column(name = "delivery_date")
  private LocalDateTime deliveryDate;

  @Column(name = "quantity")
  private int quantity;

  @Column(name = "total_price")
  private Double total;

  @Column(name = "total_products")
  private Double totalProducts;

  @Column(name = "iva")
  private Double iva;

  @Column(name = "consumo")
  private Double consumo;

  @ManyToOne
  @JoinColumn(name = "address_id")
  private AddressDto address;

  @ManyToOne
  @JoinColumn(name = "status_id")
  private StatusDto status;
}
