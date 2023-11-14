package com.liquorsgolden.lq.application.products;

import com.liquorsgolden.lq.domain.entities.Status;
import com.liquorsgolden.lq.domain.services.product.GetStatusByIdService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetStatusByIdApplication {

  private final GetStatusByIdService getStatusByIdService;

  public Status getStatusById(Long id) {
    return getStatusByIdService.findById(id);
  }

}
