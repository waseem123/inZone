package com.infostack.inZone.repos;

import com.infostack.inZone.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUserMobileAndUserPasswordAndUserActive(String userMobile, String userPassword, boolean userActive);
}
