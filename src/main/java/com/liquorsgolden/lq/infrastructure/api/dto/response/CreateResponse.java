package com.liquorsgolden.lq.infrastructure.api.dto.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CreateResponse {

  private String code;
  private String description;
  private LocalDateTime date;

}
