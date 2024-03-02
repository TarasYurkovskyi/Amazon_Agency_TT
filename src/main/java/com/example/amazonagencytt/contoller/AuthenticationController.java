package com.example.amazonagencytt.contoller;

import com.example.amazonagencytt.dto.user.UserLoginRequestDto;
import com.example.amazonagencytt.dto.user.UserLoginResponseDto;
import com.example.amazonagencytt.dto.user.UserRegistrationRequestDto;
import com.example.amazonagencytt.dto.user.UserResponseDto;
import com.example.amazonagencytt.exception.RegistrationException;
import com.example.amazonagencytt.security.AuthenticationService;
import com.example.amazonagencytt.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping(value = "/registration")
    public UserResponseDto register(@Valid @RequestBody UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        return userService.register(requestDto);
    }

    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto requestDto) {
        return authenticationService.authenticate(requestDto);
    }
}
