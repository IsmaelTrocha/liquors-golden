package com.liquorsgolden.lq.domain.services.proportion;

import com.liquorsgolden.lq.domain.entities.Proportion;

public interface GetProportionByIdService {

  Proportion findById(Long proportion);

}
