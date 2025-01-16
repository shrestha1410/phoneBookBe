package com.phoneBook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phoneBook.dto.PlansResponse;
import com.phoneBook.service.PlansService;
import com.phoneBook.service.plansService;

@RestController
public class PlansController {
    
    @Autowired
    private PlansService plansService;

    @GetMapping("/")
    public List<PlansResponse> getListOfPlans(){
        return plansService.getPlans();
    }
}
