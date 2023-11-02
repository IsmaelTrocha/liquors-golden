package com.liquorsgolden.lq.infrastructure.adapter.proportion;

import com.liquorsgolden.lq.domain.entities.Proportion;
import com.liquorsgolden.lq.domain.services.proportion.GetAllProportionService;
import com.liquorsgolden.lq.infrastructure.repository.proportion.ProportionDtoMapper;
import com.liquorsgolden.lq.infrastructure.repository.proportion.ProportionRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetAllProportionAdapter implements GetAllProportionService {

  private final ProportionRepository proportionRepository;
  private final ProportionDtoMapper proportionDtoMapper;

  @Override
  public List<Proportion> getAllProportion() {
    return proportionDtoMapper.toEntity(proportionRepository.findAll());
  }
}
