package com.liquorsgolden.lq.application.products;

import com.liquorsgolden.lq.domain.services.product.UpdateStockProductService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateStockProductApplication {

  private final UpdateStockProductService updateStockProductService;

  public void updateProductStock(int quantity, String product) {
    updateStockProductService.updateStockProduct(quantity, product);
  }

}
