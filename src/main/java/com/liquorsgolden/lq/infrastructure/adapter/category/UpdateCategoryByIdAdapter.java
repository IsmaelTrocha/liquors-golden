package com.liquorsgolden.lq.infrastructure.adapter.category;

import com.liquorsgolden.lq.domain.services.category.UpdateCategoryByIdService;
import com.liquorsgolden.lq.infrastructure.repository.category.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UpdateCategoryByIdAdapter implements UpdateCategoryByIdService {

  private final CategoryRepository categoryRepository;

  @Override
  public void updateCategoryById(Long id, String category) {
    categoryRepository.updateCategoryById(id, category);
  }
}
