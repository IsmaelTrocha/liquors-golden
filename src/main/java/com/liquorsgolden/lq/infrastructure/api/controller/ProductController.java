package com.liquorsgolden.lq.infrastructure.api.controller;

import com.liquorsgolden.lq.application.products.CreateProductApplication;
import com.liquorsgolden.lq.infrastructure.api.dto.request.product.ProductRequest;
import com.liquorsgolden.lq.infrastructure.api.dto.response.CreateResponse;
import com.liquorsgolden.lq.infrastructure.api.mapper.request.product.ProductRequestMapper;
import com.liquorsgolden.lq.shared.utils.MessageUtils;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/products")
@RequiredArgsConstructor
public class ProductController {

  private final CreateProductApplication createProductApplication;
  private final ProductRequestMapper productRequestMapper;
  private final MessageUtils messageUtils;

  @PostMapping
  public ResponseEntity<CreateResponse> createProduct(@RequestBody ProductRequest productRequest) {
    createProductApplication.createProduct(productRequestMapper.toEntity(productRequest));
    return new ResponseEntity<>(new CreateResponse(
        "201", "Product created Successfully", LocalDateTime.now()
    ), HttpStatus.CREATED);
  }
}
