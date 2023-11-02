package com.liquorsgolden.lq.infrastructure.adapter.product;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.GetProductByIdService;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductDtoMapper;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductRepository;
import com.liquorsgolden.lq.shared.exception.code.ExceptionCode;
import com.liquorsgolden.lq.shared.exception.message.product.ProductNotFoundException;
import com.liquorsgolden.lq.shared.utils.MessageUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetByIdProductAdapter implements GetProductByIdService {

  private final ProductRepository productRepository;
  private final ProductDtoMapper productDtoMapper;
  private final MessageUtils messageUtils;

  @Override
  public Product getProductById(Long id) {
    return productDtoMapper.toEntity(productRepository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException(
            messageUtils.getMessage(ExceptionCode.PRODUCT_NOT_FOUND.getType(), id.toString()))));
  }

  @Override
  public Long findTopByOrderByIdDesc() {
    return productRepository.findTopByOrderByIdDesc();
  }


}
