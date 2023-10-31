package com.liquorsgolden.lq.application.products;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.CreateProductService;
import com.liquorsgolden.lq.domain.services.product.UpdateStockProductService;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateProductApplication {

  private final CreateProductService createProductService;
  private final GetProductByIdApplication getProductApplication;
  private final UpdateStockProductService updateStockProductService;

  public Product createProduct(Product product) {
    Product products = getProductApplication.getProductById(product.getId());

    if (Objects.nonNull(products)) {
      updateStockProductService.updateStockProduct(products.getStock() + product.getStock(),
          products.getName());
    }
    if (Objects.isNull(products)) {
      throw new RuntimeException("Product " + product.getId() + "was not found.");
    }
    product.setCreateDate(LocalDateTime.now());
    return createProductService.createProduct(product);
  }
}
