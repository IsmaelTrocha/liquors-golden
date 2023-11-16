package com.liquorsgolden.lq.infrastructure.adapter.product;

import com.liquorsgolden.lq.domain.services.product.UpdateProductStockService;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductDto;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductDtoMapper;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductRepository;
import com.liquorsgolden.lq.shared.exception.message.product.ProductNotFoundException;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateProductStockAdapter implements UpdateProductStockService {

  private final ProductRepository productRepository;
  private final ProductDtoMapper productDtoMapper;


  @Override
  @Transactional
  public void updateStock(Long productId, int quantity) {
    Optional<ProductDto> productOptional = productRepository.findById(productId);
    if (productOptional.isPresent()) {
      ProductDto product = productOptional.get();
      int updatedStock = product.getStock() - quantity;
      product.setStock(updatedStock);
      product.setUpdateDate(LocalDateTime.now());

      // Aumentar soldUnits
      int updatedSoldUnits = product.getSoldUnits() + quantity;
      product.setSoldUnits(updatedSoldUnits);

      productDtoMapper.toEntity(productRepository.save(product));
    } else {
      // Lanzar una excepción ProductNotFoundException si el producto no se encuentra
      throw new ProductNotFoundException("El producto con el id " + productId + " no existe");
    }
  }



  @Override
  public void updateStockProduct(int stock, String name) {
    productRepository.updateStockByName(stock, name);
  }

}
