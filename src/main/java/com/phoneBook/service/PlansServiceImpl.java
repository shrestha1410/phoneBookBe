package com.phoneBook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.phoneBook.dto.PlansRequestDto;
import com.phoneBook.dto.PlansResponseDto;
import com.phoneBook.entity.Plans;
import com.phoneBook.repository.PlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlansServiceImpl implements PlansService {
  @Autowired
  private PlansRepository plansRepository;
    @Override
    public List<PlansResponseDto> getPlans() {
     List<Plans> plansList=plansRepository.findAllPans();
     List<PlansResponseDto> response= new ArrayList<>();
     if(plansList!=null && !plansList.isEmpty()){
         for(Plans i:plansList){
             PlansResponseDto plansResponse= PlansResponseDto.builder()
                     .id(i.getId())
                     .planName(i.getPlanName())
                     .amount(i.getAmount())
                     .subscription(i.getSubscription())
                     .build();
             response.add(plansResponse);
         }
     }
        return response;
    }

    @Override
    public List<PlansResponseDto> addPlans(List<PlansRequestDto> plansRequestDto) {
        List<PlansResponseDto> plansResponseDto= new ArrayList<>();
        for(PlansRequestDto plans:plansRequestDto){
            Plans plansRepo=Plans.builder()
                    .planName(plans.getPlanName())
                    .amount(plans.getAmount())
                    .subscription(plans.getSubscription())
                    .build();
            Plans saved=plansRepository.save(plansRepo);
            PlansResponseDto responseDto= PlansResponseDto.builder()
                    .id(saved.getId())
                    .planName(saved.getPlanName())
                    .amount(saved.getAmount())
                    .subscription(saved.getSubscription())
                    .build();
            plansResponseDto.add(responseDto);
        }
        return plansResponseDto;
    }

    @Override
    public void deletePlan(Long id) {
        Optional<Plans> plansOptional= plansRepository.findById(id);
        plansRepository.delete(plansOptional.get());
    }

}
