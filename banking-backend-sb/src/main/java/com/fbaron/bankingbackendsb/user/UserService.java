package com.fbaron.bankingbackendsb.user;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserService {
    UserDAO userDAO = new UserDAO();
       public User createUser(User user) {
           if (Objects.isNull(user.username) || Objects.isNull(user.password) || user.username.isBlank() || user.password.isBlank())
           {
               throw new RuntimeException("Username can't be null or blank");
           }
           var  userExists = userDAO.findUserByUsername(user.getUsername());
           if(userExists.isPresent()) {
               throw new RuntimeException("User is already exists.");
           }
           User createUser = userDAO.createUser(user);
           return createUser;
       }
}
