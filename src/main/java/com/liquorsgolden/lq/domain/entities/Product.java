package com.liquorsgolden.lq.domain.entities;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  private Long id;
  private String name;
  private String description;
  private String imageUrl;
  private Double price;
  private Double offerPrice;
  private int stock;
  private Category category;
  private Status status;
  private boolean discountActive;
  private Proportion proportion;
  private LocalDateTime createDate;
  private LocalDateTime updateDate;
  private LocalDateTime hideDate;
  private Double alcoholPercentage;
  private Double iva;
  private Double consumo;
  private int soldUnits;
}