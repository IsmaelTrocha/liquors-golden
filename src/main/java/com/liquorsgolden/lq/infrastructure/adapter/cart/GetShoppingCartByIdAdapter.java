package com.liquorsgolden.lq.infrastructure.adapter.cart;

import com.liquorsgolden.lq.domain.entities.Cart;
import com.liquorsgolden.lq.domain.services.cart.GetShoppingCartByIdService;
import com.liquorsgolden.lq.infrastructure.repository.cart.CartDtoMapper;
import com.liquorsgolden.lq.infrastructure.repository.cart.CartRepository;
import com.liquorsgolden.lq.shared.exception.message.cart.CartNotFoundException;
import com.liquorsgolden.lq.shared.utils.MessageUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetShoppingCartByIdAdapter implements GetShoppingCartByIdService {

  private final CartRepository cartRepository;
  private final CartDtoMapper cartDtoMapper;
  private final MessageUtils messageUtils;

  @Override
  public Cart getCartById(Long id) {
    return cartDtoMapper.toEntity(
        cartRepository.findById(id)
            .orElseThrow(() -> new CartNotFoundException("Product not found")));
  }
}
