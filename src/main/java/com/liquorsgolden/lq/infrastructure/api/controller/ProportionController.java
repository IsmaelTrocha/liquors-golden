package com.liquorsgolden.lq.infrastructure.api.controller;

import com.liquorsgolden.lq.application.proportion.CreateProportionApplication;
import com.liquorsgolden.lq.application.proportion.GetAllProportionApplication;
import com.liquorsgolden.lq.application.proportion.GetProportionByIdApplication;
import com.liquorsgolden.lq.infrastructure.api.dto.request.proportion.ProportionRequest;
import com.liquorsgolden.lq.infrastructure.api.dto.response.CreateResponse;
import com.liquorsgolden.lq.infrastructure.api.dto.response.ProportionResponse;
import com.liquorsgolden.lq.infrastructure.api.mapper.request.proportion.ProportionRequestMapper;
import com.liquorsgolden.lq.infrastructure.api.mapper.response.ProportionResponseMapper;
import com.liquorsgolden.lq.shared.exception.code.MessageCode;
import com.liquorsgolden.lq.shared.utils.MessageUtils;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/proportions")
public class ProportionController {

  private final CreateProportionApplication createProportionApplication;
  private final GetAllProportionApplication getAllProportionApplication;
  private final GetProportionByIdApplication getProportionByIdApplication;
  private final ProportionRequestMapper proportionRequestMapper;
  private final ProportionResponseMapper proportionResponseMapper;
  private final MessageUtils messageUtils;

  @PostMapping
  public ResponseEntity<CreateResponse> createProportion(
      @RequestBody ProportionRequest proportionRequest) {
    createProportionApplication.createProportion(
        proportionRequestMapper.toEntity(proportionRequest));
    return new ResponseEntity<>(new CreateResponse(
        messageUtils.getMessage(
            MessageCode.PROPORTION_CREATE_SUCCESSFULLY.getCode()),
        messageUtils.getMessage(
            MessageCode.PROPORTION_CREATE_SUCCESSFULLY.getType()),
        LocalDateTime.now()),
        HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<ProportionResponse>> getAllProportions() {
    return new ResponseEntity<>(
        proportionResponseMapper.toDto(getAllProportionApplication.getAllProportion()),
        HttpStatus.OK);
  }

  @GetMapping(path = "/get/{id}")
  public ResponseEntity<ProportionResponse> getProportionById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(
        proportionResponseMapper.toDto(getProportionByIdApplication.findById(id)),
        HttpStatus.OK);
  }

}
