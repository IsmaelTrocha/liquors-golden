package com.liquorsgolden.lq.application;

import com.liquorsgolden.lq.application.products.CreateProductApplication;
import com.liquorsgolden.lq.application.products.DeleteProductByIdApplication;
import com.liquorsgolden.lq.application.products.FindAllByNameProductApplication;
import com.liquorsgolden.lq.application.products.FindAllProductByPriceApplication;
import com.liquorsgolden.lq.application.products.GetAllProductApplication;
import com.liquorsgolden.lq.application.products.GetAllProductByCategoryIdApplication;
import com.liquorsgolden.lq.application.products.GetProductByIdApplication;
import com.liquorsgolden.lq.application.products.UpdateProductApplication;
import com.liquorsgolden.lq.application.products.UpdateStockProductApplication;
import com.liquorsgolden.lq.domain.services.product.CreateProductService;
import com.liquorsgolden.lq.domain.services.product.DeleteProductByIdService;
import com.liquorsgolden.lq.domain.services.product.FindAllByNameProductService;
import com.liquorsgolden.lq.domain.services.product.FindAllByPriceProductService;
import com.liquorsgolden.lq.domain.services.product.GetAllProductByCategoryIdService;
import com.liquorsgolden.lq.domain.services.product.GetAllProductService;
import com.liquorsgolden.lq.domain.services.product.GetProductByIdService;
import com.liquorsgolden.lq.domain.services.product.UpdateProductService;
import com.liquorsgolden.lq.domain.services.product.UpdateStockProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanModuleApplication {

  @Bean
  public CreateProductApplication createProductApplication(
      CreateProductService createProductService,
      GetProductByIdApplication getProductApplication,
      UpdateStockProductService updateStockProductService) {
    return new CreateProductApplication(createProductService,
        getProductApplication,
        updateStockProductService);
  }

  @Bean
  public DeleteProductByIdApplication deleteProductByIdApplication(
      DeleteProductByIdService deleteProductByIdService,
      GetProductByIdApplication getProductByIdService) {
    return new DeleteProductByIdApplication(deleteProductByIdService,
        getProductByIdService);
  }

  @Bean
  public FindAllByNameProductApplication findAllByNameProductApplication(
      FindAllByNameProductService findAllByNameProductService) {
    return new FindAllByNameProductApplication(findAllByNameProductService);
  }

  @Bean
  public FindAllProductByPriceApplication findAllProductByPriceApplication(
      FindAllByPriceProductService findAllByPriceProductService) {
    return new FindAllProductByPriceApplication(findAllByPriceProductService);
  }

  @Bean
  public GetAllProductApplication getAllProductApplication(
      GetAllProductService getAllProductApplication) {
    return new GetAllProductApplication(getAllProductApplication);
  }

  @Bean
  public GetAllProductByCategoryIdApplication getAllProductByCategoryIdApplication(
      GetAllProductByCategoryIdService getAllProductByCategoryIdService) {
    return new GetAllProductByCategoryIdApplication(getAllProductByCategoryIdService);
  }

  @Bean
  public GetProductByIdApplication getProductApplication(
      GetProductByIdService getProductByIdService) {
    return new GetProductByIdApplication(getProductByIdService);
  }

  @Bean
  public UpdateProductApplication updateProductApplication(
      UpdateProductService updateProductService) {
    return new UpdateProductApplication(updateProductService);
  }

  @Bean
  public UpdateStockProductApplication updateStockProductApplication(
      UpdateStockProductService updateStockProductService) {
    return new UpdateStockProductApplication(updateStockProductService);
  }
}
