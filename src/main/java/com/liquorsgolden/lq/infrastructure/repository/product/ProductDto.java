package com.liquorsgolden.lq.infrastructure.repository.product;

import com.liquorsgolden.lq.infrastructure.repository.category.CategoryDto;
import com.liquorsgolden.lq.infrastructure.repository.proportion.ProportionDto;
import com.liquorsgolden.lq.infrastructure.repository.status.StatusDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PRODUCTS")
public class ProductDto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  @Column(name = "image_url")
  private String imageUrl;
  private Double price;
  private int stock;
  @Column(name = "created_by")
  private String createBy;
  @ManyToOne
  @JoinColumn(name = "category_id")
  private CategoryDto category;
  @ManyToOne
  @JoinColumn(name = "status_id")
  private StatusDto status;
  @ManyToOne
  @JoinColumn(name = "proportion_id")
  private ProportionDto proportion;
  @Column(name = "creation_date")
  private LocalDateTime createDate;
  @Column(name = "update_date")
  private LocalDateTime updateDate;
  @Column(name = "hide_date")
  private LocalDateTime hideDate;

}
