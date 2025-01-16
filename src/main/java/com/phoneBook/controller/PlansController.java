package com.phoneBook.controller;

import java.util.List;

import com.phoneBook.dto.PlansRequestDto;
import com.phoneBook.dto.PlansResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.phoneBook.service.PlansService;

@RestController
@RequestMapping("/plans")
public class PlansController {
    
    @Autowired
    private PlansService plansService;

    @GetMapping("/")
    public List<PlansResponseDto> getListOfPlans(){
        return plansService.getPlans();
    }
    @PostMapping("/add")
    public List<PlansResponseDto> addListOfPlans(@RequestBody List<PlansRequestDto> plansRequestDto){
        return plansService.addPlans(plansRequestDto);
    }
    @DeleteMapping("/delete")
    public void deletePlans(@PathVariable  Long id){
        plansService.deletePlan(id);
    }
}
