package com.liquorsgolden.lq.infrastructure.adapter.product;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.FindAllByNameProductService;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductDtoMapper;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FindAllByNameProductAdapter implements FindAllByNameProductService {

  private final ProductRepository productRepository;
  private final ProductDtoMapper productDtoMapper;


  @Override
  public List<Product> findAllByName(String name) {
    return productDtoMapper.toEntity(productRepository.findAllByNameContaining(name));
  }
}
