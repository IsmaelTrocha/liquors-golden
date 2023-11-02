package com.liquorsgolden.lq.infrastructure.api.mapper.request.cart;

import com.liquorsgolden.lq.domain.entities.Cart;
import com.liquorsgolden.lq.infrastructure.api.dto.request.cart.CartRequest;
import com.liquorsgolden.lq.infrastructure.api.mapper.request.CustomerRequestMapper;
import com.liquorsgolden.lq.shared.mapper.EntityToDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING, uses = {
    CustomerRequestMapper.class
}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CartRequestMapper extends EntityToDto<Cart, CartRequest> {

  @Mapping(source = "customerId", target = "customer.id")
  Cart toEntity(CartRequest request);

}
