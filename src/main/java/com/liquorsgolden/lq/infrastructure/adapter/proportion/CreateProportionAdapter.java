package com.liquorsgolden.lq.infrastructure.adapter.proportion;

import com.liquorsgolden.lq.domain.entities.Proportion;
import com.liquorsgolden.lq.domain.services.proportion.CreateProportionService;
import com.liquorsgolden.lq.infrastructure.repository.proportion.ProportionDtoMapper;
import com.liquorsgolden.lq.infrastructure.repository.proportion.ProportionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateProportionAdapter implements CreateProportionService {

  private final ProportionRepository proportionRepository;
  private final ProportionDtoMapper proportionDtoMapper;

  @Override
  public Proportion createProportion(Proportion proportion) {
    return proportionDtoMapper.toEntity(
        proportionRepository.save(proportionDtoMapper.toDto(proportion)));
  }
}
