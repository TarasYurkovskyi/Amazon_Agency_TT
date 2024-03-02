package com.example.amazonagencytt.mapper;

import com.example.amazonagencytt.config.MapperConfig;
import com.example.amazonagencytt.dto.user.UserRegistrationRequestDto;
import com.example.amazonagencytt.dto.user.UserResponseDto;
import com.example.amazonagencytt.dto.user.UserWithRolesResponseDto;
import com.example.amazonagencytt.model.user.Role;
import com.example.amazonagencytt.model.user.User;
import java.util.stream.Collectors;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toDto(User user);

    @AfterMapping
    default void setRoleNames(
            @MappingTarget UserWithRolesResponseDto responseDto,
            User user
    ) {
        if (user.getRoles() != null) {
            responseDto.setRoleNames(user.getRoles().stream()
                    .map(Role::getRoleName)
                    .collect(Collectors.toSet()));
        }
    }

    User toUser(UserRegistrationRequestDto requestDto);
}

