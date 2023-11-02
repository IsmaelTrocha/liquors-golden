package com.liquorsgolden.lq.shared.exception.message.cart;

import com.liquorsgolden.lq.shared.exception.base.BaseException;
import com.liquorsgolden.lq.shared.exception.code.ExceptionCode;
import org.springframework.http.HttpStatus;

public class CartNotFoundException extends BaseException {

  public CartNotFoundException(String message) {
    super(false, HttpStatus.NOT_FOUND,message, ExceptionCode.PRODUCT_NOT_FOUND);
  }
}
