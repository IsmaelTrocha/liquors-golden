package com.liquorsgolden.lq.shared.exception.code;

import lombok.Getter;

@Getter
public enum MessageCode {

  SUCCESSFUL("Message-01", "Message.SUCCESSFUL"),
  CATEGORY_CREATE_SUCCESSFULLY("Message-02", "Message.CATEGORY_CREATE_SUCCESSFULLY"),
  PROPORTION_CREATE_SUCCESSFULLY("Message-03", "Message.PROPORTION_CREATE_SUCCESSFULLY"),
  CART_SAVE_SUCCESSFULLY("Message-04", "Message.CART_SAVED_SUCCESSFULLY"),
  PRODUCT_DELETED_SUCCESSFULLY("Message-05", "Message.PRODUCT_DELETED_SUCCESSFULLY"),
  PRODUCT_UPDATED_SUCCESSFULLY("Message-06", "Message.PRODUCT_UPDATED_SUCCESSFULLY"),
  PRODUCT_DISCOUNT_UPDATED_SUCCESSFULLY("Message-07",
      "Message.PRODUCT_DISCOUNT_UPDATED_SUCCESSFULLY");
  private final String code;
  private final String type;

  MessageCode(String code, String type) {
    this.code = code;
    this.type = type;
  }


}