package com.liquorsgolden.lq.application.products;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.UpdateProductService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateProductApplication {

  private final UpdateProductService updateProductService;

  public void updateProduct(Product product) {
    updateProductService.updateProduct(product);
  }

}
