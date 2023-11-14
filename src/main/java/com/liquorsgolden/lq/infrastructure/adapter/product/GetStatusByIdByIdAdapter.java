package com.liquorsgolden.lq.infrastructure.adapter.product;

import com.liquorsgolden.lq.domain.entities.Status;
import com.liquorsgolden.lq.domain.services.product.GetStatusByIdService;
import com.liquorsgolden.lq.infrastructure.repository.status.StatusDtoMapper;
import com.liquorsgolden.lq.infrastructure.repository.status.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetStatusByIdByIdAdapter implements GetStatusByIdService {

  private final StatusRepository statusRepository;
  private final StatusDtoMapper statusDtoMapper;

  @Override
  public Status findById(Long id) {
    return statusDtoMapper.toEntity(statusRepository.findById(id).orElse(null));
  }
}
