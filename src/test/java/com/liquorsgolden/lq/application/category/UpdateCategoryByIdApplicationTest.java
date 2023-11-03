package com.liquorsgolden.lq.application.category;

import static org.mockito.Mockito.*;

import com.liquorsgolden.lq.domain.services.category.UpdateCategoryByIdService;
import com.liquorsgolden.lq.shared.exception.message.category.CategoryNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UpdateCategoryByIdApplicationTest {

  @Mock
  private UpdateCategoryByIdService updateCategoryByIdService;

  @InjectMocks
  private UpdateCategoryByIdApplication updateCategoryByIdApplication;

  @Test
  public void testUpdateCategoryByIdWhenCategoryIsUpdatedThenReturnTrue() {
    // Arrange
    Long id = 1L;
    String category = "Whiskey";

    // Act
    updateCategoryByIdApplication.updateCategoryById(id, category);

    // Assert
    verify(updateCategoryByIdService, times(1)).updateCategoryById(id, category);
  }

  @Test
  public void testUpdateCategoryByIdWhenCategoryIsNotFoundThenThrowCategoryNotFoundException() {
    // Arrange
    Long id = 1L;
    String category = "Whiskey";

    doThrow(CategoryNotFoundException.class).when(updateCategoryByIdService)
        .updateCategoryById(id, category);

    // Act & Assert
    org.junit.jupiter.api.Assertions.assertThrows(CategoryNotFoundException.class, () -> {
      updateCategoryByIdApplication.updateCategoryById(id, category);
    });

    verify(updateCategoryByIdService, times(1)).updateCategoryById(id, category);
  }
}