package com.phoneBook.service;

import com.phoneBook.dto.UserDto;

public interface UserService {
    UserDto getUserById(Long id);
    UserDto getUserByMobile(Long mobileNumber);
}
