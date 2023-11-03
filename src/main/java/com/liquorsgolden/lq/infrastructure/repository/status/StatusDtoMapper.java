package com.liquorsgolden.lq.infrastructure.repository.status;

import com.liquorsgolden.lq.domain.entities.Status;
import com.liquorsgolden.lq.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface StatusDtoMapper extends EntityToDto<Status, StatusDto> {

}
