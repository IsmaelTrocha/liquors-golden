package com.liquorsgolden.lq.infrastructure.repository.product;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDto, Long> {

   List<ProductDto> findAllByNameContaining(String name);

  List<ProductDto> findByCategoryNameNotIn(List<String> categoriesToExclude);
  @Query(value = "SELECT p FROM ProductDto p WHERE p.price >= :minPrice AND p.price <= :maxPrice")
  List<ProductDto> findAllByPrice(@Param("minPrice") double minPrice,
      @Param("maxPrice") double maxPrice);

  @Query(value = "SELECT p FROM ProductDto p WHERE p.category.id = :categoryId")
  List<ProductDto> findAllByCategoryId(@Param("categoryId") Long categoryId);

  @Query(value = "SELECT p FROM ProductDto p WHERE p.proportion = :proportionId")
  List<ProductDto> findAllByProportionId(@Param("proportionId") Long proportionId);

  @Query(value =
      "SELECT MAX(p.id) "
      + "FROM ProductDto p")
  Long findTopByOrderByIdDesc();

  @Modifying
  @Query(value = "UPDATE ProductDto p SET p.offerPrice = :discount, p.updateDate = :updateDate, p.discountActive= :isActive WHERE p.id = :productId")
  @Transactional
  void updateProductDiscount(
      @Param("discount") Double discount,
      @Param("updateDate") LocalDateTime updateDate,
      @Param("isActive") boolean isActive,
      @Param("productId") Long productId);

  @Modifying
  @Transactional
  @Query("UPDATE ProductDto"
      + " p SET p.stock = :newStock "
      + "WHERE p.name = :productName")
  void updateStockByName(@Param("newStock") int newStock, @Param("productName") String productName);


  @Modifying
  @Transactional
  @Query("UPDATE ProductDto p SET " +
      "p.category.id = :categoryId, " +
      "p.price = :newPrice, " +
      "p.status.id = :statusId, " +
      "p.description = :newDescription," +
      "p.name = :name " +
      "WHERE p.id = :id")
  void updateProduct(
      @Param("categoryId") Long categoryId,
      @Param("newPrice") Double newPrice,
      @Param("statusId") Long statusId,
      @Param("newDescription") String newDescription,
      @Param("name") String name,
      @Param("id") Long id
  );

}
