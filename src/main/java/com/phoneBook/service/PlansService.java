package com.phoneBook.service;

import java.util.List;

import com.phoneBook.dto.PlansRequestDto;
import com.phoneBook.dto.PlansResponseDto;

public interface PlansService {
 List<PlansResponseDto> getPlans();
 List<PlansResponseDto> addPlans(List<PlansRequestDto> plansRequestDto);
 void deletePlan(Long id);
}