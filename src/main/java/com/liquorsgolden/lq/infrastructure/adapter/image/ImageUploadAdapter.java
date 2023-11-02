package com.liquorsgolden.lq.infrastructure.adapter.image;

import com.liquorsgolden.lq.domain.services.feingclient.FileManagementService;
import com.liquorsgolden.lq.domain.services.image.ImageUploadService;
 import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class ImageUploadAdapter implements ImageUploadService {

  private final FileManagementService fileManagementService;

  @Override
  public void uploadProductImage(Long product, MultipartFile file) {
    fileManagementService.uploadProductProfilePicture(product, file);
  }

  @Override
  public void uploadCustomerImage(Long customerId, MultipartFile file) {
    fileManagementService.uploadCustomerProfileImage(customerId, file);
  }

  @Override
  public byte[] getProductImage(Long productId) {
    return fileManagementService.getProductImage(productId);
  }
}
