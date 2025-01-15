package com.phoneBook.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoneBook.dto.UserDto;
import com.phoneBook.entity.User;
import com.phoneBook.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
     @Override
    public UserDto getUserById(Long id) {
        Optional<User> user=userRepository.findById(id);
        if(user.get()!=null){
             User existingUser=user.get();
            return UserDto.builder()
                    .id(existingUser.getId())
                    .firstName(existingUser.getFirstName())
                    .lastName(existingUser.getLastName())
                    .build();
         }else{
             throw new RuntimeException("User doestNot exist with id :"+id);
         }
    }

    @Override
    public UserDto getUserByMobile(Long mobileNumber) {
      Optional<User> existingUserOptional=userRepository.findByMobileNumber(mobileNumber);
      if(existingUserOptional.get()!=null){
        User existingUser=existingUserOptional.get();
        return UserDto.builder()
        .id(existingUser.getId())
        .firstName(existingUser.getFirstName())
        .lastName(existingUser.getLastName())
        .mobileNumber(existingUser.getMobileNumber().toString())
        .build();
      }
      return null;
    }
}
