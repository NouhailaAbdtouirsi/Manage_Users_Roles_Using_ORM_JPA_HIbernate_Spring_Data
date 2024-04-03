package com.nouhaila.userrolejpa;

import com.nouhaila.userrolejpa.entities.Role;
import com.nouhaila.userrolejpa.entities.User;
import com.nouhaila.userrolejpa.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class UserRoleJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserRoleJpaApplication.class, args);
    }
    @Bean
    CommandLineRunner start(UserService userService) {
        return args -> {
            userService.saveUser(new User(null, "admin", "admin", null));
            User user = new User();
            user.setUserName("nouahila");
            user.setPassword("nouhaila");
            userService.saveUser(user);
            Role role = new Role();
            role.setRoleName("ADMIN");
            userService.saveRole(role);
            userService.addRoleToUser("admin", "ADMIN");
            Stream.of("MANAGER", "USER").forEach(rn->{
                Role r = new Role();
                r.setRoleName(rn);
                userService.saveRole(r);
            });
            userService.addRoleToUser("nouahila", "USER");
            userService.addRoleToUser("nouahila", "MANAGER");

            try {
                User user1 = userService.authenticate("nouahila", String.valueOf("nouhaila".hashCode()));
                System.out.println(user1.getUserId()) ;
                System.out.println(user1.getUserName());
                user1.getRoles().forEach(r->{
                    System.out.println(r.getRoleName());
                });

            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };
    }
}
