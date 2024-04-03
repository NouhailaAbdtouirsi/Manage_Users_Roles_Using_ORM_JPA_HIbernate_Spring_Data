package com.nouhaila.userrolejpa.repositories;

import com.nouhaila.userrolejpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
    User findByUserName(String username);
}
