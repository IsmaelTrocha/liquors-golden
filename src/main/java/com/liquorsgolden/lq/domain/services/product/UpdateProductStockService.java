package com.liquorsgolden.lq.domain.services.product;

public interface UpdateProductStockService {
  void updateStock(Long productId, int quantity);
}

