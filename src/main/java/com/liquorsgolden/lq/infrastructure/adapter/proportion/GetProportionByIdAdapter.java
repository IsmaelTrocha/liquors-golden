package com.liquorsgolden.lq.infrastructure.adapter.proportion;

import com.liquorsgolden.lq.domain.entities.Proportion;
import com.liquorsgolden.lq.domain.services.proportion.GetProportionByIdService;
import com.liquorsgolden.lq.infrastructure.repository.proportion.ProportionDtoMapper;
import com.liquorsgolden.lq.infrastructure.repository.proportion.ProportionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class GetProportionByIdAdapter implements GetProportionByIdService {

  private final ProportionRepository proportionRepository;
  private final ProportionDtoMapper proportionDtoMapper;

  @Override
  public Proportion findById(Long proportion) {
    return proportionDtoMapper.toEntity(proportionRepository.findById(proportion).orElse(null));
  }
}
