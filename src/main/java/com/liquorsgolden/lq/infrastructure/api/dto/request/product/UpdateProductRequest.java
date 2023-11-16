package com.liquorsgolden.lq.infrastructure.api.dto.request.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {

  private Long id;
  private String name;
  private String description;
  private Double price;
  private Long categoryId;
  private Long proportionId;
  private Long statusId;
  private double alcoholPercentage;

}
