package com.liquorsgolden.lq.application.products;

import com.liquorsgolden.lq.application.category.GetCategoryByIdApplication;
import com.liquorsgolden.lq.application.proportion.GetProportionByIdApplication;
import com.liquorsgolden.lq.domain.entities.Category;
import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.entities.Proportion;
import com.liquorsgolden.lq.domain.entities.Status;
import com.liquorsgolden.lq.domain.services.product.UpdateProductService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateProductApplication {

  private final UpdateProductService updateProductService;
  private final GetStatusByIdApplication getStatusByIdApplication;
  private final GetProportionByIdApplication getProportionByIdApplication;
  private final GetCategoryByIdApplication getCategoryByIdApplication;

  public void updateProduct(Product product) {
    Category category = getCategoryByIdApplication.findById(product.getCategory().getId());
    Proportion proportion = getProportionByIdApplication.findById(product.getProportion().getId());
    Status status = getStatusByIdApplication.getStatusById(product.getStatus().getId());
    product.setCategory(category);
    product.setProportion(proportion);
    product.setStatus(status);
    product.setUpdateDate(LocalDateTime.now());
    updateProductService.updateProduct(product);

  }
}