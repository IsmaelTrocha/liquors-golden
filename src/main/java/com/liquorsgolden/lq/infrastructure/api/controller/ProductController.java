package com.liquorsgolden.lq.infrastructure.api.controller;

import com.liquorsgolden.lq.application.image.ImageUploadApplication;
import com.liquorsgolden.lq.application.products.CreateProductApplication;
import com.liquorsgolden.lq.application.products.GetAllProductApplication;
import com.liquorsgolden.lq.application.products.GetProductByIdApplication;
import com.liquorsgolden.lq.domain.services.image.ImageUploadService;
import com.liquorsgolden.lq.infrastructure.api.dto.request.product.ProductRequest;
import com.liquorsgolden.lq.infrastructure.api.dto.response.CreateResponse;
import com.liquorsgolden.lq.infrastructure.api.dto.response.ProductResponse;
import com.liquorsgolden.lq.infrastructure.api.mapper.request.product.ProductRequestMapper;
import com.liquorsgolden.lq.infrastructure.api.mapper.response.ProductResponseMapper;
import com.liquorsgolden.lq.shared.utils.MessageUtils;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import javax.imageio.ImageIO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/api/products")
@RequiredArgsConstructor
@CrossOrigin(allowCredentials = "*")
public class ProductController {

  private final CreateProductApplication createProductApplication;
  private final ProductRequestMapper productRequestMapper;
  private final MessageUtils messageUtils;
  private final GetProductByIdApplication getProductByIdApplication;
  private final ImageUploadApplication imageUploadApplication;
  private final ImageUploadService imageUploadService;
  private final GetAllProductApplication getAllProductApplication;
  private final ProductResponseMapper productResponseMapper;

  public static BufferedImage byteArrayToImage(byte[] imageBytes) {
    try {
      ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
      BufferedImage image = ImageIO.read(bis);
      bis.close();
      return image;
    } catch (IOException e) {
      e.printStackTrace();
      return null; // En caso de error, se puede devolver nulo o manejar la excepción según sea necesario.
    }
  }

  @PostMapping
  public ResponseEntity<CreateResponse> createProduct(
      @RequestBody ProductRequest productRequest) {
    createProductApplication.createProduct(productRequestMapper.toEntity(productRequest));
    return new ResponseEntity<>(new CreateResponse(
        "201", "Product created Successfully", LocalDateTime.now()
    ), HttpStatus.CREATED);
  }

  @PostMapping(value = "/product-image/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public String updateProductImage(
      @RequestPart("file") MultipartFile file,
      @PathVariable("id") Long id) {
    imageUploadService.uploadProductImage(id, file);
    return "Image Uploaded Successfully.";
  }

  @GetMapping(value = "/getAll")
  public ResponseEntity<List<ProductResponse>> getAllProduct() {
    return new ResponseEntity<>(
        productResponseMapper.toDto(
            getAllProductApplication.getAllProducts()), HttpStatus.OK);
  }

  @GetMapping(
      value = "/product-image/{id}",
      produces = MediaType.IMAGE_JPEG_VALUE
  )
  public ResponseEntity<BufferedImage> getProductImage(@PathVariable("id") Long id) {
    // Supongamos que tienes un repositorio de productos

    byte[] image = imageUploadService.getProductImage(id);
    return new ResponseEntity<>(byteArrayToImage(image), HttpStatus.OK);
  }
}
