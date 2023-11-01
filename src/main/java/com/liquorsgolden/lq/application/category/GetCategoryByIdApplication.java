package com.liquorsgolden.lq.application.category;


import com.liquorsgolden.lq.domain.entities.Category;
import com.liquorsgolden.lq.domain.services.category.GetCategoryByIdService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetCategoryByIdApplication {

  private final GetCategoryByIdService getCategoryByIdService;

  public Category findById(Long categoryId) {
    return getCategoryByIdService.findById(categoryId);
  }
}
