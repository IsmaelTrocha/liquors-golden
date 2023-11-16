package com.liquorsgolden.lq.application.products.proccess;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.shared.exception.code.ExceptionCode;
import com.liquorsgolden.lq.shared.exception.message.product.DiscountNotAvailableException;
import com.liquorsgolden.lq.shared.utils.MessageUtils;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductValidations {

  private final MessageUtils messageUtils;

  public Double validateDiscount(Product product, Double discount) {
    if (discount < 0 || discount > 100) {
      throw new DiscountNotAvailableException(
          messageUtils.getMessage(ExceptionCode.DISCOUNT_NOT_AVAILABLE.getType(),
              discount.toString()));
    }
    return (product.getPrice() * discount) / 100;
  }

}
