package com.liquorsgolden.lq.application.products;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.GetAllProductByCategoryIdService;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAllProductByCategoryIdApplication {

  private final GetAllProductByCategoryIdService getAllProductByCategoryIdService;

  public List<Product> findAllProductByCategoryId(Long id) {
    return getAllProductByCategoryIdService.getProductsByCategory(id);
  }
}
