package com.nouhaila.userrolejpa.repositories;

import com.nouhaila.userrolejpa.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
