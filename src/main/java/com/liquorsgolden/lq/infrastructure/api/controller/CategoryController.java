package com.liquorsgolden.lq.infrastructure.api.controller;

import com.liquorsgolden.lq.infrastructure.repository.category.CategoryDto;
import com.liquorsgolden.lq.infrastructure.repository.category.CategoryRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/category")
@CrossOrigin
public class CategoryController {

  private final CategoryRepository categoryRepository;

  @GetMapping(path = "/getAll")
  public List<CategoryDto> findAll() {
    return categoryRepository.findAll();
  }

}
