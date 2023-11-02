package com.liquorsgolden.lq.infrastructure.adapter;

import com.liquorsgolden.lq.domain.entities.Customer;
import com.liquorsgolden.lq.domain.services.customer.FindCustomerByIdService;
import com.liquorsgolden.lq.infrastructure.repository.customer.CustomerDtoMapper;
import com.liquorsgolden.lq.infrastructure.repository.customer.CustomerRepository;
import com.liquorsgolden.lq.shared.exception.message.CustomerNotFoundException;
import com.liquorsgolden.lq.shared.utils.MessageUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetCustomerByIdAdapter implements FindCustomerByIdService {

  private final CustomerRepository customerRepository;
  private final CustomerDtoMapper customerDtoMapper;
  private final MessageUtils messageUtils;


  @Override
  public Customer findCustomerById(Long id) {
    return customerDtoMapper.toEntity(customerRepository.findById(id)
        .orElseThrow(() -> new CustomerNotFoundException("Customer with id " + id + " not found")));
  }
}
