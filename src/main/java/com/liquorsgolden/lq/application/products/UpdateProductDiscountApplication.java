package com.liquorsgolden.lq.application.products;

import com.liquorsgolden.lq.application.products.proccess.ProductValidations;
import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.UpdateProductDiscountService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateProductDiscountApplication {

  private final UpdateProductDiscountService updateProductDiscountService;
  private final GetProductByIdApplication getProductByIdApplication;
  private final ProductValidations productValidations;

  public void updateProductDiscount(Double discount, Long id) {
    Product product = getProductByIdApplication.getProductById(id);
    Double percentage = productValidations.validateDiscount(product, discount);
    product.setOfferPrice((product.getPrice() - percentage));

    product.setDiscountActive(true);
    product.setUpdateDate(LocalDateTime.now());
    updateProductDiscountService.updateProductDiscount(product.getOfferPrice(), LocalDateTime.now(),
        product.getId());
  }

}
