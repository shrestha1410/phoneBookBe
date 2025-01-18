package com.phoneBook.service;

import com.phoneBook.dto.RolesRequestDto;

import java.util.List;

public interface RoleService {
    public void addRoles(List<RolesRequestDto> rolesRequestDto);
}
