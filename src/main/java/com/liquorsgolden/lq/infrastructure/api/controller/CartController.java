package com.liquorsgolden.lq.infrastructure.api.controller;

import com.liquorsgolden.lq.application.cart.AddShoppingCartApplication;
import com.liquorsgolden.lq.application.cart.GetShoppingCartByIdApplication;
import com.liquorsgolden.lq.infrastructure.api.mapper.request.cart.CartRequestMapper;
import com.liquorsgolden.lq.infrastructure.api.mapper.response.CartResponseMapper;
import com.liquorsgolden.lq.shared.utils.MessageUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/cart/")
@AllArgsConstructor
public class CartController {

  private final AddShoppingCartApplication addShoppingCartApplication;
  private final GetShoppingCartByIdApplication cartByIdApplication;
  private final CartRequestMapper cartRequestMapper;
  private final CartResponseMapper cartResponseMapper;
  private final MessageUtils messageUtils;


}
