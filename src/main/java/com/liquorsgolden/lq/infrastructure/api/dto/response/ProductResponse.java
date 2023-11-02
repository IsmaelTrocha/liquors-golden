package com.liquorsgolden.lq.infrastructure.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor

public class ProductResponse {

  private String name;
  private String description;
  private String imgUrl;
  private byte[] imageData;

}
