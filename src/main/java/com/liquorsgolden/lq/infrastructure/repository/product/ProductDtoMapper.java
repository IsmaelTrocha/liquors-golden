package com.liquorsgolden.lq.infrastructure.repository.product;

import com.liquorsgolden.lq.domain.entities.Product;
import com.liquorsgolden.lq.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING, uses = {
    ProductDtoMapper.class
})
public interface ProductDtoMapper extends EntityToDto<Product, ProductDto> {

}
