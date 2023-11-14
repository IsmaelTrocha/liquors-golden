package com.liquorsgolden.lq.domain.services.product;

import com.liquorsgolden.lq.domain.entities.Status;

public interface GetStatusByIdService {

  Status findById(Long id);

}
