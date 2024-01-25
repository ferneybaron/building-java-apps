package com.fbaron.bankingbackendsb.user.business;

import com.fbaron.bankingbackendsb.user.data.UserDAO;

import java.util.Objects;

public class UserService {
    UserDAO userDAO = new UserDAO();

    public User createUser(User user) {
        if (Objects.isNull(user.getUsername()) || Objects.isNull(user.getPassword()) || user.getUsername().isBlank() || user.getPassword().isBlank()) {
            throw new RuntimeException("Username can't be null or blank");
        }
        var userExists = userDAO.findUserByUsername(user.getUsername());
           if(userExists.isPresent()) {
               throw new RuntimeException("User is already exists.");
           }
           User createUser = userDAO.createUser(user);
           return createUser;
       }
}


