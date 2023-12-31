package com.liquorsgolden.lq.infrastructure.repository.category;

import com.liquorsgolden.lq.domain.entities.Category;
import com.liquorsgolden.lq.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CategoryDtoMapper extends EntityToDto<Category, CategoryDto> {

}
