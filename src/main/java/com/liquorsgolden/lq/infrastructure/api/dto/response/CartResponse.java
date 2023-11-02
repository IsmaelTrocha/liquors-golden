package com.liquorsgolden.lq.infrastructure.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartResponse {

  private Long id;
  private CustomerCartResponse customerResponse;
}
