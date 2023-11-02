package com.liquorsgolden.lq.application.customer;

import com.liquorsgolden.lq.domain.entities.Customer;
import com.liquorsgolden.lq.domain.services.customer.FindCustomerByEmailService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindCustomerByEmailApplication {

  private final FindCustomerByEmailService findCustomerByEmailService;

  public Customer exists(String email){
    return findCustomerByEmailService.findCustomerByEmail(email);
  }
}
