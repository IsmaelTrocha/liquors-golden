package com.liquorsgolden.lq.application.cart;

import com.liquorsgolden.lq.domain.entities.Cart;
import com.liquorsgolden.lq.domain.services.cart.AddShoppingCartService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddShoppingCartApplication {

  private final AddShoppingCartService addShoppingCartService;

  public Cart addShoppingCart(Cart cart) {
    return addShoppingCartService.addCart(cart);
  }

}
