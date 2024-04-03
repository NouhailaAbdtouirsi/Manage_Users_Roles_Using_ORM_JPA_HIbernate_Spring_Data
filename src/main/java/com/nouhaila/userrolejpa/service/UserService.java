package com.nouhaila.userrolejpa.service;

import com.nouhaila.userrolejpa.entities.Role;
import com.nouhaila.userrolejpa.entities.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    User getUserByUserName(String username);
    Role getRoleByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);

    User authenticate(String username, String password);
}
