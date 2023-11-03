package com.liquorsgolden.lq.application.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.liquorsgolden.lq.domain.entities.Category;
import com.liquorsgolden.lq.domain.services.category.GetAllCategoryService;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GetAllCategoryApplicationTest {

  @Mock
  private GetAllCategoryService getAllCategoryService;

  @InjectMocks
  private GetAllCategoryApplication getAllCategoryApplication;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testFindAllCategoriesWhenCategoriesPresentThenReturnCategories() {
    // Arrange
    Category category1 = new Category(1L, "Category1", "User1", LocalDateTime.now());
    Category category2 = new Category(2L, "Category2", "User2", LocalDateTime.now());
    List<Category> expectedCategories = Arrays.asList(category1, category2);
    when(getAllCategoryService.getAllCategorys()).thenReturn(expectedCategories);

    // Act
    List<Category> actualCategories = getAllCategoryApplication.findAllCategories();

    // Assert
    assertNotNull(actualCategories);
    assertEquals(expectedCategories, actualCategories);
  }

  @Test
  public void testFindAllCategoriesWhenNoCategoriesPresentThenReturnEmptyList() {
    // Arrange
    when(getAllCategoryService.getAllCategorys()).thenReturn(Collections.emptyList());

    // Act
    List<Category> actualCategories = getAllCategoryApplication.findAllCategories();

    // Assert
    assertNotNull(actualCategories);
    assertEquals(0, actualCategories.size());
  }
}