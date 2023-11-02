package com.liquorsgolden.lq.domain.services.customer;

import com.liquorsgolden.lq.domain.entities.Customer;

public interface FindCustomerByIdService {

  Customer findCustomerById(Long id);
}
