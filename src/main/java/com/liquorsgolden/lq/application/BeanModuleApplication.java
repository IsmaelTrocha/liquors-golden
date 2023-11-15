package com.liquorsgolden.lq.application;

import com.liquorsgolden.lq.application.cart.AddShoppingCartApplication;
import com.liquorsgolden.lq.application.cart.GetShoppingCartByIdApplication;
import com.liquorsgolden.lq.application.category.GetCategoryByIdApplication;
import com.liquorsgolden.lq.application.customer.FindCustomerByIdApplication;
import com.liquorsgolden.lq.application.image.ImageUploadApplication;
import com.liquorsgolden.lq.application.order.CreateOrderApplication;
import com.liquorsgolden.lq.application.products.CreateProductApplication;
import com.liquorsgolden.lq.application.products.DeleteProductByIdApplication;
import com.liquorsgolden.lq.application.products.FindAllByNameProductApplication;
import com.liquorsgolden.lq.application.products.FindAllProductByPriceApplication;
import com.liquorsgolden.lq.application.products.GetAllProductApplication;
import com.liquorsgolden.lq.application.products.GetAllProductByCategoryIdApplication;
import com.liquorsgolden.lq.application.products.GetProductByIdApplication;
import com.liquorsgolden.lq.application.products.GetStatusByIdApplication;
import com.liquorsgolden.lq.application.products.UpdateProductApplication;
import com.liquorsgolden.lq.application.products.UpdateProductDiscountApplication;
import com.liquorsgolden.lq.application.products.UpdateStockProductApplication;
import com.liquorsgolden.lq.application.products.proccess.ProductValidations;
import com.liquorsgolden.lq.application.proportion.CreateProportionApplication;
import com.liquorsgolden.lq.application.proportion.GetAllProportionApplication;
import com.liquorsgolden.lq.application.proportion.GetProportionByIdApplication;
import com.liquorsgolden.lq.domain.services.cart.AddShoppingCartService;
import com.liquorsgolden.lq.domain.services.cart.GetShoppingCartByIdService;
import com.liquorsgolden.lq.domain.services.category.GetCategoryByIdService;
import com.liquorsgolden.lq.domain.services.customer.FindCustomerByIdService;
import com.liquorsgolden.lq.domain.services.image.ImageUploadService;
import com.liquorsgolden.lq.domain.services.order.CreateOrderService;
import com.liquorsgolden.lq.domain.services.product.CreateProductService;
import com.liquorsgolden.lq.domain.services.product.DeleteProductByIdService;
import com.liquorsgolden.lq.domain.services.product.FindAllByNameProductService;
import com.liquorsgolden.lq.domain.services.product.FindAllByPriceProductService;
import com.liquorsgolden.lq.domain.services.product.GetAllProductByCategoryIdService;
import com.liquorsgolden.lq.domain.services.product.GetAllProductService;
import com.liquorsgolden.lq.domain.services.product.GetProductByIdService;
import com.liquorsgolden.lq.domain.services.product.GetStatusByIdService;
import com.liquorsgolden.lq.domain.services.product.UpdateProductDiscountService;
import com.liquorsgolden.lq.domain.services.product.UpdateProductService;
import com.liquorsgolden.lq.domain.services.product.UpdateProductStockService;
import com.liquorsgolden.lq.domain.services.proportion.CreateProportionService;
import com.liquorsgolden.lq.domain.services.proportion.GetAllProportionService;
import com.liquorsgolden.lq.domain.services.proportion.GetProportionByIdService;
import com.liquorsgolden.lq.shared.utils.MessageUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanModuleApplication {

  @Bean
  public CreateOrderApplication createOrderApplication(
      CreateOrderService createOrderService,
      FindCustomerByIdApplication findCustomerByIdApplication) {
    return new CreateOrderApplication(createOrderService,
        findCustomerByIdApplication);
  }

  @Bean
  public CreateProductApplication createProductApplication(
      CreateProductService createProductService,
      GetProductByIdApplication getProductApplication,
      UpdateProductStockService updateProductStockService,
      GetCategoryByIdApplication getCategoryByIdApplication,
      GetProportionByIdApplication getProportionByIdApplication) {
    return new CreateProductApplication(createProductService,
        getProductApplication,
        updateProductStockService,
        getCategoryByIdApplication,
        getProportionByIdApplication
    );
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
      UpdateProductService updateProductService,
      GetStatusByIdApplication getStatusByIdApplication,
      GetProportionByIdApplication getProportionByIdApplication,
      GetCategoryByIdApplication getCategoryByIdApplication) {
    return new UpdateProductApplication(updateProductService, getStatusByIdApplication,
        getProportionByIdApplication, getCategoryByIdApplication);
  }

  @Bean
  public UpdateStockProductApplication updateStockProductApplication(
      UpdateProductStockService updateProductStockService) {
    return new UpdateStockProductApplication(updateProductStockService);
  }

  @Bean
  public ImageUploadApplication imageUploadApplication(
      ImageUploadService imageUploadService) {
    return new ImageUploadApplication(
        imageUploadService);
  }

  @Bean
  public GetCategoryByIdApplication getCategoryByIdApplication(
      GetCategoryByIdService getCategoryByIdService) {
    return new GetCategoryByIdApplication(getCategoryByIdService);
  }

  @Bean
  public GetProportionByIdApplication getProportionByIdApplication(
      GetProportionByIdService getProportionByIdService) {
    return new GetProportionByIdApplication(getProportionByIdService);
  }

  @Bean
  public CreateProportionApplication createProportionApplication(
      CreateProportionService createProportionService) {
    return new CreateProportionApplication(createProportionService);
  }

  @Bean
  public GetAllProportionApplication getAllProportionApplication(
      GetAllProportionService getAllProportionService) {
    return new GetAllProportionApplication(getAllProportionService);
  }

  @Bean
  public AddShoppingCartApplication addShoppingCartApplication(
      AddShoppingCartService addShoppingCartService,
      FindCustomerByIdApplication findCustomerByIdApplication) {
    return new AddShoppingCartApplication(addShoppingCartService,
        findCustomerByIdApplication);
  }

  @Bean
  public GetShoppingCartByIdApplication cartByIdApplication(
      GetShoppingCartByIdService getShoppingCartByIdService) {
    return new GetShoppingCartByIdApplication(getShoppingCartByIdService);
  }

  @Bean
  public FindCustomerByIdApplication findCustomerByEmailApplication(
      FindCustomerByIdService findCustomerByIdService) {
    return new FindCustomerByIdApplication(findCustomerByIdService);
  }

  @Bean
  public GetStatusByIdApplication getStatusByIdApplication(
      GetStatusByIdService getStatusByIdService) {
    return new GetStatusByIdApplication(getStatusByIdService);
  }

  @Bean
  public UpdateProductDiscountApplication productDiscountApplication(
      UpdateProductDiscountService updateProductDiscountService,
      GetProductByIdApplication getProductByIdApplication,
      ProductValidations productValidations) {
    return new UpdateProductDiscountApplication(updateProductDiscountService,
        getProductByIdApplication, productValidations);
  }

  @Bean
  public ProductValidations productValidations(MessageUtils messageUtils) {
    return new ProductValidations(messageUtils);
  }
}