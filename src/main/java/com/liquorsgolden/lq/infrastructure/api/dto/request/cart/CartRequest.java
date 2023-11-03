package com.liquorsgolden.lq.infrastructure.api.dto.request.cart;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CartRequest {

   @NotBlank(message = "E")
  private Long customerId;

}
