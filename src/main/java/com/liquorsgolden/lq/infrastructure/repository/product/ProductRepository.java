package com.liquorsgolden.lq.infrastructure.repository.product;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDto, Long> {

  @Query(value = "SELECT p FROM ProductDto p WHERE p.name LIKE :name")
  List<ProductDto> findAllByName(@Param("name") String name);

  @Query(value = "SELECT p FROM ProductDto p WHERE p.price >= :minPrice AND p.price <= :maxPrice")
  List<ProductDto> findAllByPrice(@Param("minPrice") double minPrice,
      @Param("maxPrice") double maxPrice);

  @Query(value = "SELECT p FROM ProductDto p WHERE p.category = :categoryId")
  List<ProductDto> findAllByCategoryId(@Param("categoryId") Long categoryId);

  @Query(value = "SELECT p FROM ProductDto p WHERE p.proportion = :proportionId")
  List<ProductDto> findAllByProportionId(@Param("proportionId") Long proportionId);

  @Query(value = "SELECT MAX(p.id) FROM ProductDto p")
  Long findTopByOrderByIdDesc();


  @Modifying
  @Transactional
  @Query("UPDATE ProductDto p SET p.stock = :newStock WHERE p.name = :productName")
  void updateStockByName(@Param("newStock") int newStock, @Param("productName") String productName);


  @Modifying
  @Transactional
  @Query("UPDATE ProductDto p SET " +
      "p.category.id = :categoryId, " +
      "p.price = :newPrice, " +
      "p.status.id = :statusId, " +
      "p.description = :newDescription " +
      "WHERE p.id = :id")
  ProductDto updateProduct(
      @Param("categoryId") Long categoryId,
      @Param("newPrice") Double newPrice,
      @Param("statusId") Long statusId,
      @Param("newDescription") String newDescription,
      @Param("id") Long id
  );

}
