package com.liquorsgolden.lq.domain.services.feingclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "liquors-file-manager", url = "http://localhost:8082")
public interface FileManagementService {

  @PostMapping(
      value = "/{productId}/profile-image",
      consumes = MediaType.MULTIPART_FORM_DATA_VALUE
  )
  void uploadProductImage(
      @PathVariable("productId") Long productId,
      @RequestParam("file") MultipartFile file);

  @PostMapping(
      value = "/{customerId}/profile-image",
      consumes = MediaType.MULTIPART_FORM_DATA_VALUE
  )

  void uploadCustomerProfileImage(
      @PathVariable("customerId") Long customerId,
      @RequestParam("file") MultipartFile file);


}
