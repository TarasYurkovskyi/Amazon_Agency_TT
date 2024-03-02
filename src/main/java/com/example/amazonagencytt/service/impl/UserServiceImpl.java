package com.example.amazonagencytt.service.impl;

import com.example.amazonagencytt.dto.user.UserRegistrationRequestDto;
import com.example.amazonagencytt.dto.user.UserResponseDto;
import com.example.amazonagencytt.exception.RegistrationException;
import com.example.amazonagencytt.mapper.UserMapper;
import com.example.amazonagencytt.model.user.Role;
import com.example.amazonagencytt.model.user.User;
import com.example.amazonagencytt.repository.RoleRepository;
import com.example.amazonagencytt.repository.UserRepository;
import com.example.amazonagencytt.service.UserService;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException(String.format(
                    "Can't register user with email %s", requestDto.getEmail())
            );
        }
        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        Role userRole = roleRepository.findByRoleName(Role.RoleName.USER);
        User user = userMapper.toUser(requestDto);
        user.setRoles(Set.of(userRole));
        return userMapper.toDto(userRepository.save(user));
    }
}
