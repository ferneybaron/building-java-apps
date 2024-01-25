package com.fbaron.bankingbackendsb.user;

import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserService {
//    Map<String, User> users = new HashMap<>();
    UserDAO userDAO = new UserDAO();
       public User createUser(User user) {
           if (Objects.isNull(user.username) || Objects.isNull(user.password) || user.username.isBlank() || user.password.isBlank())
           {
               throw new RuntimeException("Username can't be null or blank");
           }
//           users.put(user.username, user);
           User createUser = userDAO.createUser(user);
           return createUser;

       }
}
