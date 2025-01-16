package com.phoneBook.service;

import com.phoneBook.dto.ProfileResponseDto;

public interface ProfileService {
     ProfileResponseDto getProfile(Long mobileNumber);
}
