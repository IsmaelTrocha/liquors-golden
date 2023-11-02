package com.liquorsgolden.lq.infrastructure.api.mapper.request.status;

import com.liquorsgolden.lq.domain.entities.Status;
import com.liquorsgolden.lq.infrastructure.api.dto.request.status.StatusRequest;
import com.liquorsgolden.lq.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface StatusRequestMapper extends EntityToDto<Status, StatusRequest> {

}
