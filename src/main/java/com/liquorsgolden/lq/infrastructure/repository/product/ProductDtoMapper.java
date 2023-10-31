package com.liquorsgolden.lq.infrastructure.repository.product;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.infrastructure.repository.category.CategoryDtoMapper;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductDto;
import com.liquorsgolden.lq.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING, uses = {
    CategoryDtoMapper.class
})
public interface ProductDtoMapper extends EntityToDto<Product, ProductDto> {

}
