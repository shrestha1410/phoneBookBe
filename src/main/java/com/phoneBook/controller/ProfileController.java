package com.phoneBook.controller;

import com.phoneBook.dto.ProfileResponseDto;
import com.phoneBook.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @GetMapping("/")
    public ProfileResponseDto getProfileDetails(@PathVariable Long mobileNumber){
      return  profileService.getProfile(mobileNumber);

    }
}
