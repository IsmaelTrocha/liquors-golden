package com.liquorsgolden.lq.application.products;

import com.liquorsgolden.lq.domain.services.product.UpdateProductStockService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateStockProductApplication {

  private final UpdateProductStockService updateProductStockService;

  public void updateProductStock(Long productId, int quantity) {
    updateProductStockService.updateStock(productId, quantity);
  }

}
