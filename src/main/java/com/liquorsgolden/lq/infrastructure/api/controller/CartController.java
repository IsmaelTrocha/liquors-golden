package com.liquorsgolden.lq.infrastructure.api.controller;

import com.liquorsgolden.lq.application.cart.AddShoppingCartApplication;
import com.liquorsgolden.lq.application.cart.GetShoppingCartByIdApplication;
import com.liquorsgolden.lq.infrastructure.api.dto.request.cart.CartRequest;
import com.liquorsgolden.lq.infrastructure.api.dto.response.CartResponse;
import com.liquorsgolden.lq.infrastructure.api.dto.response.CreateResponse;
import com.liquorsgolden.lq.infrastructure.api.mapper.request.cart.CartRequestMapper;
import com.liquorsgolden.lq.infrastructure.api.mapper.response.CartResponseMapper;
import com.liquorsgolden.lq.shared.utils.MessageUtils;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @PostMapping
  public ResponseEntity<CreateResponse> createCart(@RequestBody CartRequest cartRequest) {
    addShoppingCartApplication.addShoppingCart(cartRequestMapper.toEntity(cartRequest));
    return new ResponseEntity<>(
        new CreateResponse(
            "201",
            "Cart created successfully",
            LocalDateTime.now()),
        HttpStatus.OK);

  }

  @GetMapping(path = "/get/{id}")
  public ResponseEntity<CartResponse> getCartById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(cartResponseMapper.toDto(cartByIdApplication.getCartById(id)),
        HttpStatus.OK);
  }

}
