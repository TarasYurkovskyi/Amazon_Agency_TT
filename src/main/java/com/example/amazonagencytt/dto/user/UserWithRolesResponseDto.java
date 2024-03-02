package com.example.amazonagencytt.dto.user;

import com.example.amazonagencytt.model.user.Role;
import java.util.Set;
import lombok.Data;

@Data
public class UserWithRolesResponseDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Set<Role.RoleName> roleNames;
}
