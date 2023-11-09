package com.liquorsgolden.lq.infrastructure.api.mapper.request.product;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.infrastructure.api.dto.request.product.UpdateProductRequest;
import com.liquorsgolden.lq.infrastructure.api.mapper.request.category.CategoryRequestMapper;
import com.liquorsgolden.lq.infrastructure.api.mapper.request.proportion.ProportionRequestMapper;
import com.liquorsgolden.lq.shared.mapper.EntityToDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING, uses = {
    CategoryRequestMapper.class,
    ProportionRequestMapper.class
}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UpdateProductRequestMapper extends EntityToDto<Product, UpdateProductRequest> {

  @Mapping(source = "categoryId", target = "category.id")
  @Mapping(source = "proportionId", target = "proportion.id")
  @Mapping(source = "statusId", target = "status.id")
  Product toEntity(UpdateProductRequest updateProductRequest);
}
