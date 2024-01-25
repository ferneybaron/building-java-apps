package com.fbaron.bankingbackendsb.user;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserDAO {
    Map<String, User> users = new HashMap<>();

   //Create user
    public User createUser(User user) {
        users.put(user.username, user);
        return user;
    }

    //Read
    public Optional<User> findUserByUsername(String username) {
        return Optional.ofNullable(users.get(username));
    }

    //Update

    //Delete
}
