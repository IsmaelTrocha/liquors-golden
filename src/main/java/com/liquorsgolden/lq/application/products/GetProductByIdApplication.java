package com.liquorsgolden.lq.application.products;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.GetProductByIdService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetProductByIdApplication {

  private final GetProductByIdService getProductByIdService;

  public Product getProductById(Long id){
    return getProductByIdService.getProductById(id);
  }

  public Long getMaxIdProductId( ) {
    return getProductByIdService.findTopByOrderByIdDesc();
  }
}
