package com.liquorsgolden.lq.domain.services.image;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {

  void uploadProductImage(Long product, MultipartFile file);

  void uploadCustomerImage(Long customerId, MultipartFile file);

  byte[] getProductImage(Long productId);
}
