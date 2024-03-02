package com.example.amazonagencytt.repository;

import com.example.amazonagencytt.model.user.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRoleName(Role.RoleName roleName);
}
