package com.phoneBook.controller;

import com.phoneBook.dto.RolesRequestDto;
import com.phoneBook.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping("/")
    public void addRoles(@RequestBody List<RolesRequestDto> rolesRequestDto){
        roleService.addRoles(rolesRequestDto);
    }
}
