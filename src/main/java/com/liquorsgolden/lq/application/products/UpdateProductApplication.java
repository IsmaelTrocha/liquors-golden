package com.liquorsgolden.lq.application.products;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.UpdateProductService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateProductApplication {

  private final UpdateProductService updateProductService;

  public void updateProduct(Product product) {
    product.setUpdateDate(LocalDateTime.now());
    updateProductService.updateProduct(product);
  }
}