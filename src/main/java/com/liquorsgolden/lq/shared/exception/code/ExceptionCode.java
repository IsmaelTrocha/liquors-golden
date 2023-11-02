package com.liquorsgolden.lq.shared.exception.code;

import lombok.Getter;

@Getter
public enum ExceptionCode {

  PRODUCT_NOT_FOUND("ERR-01", "Exception.PRODUCT_NOT_FOUND"),
  CATEGORY_ALREADY_EXISTS("ERR-02", "Exception.CATEGORY_ALREADY_EXISTS"),
  CATEGORY_NOT_FOUND("ERR-03", "Exception.CATEGORY_NOT_FOUND"),
  IMAGE_REQUIRED("ERR-04", "Exception.IMAGE_REQUIRED"),
  STATUS_NOT_FOUND("ERR-05", "Exception.STATUS_NOT_FOUND"),
  PROPORTION_NOT_FOUND("ERR-06", "Exception.PROPORTION_NOT_FOUND"),
  PRODUCT_ALREADY_EXISTS("ERR-07", "Exception.PRODUCT_ALREADY_EXISTS"),
  CART_NOT_FOUND("ERR-08", "Exception.CART_NOT_FOUND"),
  CUSTOMER_NOT_FOUND("ERR-09", "Exception.CUSTOMER_NOT_FOUND");

  private final String code;
  private final String type;

  ExceptionCode(String code, String type) {
    this.code = code;
    this.type = type;
  }
}