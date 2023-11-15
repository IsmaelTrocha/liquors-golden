package com.liquorsgolden.lq.domain.services.product;

import java.time.LocalDateTime;

public interface UpdateProductDiscountService {

  void updateProductDiscount(Double discount, LocalDateTime updateDate,Long id);
}
