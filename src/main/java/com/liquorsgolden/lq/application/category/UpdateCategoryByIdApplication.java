package com.liquorsgolden.lq.application.category;

import com.liquorsgolden.lq.domain.services.category.UpdateCategoryByIdService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateCategoryByIdApplication {

  private final UpdateCategoryByIdService updateCategoryByIdService;

  public void updateCategoryById(Long id, String category) {
    updateCategoryByIdService.updateCategoryById(id, category);
  }

}
