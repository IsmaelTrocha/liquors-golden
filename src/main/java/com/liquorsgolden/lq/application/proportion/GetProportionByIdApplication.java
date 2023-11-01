package com.liquorsgolden.lq.application.proportion;

import com.liquorsgolden.lq.domain.entities.Proportion;
import com.liquorsgolden.lq.domain.services.proportion.GetProportionByIdService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetProportionByIdApplication {

  private final GetProportionByIdService getProportionByIdService;

  public Proportion findById(Long id) {
    return getProportionByIdService.findById(id);
  }

}
