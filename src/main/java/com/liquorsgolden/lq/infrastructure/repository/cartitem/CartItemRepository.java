package com.liquorsgolden.lq.infrastructure.repository.cartitem;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItemDto, Long> {
  @Modifying
  @Transactional
  @Query(value = "UPDATE CartItemDto sc SET sc.quantity= :quantity WHERE sc.id =:id")
  void updateShoppingCartQuantity(
      @Param("quantity") int quantity,
      @Param("id") Long id);
}
