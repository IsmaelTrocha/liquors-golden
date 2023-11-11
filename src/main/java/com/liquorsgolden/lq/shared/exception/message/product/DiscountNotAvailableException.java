package com.liquorsgolden.lq.shared.exception.message.product;

import com.liquorsgolden.lq.shared.exception.base.BaseException;
import com.liquorsgolden.lq.shared.exception.code.ExceptionCode;
import org.springframework.http.HttpStatus;

public class DiscountNotAvailableException extends BaseException {

  public DiscountNotAvailableException(String message){
    super(false, HttpStatus.BAD_REQUEST,message, ExceptionCode.PRODUCT_NOT_FOUND);
  }
}
