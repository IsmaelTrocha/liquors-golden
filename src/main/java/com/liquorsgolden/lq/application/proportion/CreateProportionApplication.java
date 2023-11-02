package com.liquorsgolden.lq.application.proportion;

import com.liquorsgolden.lq.domain.entities.Proportion;
import com.liquorsgolden.lq.domain.services.proportion.CreateProportionService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateProportionApplication {

  private final CreateProportionService createProportionService;

  public Proportion createProportion(Proportion proportion) {
    return createProportionService.createProportion(proportion);
  }

}
