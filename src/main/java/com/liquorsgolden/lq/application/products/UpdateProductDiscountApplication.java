package com.liquorsgolden.lq.application.products;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.UpdateProductDiscountService;
import com.liquorsgolden.lq.shared.exception.message.product.DiscountNotAvailableException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateProductDiscountApplication {

  private final UpdateProductDiscountService updateProductDiscountService;
  private final GetProductByIdApplication getProductByIdApplication;

  public void updateProductDiscount(Double discount, Long id) {
    Product product = getProductByIdApplication.getProductById(id);

    product.setDiscountActive(true);
  }

}
