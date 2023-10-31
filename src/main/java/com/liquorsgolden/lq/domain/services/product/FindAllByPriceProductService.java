package com.liquorsgolden.lq.domain.services.product;

import com.liquorsgolden.lq.domain.entities.Product;
import java.util.List;

public interface FindAllByPriceProductService {

  List<Product> findAllByPrice(Double price, Double price2);

}
