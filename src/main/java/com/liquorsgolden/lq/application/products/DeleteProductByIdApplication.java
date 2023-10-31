package com.liquorsgolden.lq.application.products;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.DeleteProductByIdService;
import com.liquorsgolden.lq.shared.exception.message.product.ProductNotFoundException;
import java.util.Objects;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteProductByIdApplication {

  private final DeleteProductByIdService deleteProductByIdService;
  private final GetProductByIdApplication getProductByIdService;


  public void deleteProductById(Long id) {
    Product product = getProductByIdService.getProductById(id);
    if (Objects.isNull(product)) {
      throw new ProductNotFoundException("Product not found");
    }
    deleteProductByIdService.deleteProduct(product.getId());
  }

}
