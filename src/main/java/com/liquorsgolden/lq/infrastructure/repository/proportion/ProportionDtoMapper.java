package com.liquorsgolden.lq.infrastructure.repository.proportion;

import com.liquorsgolden.lq.domain.entities.Proportion;
import com.liquorsgolden.lq.shared.mapper.EntityToDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {
    ProportionDtoMapper.class
}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProportionDtoMapper extends EntityToDto<Proportion, ProportionDto> {

}
