package com.fbaron.bankingbackendsb.user.data;

import com.fbaron.bankingbackendsb.user.business.User;
import com.fbaron.bankingbackendsb.user.business.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// Its temp but its repo as its saving and retrival of the data
@Repository
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
