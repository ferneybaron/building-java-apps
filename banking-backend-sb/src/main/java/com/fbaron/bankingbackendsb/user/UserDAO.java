package com.fbaron.bankingbackendsb.user;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    Map<String, User> users = new HashMap<>();

    public User createUser(User user) {
        users.put(user.username, user);
        return user;
    }
}
