package com.liquorsgolden.lq.infrastructure.repository.category;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDto, Long> {

  Optional<CategoryDto> findByName(String name);

  @Query(value = "UPDATE CategoryDto c SET name =:category WHERE c.id =:categoryId")
  void update(Long categoryId, String category);
}
