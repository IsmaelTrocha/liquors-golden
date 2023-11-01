package com.liquorsgolden.lq.application.image;

import com.liquorsgolden.lq.domain.services.image.ImageUploadService;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
public class ImageUploadApplication {

  private final ImageUploadService imageUploadService;

  public void uploadProductImage(Long id, MultipartFile file) {
    imageUploadService.uploadProductImage(id, file);
  }

  public void uploadCustomerImage(Long id, MultipartFile file) {
    imageUploadService.uploadCustomerImage(id, file);
  }

}
