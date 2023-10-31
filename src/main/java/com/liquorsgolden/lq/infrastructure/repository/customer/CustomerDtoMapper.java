package com.liquorsgolden.lq.infrastructure.repository.customer;

import com.liquorsgolden.lq.domain.entities.Customer;
import com.liquorsgolden.lq.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CustomerDtoMapper extends EntityToDto<Customer, CustomerDto> {

}
