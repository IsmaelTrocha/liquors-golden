package com.liquorsgolden.lq.infrastructure.api.dto.response;

import lombok.Data;

@Data
public class OrderResponse {

  private Double total;
  private Long customerId;
  private Long orderId;
}
