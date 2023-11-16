package com.liquorsgolden.lq.application.products;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.domain.services.product.GetBestSellingProductsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
public class GetBestSellingProductsApplication {

    private final GetBestSellingProductsService getBestSellingProductsService;

    public List<Product> getBestSellingProducts(int minSoldUnits) {
        return getBestSellingProductsService.getBestSellingProducts(minSoldUnits);
    }
}
