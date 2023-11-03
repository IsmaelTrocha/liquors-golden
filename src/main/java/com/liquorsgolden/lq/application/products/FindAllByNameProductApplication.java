package com.liquorsgolden.lq.application.products;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.FindAllByNameProductService;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindAllByNameProductApplication {

  private final FindAllByNameProductService findAllByNameProductService;

  public List<Product> findAllByNameIn(String name) {
    return findAllByNameProductService.findAllByName(name);
  }
}
