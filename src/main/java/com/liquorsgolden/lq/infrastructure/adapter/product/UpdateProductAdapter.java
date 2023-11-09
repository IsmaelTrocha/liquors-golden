package com.liquorsgolden.lq.infrastructure.adapter.product;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.CalculateIvaService;
import com.liquorsgolden.lq.domain.services.product.UpdateProductService;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductDtoMapper;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateProductAdapter implements UpdateProductService {

  private final ProductRepository productRepository;
  private final ProductDtoMapper productDtoMapper;
  private final CalculateIvaService calculateIvaService;
  @Override
  @Transactional
  public Product updateProduct(Product product) {
    // Calcular el IVA antes de guardar el producto
    calculateIvaService.calculateIva(product);

    return productDtoMapper.toEntity(productRepository.save(productDtoMapper.toDto(product)));
  }
}
