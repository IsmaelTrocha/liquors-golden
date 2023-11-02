package com.liquorsgolden.lq.shared.exception.code;

import lombok.Getter;

@Getter
public enum MessageCode {

  SUCCESSFUL("Message-01", "Message.SUCCESSFUL"),
  CATEGORY_CREATE_SUCCESSFULLY("Message-02", "Message.CATEGORY_CREATE_SUCCESSFULLY"),
  PROPORTION_CREATE_SUCCESSFULLY("Message-03", "Message.PROPORTION_CREATE_SUCCESSFULLY");
  private final String code;
  private final String type;

  MessageCode(String code, String type) {
    this.code = code;
    this.type = type;
  }


}