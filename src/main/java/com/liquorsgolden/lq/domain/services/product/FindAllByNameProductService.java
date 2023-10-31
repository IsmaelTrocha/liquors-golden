package com.liquorsgolden.lq.domain.services.product;

import com.liquorsgolden.lq.domain.entities.Product;
import java.util.List;

public interface FindAllByNameProductService {

  List<Product> findAllByName(String name);

}
