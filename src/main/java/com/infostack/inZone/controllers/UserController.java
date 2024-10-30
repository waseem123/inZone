package com.infostack.inZone.controllers;

import com.infostack.inZone.models.User;
import com.infostack.inZone.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    MainService ms;

    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return ms.getAllUsers();
    }

    @RequestMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") int userId) {
        return ms.getUserById(userId);
    }

    @RequestMapping("/users/login")
    public User getAllUsers(@RequestParam("userMobile") String userMobile, @RequestParam("userPassword") String userPassword) {
        return ms.getUserByCredentials(userMobile, userPassword);
    }

    @RequestMapping("/users/register")
    public User registerUser(
            @RequestParam("userFullName") String userFullName,
            @RequestParam("userEmail") String userEmail,
            @RequestParam("userPhotoUrl") String userPhotoUrl,
            @RequestParam("userMobile") String userMobile,
            @RequestParam("userDesignation") String userDesignation,
            @RequestParam("userPassword") String userPassword
    ) {
        User user = new User();
        user.setUserFullName(userFullName);
        user.setUserEmail(userEmail);
        user.setUserMobile(userMobile);
        user.setUserPassword(userPassword);
        user.setUserPhotoUrl(userPhotoUrl);
        user.setUserDesignation(userDesignation);
        user.setUserActive(true);
        return ms.addUser(user);
    }
}
