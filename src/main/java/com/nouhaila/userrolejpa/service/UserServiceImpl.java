package com.nouhaila.userrolejpa.service;

import com.nouhaila.userrolejpa.entities.Role;
import com.nouhaila.userrolejpa.entities.User;
import com.nouhaila.userrolejpa.repositories.RoleRepo;
import com.nouhaila.userrolejpa.repositories.UserRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @Transactional @AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        //hash password
        user.setPassword(user.getPassword().hashCode()+"");
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {

        return roleRepo.save(role);
    }

    @Override
    public User getUserByUserName(String username) {
        return userRepo.findByUserName(username);
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        return roleRepo.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepo.findByUserName(username);
        Role role = roleRepo.findByRoleName(roleName);
        if (user.getRoles()!=null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
        //userRepo.save(user); puisque l'entité User est déjà sous la gestion de JPA Transaction
    }

    @Override
    public User authenticate(String username, String password) {
        User user = userRepo.findByUserName(username);
        if (user==null) throw new RuntimeException("Invalid user or password");
        if (user.getPassword().equals(password)) return user;
        throw new RuntimeException("Invalid user or password");
    }
}
