package com.liquorsgolden.lq.infrastructure.api.mapper.request.product;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.infrastructure.api.dto.request.product.ProductRequest;
import com.liquorsgolden.lq.infrastructure.api.mapper.request.ProportionRequestMapper;
import com.liquorsgolden.lq.infrastructure.api.mapper.request.StatusRequestMapper;
import com.liquorsgolden.lq.infrastructure.api.mapper.request.category.CategoryRequestMapper;
import com.liquorsgolden.lq.shared.mapper.EntityToDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING, uses = {
    CategoryRequestMapper.class,
    ProportionRequestMapper.class,
    StatusRequestMapper.class
}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductRequestMapper extends EntityToDto<Product, ProductRequest> {

  @Mapping(source = "categoryId", target = "category.id")
  @Mapping(source = "statusId", target = "status.id")
  @Mapping(source = "proportionId", target = "proportion.id")
  Product toEntity(ProductRequest productRequest);

}
