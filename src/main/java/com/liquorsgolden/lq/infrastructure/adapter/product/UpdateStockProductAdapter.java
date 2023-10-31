package com.liquorsgolden.lq.infrastructure.adapter.product;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.UpdateProductService;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductDtoMapper;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateStockProductAdapter implements UpdateProductService {

  private final ProductRepository productRepository;
  private final ProductDtoMapper productDtoMapper;


  @Override
  public Product updateProduct(Product product) {
    return productDtoMapper.toEntity(
        productRepository.updateProduct(
            product.getCategory().getId(),
            product.getPrice(),
            product.getStatus().getId(),
            product.getDescription(),
            product.getId()
        ));
  }
}
