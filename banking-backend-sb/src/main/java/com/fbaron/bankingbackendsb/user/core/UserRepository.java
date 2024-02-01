package com.fbaron.bankingbackendsb.user.core;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    // save  or insert
    //create is business logic but for DAO its saving to repo so appropriate naming
    User saveUser(User user);
    // Read

    //Manage the null pointer exception
    Optional<User> findUserByUsername(String username);

    List<User> findAll();


}
