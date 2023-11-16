package com.liquorsgolden.lq.infrastructure.adapter.product;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.GetBestSellingProductsService;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductDtoMapper;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class GetProductsBySoldUnitAdapter implements GetBestSellingProductsService {

    private final ProductRepository productRepository;
    private final ProductDtoMapper productDtoMapper;

    @Override
    public List<Product> getBestSellingProducts(int minSoldUnits) {
        return productDtoMapper.toEntity(productRepository.findBestSellingProducts(minSoldUnits));
    }
}
