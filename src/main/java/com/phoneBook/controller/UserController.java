package com.phoneBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phoneBook.dto.UserDto;
import com.phoneBook.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
       @GetMapping("/getUserById/{id}")
    public UserDto getUserDetailsById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @GetMapping("/getUserByMobile/{mobileNumber}")
    public UserDto getUserDetailsByMobileNumber(@PathVariable Long mobileNumber){
        return userService.getUserByMobile(mobileNumber);
    }
}
