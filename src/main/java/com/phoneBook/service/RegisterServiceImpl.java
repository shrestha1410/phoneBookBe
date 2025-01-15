package com.phoneBook.service;

import com.phoneBook.dto.RegisterUser;
import com.phoneBook.entity.User;
import com.phoneBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RegisterServiceImpl implements RegisterService,UserDetailsService{
    @Autowired
    UserRepository userRepository;
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
        return  user.getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user=userRepository.findByMobileNumber(Long.parseLong(username));
        if(user.isPresent()){
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.get().getMobileNumber().toString())
                    .password(user.get().getPassword())
                    .build();
        }else{
            throw new UsernameNotFoundException("User not found with mobile number :"+username);
        }
    }
}
