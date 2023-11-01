package com.liquorsgolden.lq.application.products;

import com.liquorsgolden.lq.application.image.ImageUploadApplication;
import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.CreateProductService;
import com.liquorsgolden.lq.domain.services.product.UpdateStockProductService;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
public class CreateProductApplication {

  private final CreateProductService createProductService;
  private final GetProductByIdApplication getProductApplication;
  private final UpdateStockProductService updateStockProductService;
  private final ImageUploadApplication imageUploadApplication;

  public Product createProduct(Product product, MultipartFile file) {
    Product products = getProductApplication.getProductById(product.getId());

    if (Objects.nonNull(products)) {
      updateStockProductService.updateStockProduct(products.getStock() + product.getStock(),
          products.getName());
    }
    if (Objects.isNull(products)) {
      throw new RuntimeException("Product " + product.getId() + "was not found.");
    }
    imageUploadApplication.uploadProductImage(product.getId(), file);
    product.setCreateDate(LocalDateTime.now());
    return createProductService.createProduct(product);
  }
}
