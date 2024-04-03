package com.nouhaila.userrolejpa.web;

import com.nouhaila.userrolejpa.entities.User;
import com.nouhaila.userrolejpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    @Autowired
    private UserService userService;
    @GetMapping("/user/{username}")
    public User user(@PathVariable String username){
        return userService.getUserByUserName(username);
    }
}
