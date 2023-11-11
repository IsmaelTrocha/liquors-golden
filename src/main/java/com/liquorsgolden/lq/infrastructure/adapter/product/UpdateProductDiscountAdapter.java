package com.liquorsgolden.lq.infrastructure.adapter.product;

import com.liquorsgolden.lq.domain.services.product.UpdateProductDiscountService;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UpdateProductDiscountAdapter implements UpdateProductDiscountService {

  private final ProductRepository productRepository;


  @Override
  public void updateProductDiscount(Double discount,Long id) {
    productRepository.updateProductDiscount(discount,id);
  }
}
