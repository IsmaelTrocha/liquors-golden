package com.liquorsgolden.lq.application.customer;

import com.liquorsgolden.lq.domain.entities.Customer;
import com.liquorsgolden.lq.domain.services.customer.FindCustomerByIdService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindCustomerByIdApplication {

  private final FindCustomerByIdService findCustomerByIdService;

  public Customer exists(Long id) {
    return findCustomerByIdService.findCustomerById(id);
  }
}
