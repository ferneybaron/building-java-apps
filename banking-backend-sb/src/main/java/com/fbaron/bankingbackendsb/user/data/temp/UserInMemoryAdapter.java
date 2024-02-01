package com.fbaron.bankingbackendsb.user.data.temp;

import com.fbaron.bankingbackendsb.user.core.User;
import com.fbaron.bankingbackendsb.user.core.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// Its temp but its repo as its saving and retrival of the data
public class UserInMemoryAdapter implements UserRepository {
    Map<String, User> users = new HashMap<>();

    //Create user
    @Override
    public User saveUser(User user) {
        users.put(user.getUsername(), user);
        return user;
    }

    //Read
    @Override
    public Optional<User> findUserByUsername(String username) {
        return Optional.ofNullable(users.get(username));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
    //Update

    //Delete
}
