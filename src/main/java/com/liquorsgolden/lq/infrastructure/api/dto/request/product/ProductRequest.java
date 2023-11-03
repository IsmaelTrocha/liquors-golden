package com.liquorsgolden.lq.infrastructure.api.dto.request.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

  private String name;
  private String description;
  private String imageUrl;
  private Double price;
  private int stock;
  private Long categoryId;
  private Long statusId;
  private Long proportionId;

}
