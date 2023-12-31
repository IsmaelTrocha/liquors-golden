package com.liquorsgolden.lq.infrastructure.api.controller;

import com.liquorsgolden.lq.application.image.ImageUploadApplication;
import com.liquorsgolden.lq.application.products.CreateProductApplication;
import com.liquorsgolden.lq.application.products.DeleteProductByIdApplication;
import com.liquorsgolden.lq.application.products.FindAllByNameProductApplication;
import com.liquorsgolden.lq.application.products.FindAllProductByPriceApplication;
import com.liquorsgolden.lq.application.products.GetAllProductApplication;
import com.liquorsgolden.lq.application.products.GetAllProductByCategoryIdApplication;
import com.liquorsgolden.lq.application.products.GetProductByIdApplication;
import com.liquorsgolden.lq.application.products.UpdateProductDiscountApplication;
import com.liquorsgolden.lq.application.products.UpdateStockProductApplication;
import com.liquorsgolden.lq.application.products.*;
import com.liquorsgolden.lq.domain.services.image.ImageUploadService;
import com.liquorsgolden.lq.infrastructure.api.dto.request.product.ProductRequest;
import com.liquorsgolden.lq.infrastructure.api.dto.request.product.UpdateProductRequest;
import com.liquorsgolden.lq.infrastructure.api.dto.response.CreateResponse;
import com.liquorsgolden.lq.infrastructure.api.dto.response.EntityResponse;
import com.liquorsgolden.lq.infrastructure.api.dto.response.ProductResponse;
import com.liquorsgolden.lq.infrastructure.api.mapper.request.product.ProductRequestMapper;
import com.liquorsgolden.lq.infrastructure.api.mapper.request.product.UpdateProductRequestMapper;
import com.liquorsgolden.lq.infrastructure.api.mapper.response.ProductResponseMapper;
import com.liquorsgolden.lq.infrastructure.repository.product.ProductRepository;
import com.liquorsgolden.lq.shared.exception.code.MessageCode;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/api/products")
@RequiredArgsConstructor
public class ProductController {

  private final CreateProductApplication createProductApplication;
  private final DeleteProductByIdApplication deleteProductByIdApplication;
  private final FindAllByNameProductApplication findAllByNameProductApplication;
  private final FindAllProductByPriceApplication findAllProductByPriceApplication;
  private final GetAllProductByCategoryIdApplication getAllProductByCategoryIdApplication;
  private final UpdateProductApplication updateProductApplication;
  private final UpdateStockProductApplication updateStockProductApplication;
  private final ProductRequestMapper productRequestMapper;
  private final UpdateProductDiscountApplication updateProductDiscountApplication;
  private final GetProductByIdApplication getProductByIdApplication;
  private final GetAllProductApplication getAllProductApplication;
  private final ProductResponseMapper productResponseMapper;
  private final UpdateProductRequestMapper updateProductRequestMapper;
  private final ImageUploadApplication imageUploadApplication;
  private final GetBestSellingProductsApplication getBestSellingProductsApplication;
  private final ImageUploadService imageUploadService;
  private final MessageUtils messageUtils;
  private final ProductRepository productRepository;

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

  @DeleteMapping(path = "/remove/{id}")
  public ResponseEntity<EntityResponse> deleteProductById(@PathVariable("id") Long id) {
    deleteProductByIdApplication.deleteProductById(id);
    return new ResponseEntity<>(new EntityResponse("200",
        messageUtils.getMessage(
            MessageCode.PRODUCT_DELETED_SUCCESSFULLY.getType()),
        LocalDateTime.now()), HttpStatus.OK);
  }

  @PutMapping(path = "/update")
  public ResponseEntity<EntityResponse> updateProduct(
      @RequestBody UpdateProductRequest updateProductRequest) {
    updateProductApplication.updateProduct(
        updateProductRequestMapper.toEntity(updateProductRequest));
    return new ResponseEntity<>(new EntityResponse(
        messageUtils.getMessage(
            MessageCode.PRODUCT_UPDATED_SUCCESSFULLY.getType()),
        messageUtils.getMessage(
            MessageCode.PRODUCT_UPDATED_SUCCESSFULLY.getType()),
        LocalDateTime.now()), HttpStatus.OK);
  }

  @PutMapping(path = "/discount/{quantity}/{id}")
  public ResponseEntity<ProductResponse> updateProductDiscount(
      @PathVariable("quantity") Double discount, @PathVariable("id") Long id) {
    updateProductDiscountApplication.updateProductDiscount(discount, id);
    return new ResponseEntity<>(
        productResponseMapper.toDto(getProductByIdApplication.getProductById(id)), HttpStatus.OK);
  }

  @GetMapping(path = "/between/{name}")
  public ResponseEntity<List<ProductResponse>> getAllProductByNameIn(
      @PathVariable("name") String name) {
    return new ResponseEntity<>(productResponseMapper.toDto(
        findAllByNameProductApplication.findAllByNameIn(name)), HttpStatus.OK);
  }

  @GetMapping(path = "/between/category/{id}")
  public ResponseEntity<List<ProductResponse>> getAllProductByCategoryIn(
      @PathVariable("id") Long id) {
    return new ResponseEntity<>(productResponseMapper.toDto(
        getAllProductByCategoryIdApplication.findAllProductByCategoryId(id)), HttpStatus.OK);
  }

  @GetMapping(path = "/liquors")
  public ResponseEntity<List<ProductResponse>> getAllLiquors() {
    return new ResponseEntity<>(
        productResponseMapper.toDto(getAllProductApplication.getAllLiquors()), HttpStatus.OK);
  }

  @GetMapping(path = "/between/{minPrice}-{maxPrice}")
  public ResponseEntity<List<ProductResponse>> getAllProductByPriceIn(
      @PathVariable("minPrice") Double minPrice, @PathVariable("maxPrice") Double maxPrice) {
    return new ResponseEntity<>(productResponseMapper.toDto(
        findAllProductByPriceApplication.findAllByPriceProduct(minPrice, maxPrice)), HttpStatus.OK);
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

  @GetMapping("/best-selling")
  public ResponseEntity<List<ProductResponse>> getBestSellingProducts(@RequestParam(name = "minSoldUnits", defaultValue = "20") int minSoldUnits) {
    return new ResponseEntity<>(
            productResponseMapper.toDto(getBestSellingProductsApplication.getBestSellingProducts(minSoldUnits)), HttpStatus.OK);
  }

  @GetMapping(value = "/get/{id}")
  public ResponseEntity<ProductResponse> findById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(
        productResponseMapper.toDto(getProductByIdApplication.getProductById(id)), HttpStatus.OK);

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
