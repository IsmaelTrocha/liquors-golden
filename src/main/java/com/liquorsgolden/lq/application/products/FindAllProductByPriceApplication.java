package com.liquorsgolden.lq.application.products;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.FindAllByPriceProductService;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindAllProductByPriceApplication {

  private final FindAllByPriceProductService findAllByPriceProductService;

  public List<Product> findAllByPriceProduct(Double price, Double price2) {
    return findAllByPriceProductService.findAllByPrice(price, price2);
  }
}
