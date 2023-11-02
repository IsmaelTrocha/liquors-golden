package com.liquorsgolden.lq.domain.services.feingclient;

import java.awt.image.BufferedImage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "liquors-file-manager", url = "http://localhost:8082/api")
public interface FileManagementService {

  @PostMapping(
      value = "/products/{productId}/profile-image",
      consumes = MediaType.MULTIPART_FORM_DATA_VALUE
  )
  void uploadProductProfilePicture(
      @PathVariable("productId") Long productId,
      @RequestPart("file") MultipartFile file);

  @PostMapping(
      value = "/v1/customer/{customerId}/profile-image",
      consumes = MediaType.MULTIPART_FORM_DATA_VALUE
  )

  void uploadCustomerProfileImage(
      @PathVariable("customerId") Long customerId,
      @RequestParam("file") MultipartFile file);

  @GetMapping(
      value = "/products/product-image/{productId}",
      produces = MediaType.IMAGE_JPEG_VALUE
  )
  byte[] getProductImage(@PathVariable("productId") Long productId);

}
