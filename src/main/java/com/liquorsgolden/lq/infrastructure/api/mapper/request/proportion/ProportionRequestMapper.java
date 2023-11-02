package com.liquorsgolden.lq.infrastructure.api.mapper.request.proportion;

import com.liquorsgolden.lq.domain.entities.Proportion;
import com.liquorsgolden.lq.infrastructure.api.dto.request.proportion.ProportionRequest;
import com.liquorsgolden.lq.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface ProportionRequestMapper extends EntityToDto<Proportion, ProportionRequest> {

}
