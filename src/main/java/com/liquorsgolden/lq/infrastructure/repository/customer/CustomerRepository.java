package com.liquorsgolden.lq.infrastructure.repository.customer;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDto, Long> {
  Optional<CustomerDto> findByEmailAndPassword(String email);
}
