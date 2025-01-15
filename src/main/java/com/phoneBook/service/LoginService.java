package com.phoneBook.service;

import com.phoneBook.dto.LoginRequest;
import com.phoneBook.dto.LoginResponse;

public interface LoginService {
    public LoginResponse loginCall(LoginRequest loginRequest);
}
