package com.liquorsgolden.lq.application.category;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.liquorsgolden.lq.domain.entities.Category;
import com.liquorsgolden.lq.domain.services.category.CreateCategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateCategoryApplicationTest {

  @Mock
  private CreateCategoryService createCategoryService;

  @InjectMocks
  private CreateCategoryApplication createCategoryApplication;


  @Test
  public void testCreateCategoryWhenCategoryThenCategory() {
    Category category = new Category();
    when(createCategoryService.createCategory(category)).thenReturn(category);

    Category result = createCategoryApplication.createCategory(category);

    assertThat(result).isSameAs(category);
  }

}