package com.phoneBook.service;

import com.phoneBook.config.JwtUtil;
import com.phoneBook.dto.LoginRequest;
import com.phoneBook.dto.LoginResponse;
import com.phoneBook.entity.User;
import com.phoneBook.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements  LoginService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public LoginResponse loginCall(LoginRequest loginRequest) {

      Optional<User> existinguser=userRepository.findByMobileNumber(loginRequest.getMobileNumber());
      if(existinguser.get()!=null){
       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getMobileNumber(), loginRequest.getPassword()));
       UserDetails userDetails=userDetailsService.loadUserByUsername(Optional.ofNullable(loginRequest.getMobileNumber())
                                                                        .map(String::valueOf).orElseThrow());
      String token= jwtUtil.generateToken(userDetails);
      if(token!=null){
        return LoginResponse.builder().token(token).build();
      } 
    }
      return null;
    }
}
