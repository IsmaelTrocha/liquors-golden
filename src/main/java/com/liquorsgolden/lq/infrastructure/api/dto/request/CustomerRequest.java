package com.liquorsgolden.lq.infrastructure.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CustomerRequest {

  private Long id;
  private String name;
  private String lastName;
  private String email;
  private int age;

}
