package com.phoneBook.service;

import com.phoneBook.dto.RegisterUser;
import com.phoneBook.entity.Role;
import com.phoneBook.entity.User;
import com.phoneBook.entity.UserRoles;
import com.phoneBook.repository.RoleRepository;
import com.phoneBook.repository.UserRepository;
import com.phoneBook.repository.UserRolesRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegisterServiceImpl implements RegisterService,UserDetailsService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRolesRepository userRolesRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Long registerNewUser(RegisterUser registerUser) {

        User newUser= User.builder()
                .firstName(registerUser.getFirstName())
                .lastName(registerUser.getLastName())
                .mobileNumber(registerUser.getMobileNumber())
                .password(encoder.encode(registerUser.getPassword()))
                .addressLine1(registerUser.getAddressLine1())
                .addressLine2(registerUser.getAddressLine2())
                .build();
        User user=userRepository.save(newUser);
        Role role=roleRepository.findByRoleName(String.valueOf(registerUser.getRole()));
        UserRoles userRoles= UserRoles.builder()
                .user(user)
                .role(role)
                .build();
        userRoles =userRolesRepository.save(userRoles);

        return  user.getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user=userRepository.findByMobileNumber(Long.parseLong(username));
        if(user.isPresent()) {
            try {
                return org.springframework.security.core.userdetails.User.builder()
                        .username(user.get().getMobileNumber().toString())
                        .password(user.get().getPassword())
                        .authorities(user.get().getUser_roles().stream()
                                .map(userRole -> {
                                    Optional<Role> role = roleRepository.findById(userRole.getRole().getId());
                                    return role.map(r -> new SimpleGrantedAuthority(r.getRoleName())).orElse(null);
                                })
                                .filter(Objects::nonNull)
                                .collect(Collectors.toList())
                        )
                        .accountExpired(false)
                        .accountLocked(false)
                        .credentialsExpired(false)
                        .disabled(false)
                        .build();
            } catch (Exception ex) {
                throw new UsernameNotFoundException("User not found with mobile number :"+username);
            }
        }else{
            throw new UsernameNotFoundException("User not found with mobile number :"+username);
        }
    }
}
