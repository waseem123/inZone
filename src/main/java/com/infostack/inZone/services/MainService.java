package com.infostack.inZone.services;

import com.infostack.inZone.models.User;
import com.infostack.inZone.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MainService {
    @Autowired
    UserRepository ur;

    public List<User> getAllUsers() {
        return (List<User>) ur.findAll();
    }

    public User getUserById(int userId) {
        return ur.findById(userId).get();
    }
    public User addUser(User user) {
        return ur.save(user);
    }

    public User getUserByCredentials(String userMobile, String userPassword) {
        return ur.findByUserMobileAndUserPasswordAndUserActive(userMobile,userPassword,true).get();
    }
}
