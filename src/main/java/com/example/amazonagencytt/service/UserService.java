package com.example.amazonagencytt.service;

import com.example.amazonagencytt.dto.user.UserRegistrationRequestDto;
import com.example.amazonagencytt.dto.user.UserResponseDto;
import com.example.amazonagencytt.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException;
}
