package com.phoneBook.service;

import com.phoneBook.dto.RolesRequestDto;
import com.phoneBook.entity.Role;
import com.phoneBook.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements  RoleService{
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void addRoles(List<RolesRequestDto> rolesRequestDto) {
        for(RolesRequestDto list:rolesRequestDto ){
            Role role= Role.builder()
                    .roleName(list.getRoleName())
                    .build();
            roleRepository.save(role);
        }
    }
}
