package com.liquorsgolden.lq.infrastructure.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor

public class ProductResponse {

  private Long id;
  private String name;
  private String description;
  private String imageUrl;
  private byte[] imageData;
  private Double price;
  private Double offerPrice;
  private CategoryResponse category;
  private ProportionResponse proportion;
  private int stock;
  private boolean discountActive;
  private StatusResponse status;

}
