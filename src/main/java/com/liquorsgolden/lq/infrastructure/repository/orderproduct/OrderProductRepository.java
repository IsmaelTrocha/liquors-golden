package com.liquorsgolden.lq.infrastructure.repository.orderproduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProductDto, Long> {

}
