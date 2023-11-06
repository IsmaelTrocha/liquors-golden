package com.liquorsgolden.lq.application.products;

import com.liquorsgolden.lq.application.category.GetCategoryByIdApplication;
import com.liquorsgolden.lq.application.proportion.GetProportionByIdApplication;
import com.liquorsgolden.lq.domain.entities.Category;
import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.entities.Proportion;
import com.liquorsgolden.lq.domain.services.product.CreateProductService;
import com.liquorsgolden.lq.domain.services.product.UpdateProductStockService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateProductApplication {

  private final CreateProductService createProductService;
  private final GetProductByIdApplication getProductApplication;
  private final UpdateProductStockService updateProductStockService;
  private final GetCategoryByIdApplication getCategoryByIdApplication;
  private final GetProportionByIdApplication getProportionByIdApplication;

  public Product createProduct(Product product) {

    Category category1 = getCategoryByIdApplication.findById(product.getCategory().getId());
    Proportion proportion1 = getProportionByIdApplication.findById(product.getProportion().getId());
    product.setCategory(category1);
    product.setProportion(proportion1);
    product.setCreateDate(LocalDateTime.now());

    return createProductService.createProduct(product);
  }
}
